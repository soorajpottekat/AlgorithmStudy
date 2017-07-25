/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snippet;

import java.util.Scanner;

/**
 *
 * @author soorajpottekat
 * @param <Key>
 * @param <Value>
 */
public class RBTree<Key extends Comparable<Key>, Value>
{
    Node root;
    private static boolean RED = true;
    private static boolean BLACK = false;

    
    
    private class Node
    {
        Node leftPointer;
        Node rightPointer;
        Key k;
        Value v;
        int count;
        boolean colour;
        Node(Key k, Value v, int count,boolean colour)
        {
            this.k = k;
            this.v = v;
            this.count = count;
            this.colour = colour; 
        }
    }
    public Value get(Key k)
    {
        Node x=root;       
        while (x != null)
        {
            int comp = k.compareTo(x.k);
            if(comp < 0)
               x=x.leftPointer;
            else if(comp>0)
                x=x.rightPointer;
            else
               return x.v;            
        }
        return null;        
    }
    public void put(Key k, Value v)
    {
        root = put(root, k, v);
    }
    public int size()
    {
        return size(root);
    }
    private int size(Node x)
    {
        if(x ==null)
            return 0;
        return x.count;
    }
    private Node put(Node x,Key k,Value v)
    {
        if(x == null) return new Node(k, v,1,RED);
        int comp = k.compareTo(x.k);
        if(comp<0)
        {
            x.leftPointer = put(x.leftPointer, k, v);
        }
        else if(comp>0)
        {
            x.rightPointer = put(x.rightPointer, k, v);
        }
        else
        {
            x.v = v;
        }
        x.count =1 + size(x.leftPointer) + size(x.rightPointer);
        if(isRed(x.rightPointer) && !isRed(x.leftPointer)) x = rotateLeft(x);
        if(isRed(x.leftPointer) && isRed(x.leftPointer.leftPointer)) x= rotateRight(x);
        if(isRed(x.leftPointer) && isRed(x.rightPointer)) flipcolour(x);
        return x;
    }
    
    public int rank(Key k)
    {
        return rank(k,root);
    }
    private int rank(Key k, Node x)
    {
        if(x==null) return 0;
        int comp = k.compareTo(x.k);
        if(comp < 0) return rank(k,x.leftPointer);
        else if (comp > 0) return 1 + size(x.leftPointer) + rank(k, x.rightPointer);
        else return size(x.leftPointer);
    }
    public Node min()
    {
        return min(root);
    }

    private Node min(Node x)
    {
        if(x == null) return null;        
        while(x.leftPointer == null)
            x=x.leftPointer;
        return x;
    }
    public Key max()
    {
        if(root == null) return null;
        Node x =root;
        while(x.rightPointer == null)
            x=x.rightPointer;
        return x.k;
    }
    public Key floor(Key k)
    {
        Node x = floor(root,k);
        if(x==null) return null;        
        return x.k;    
        
    }
    private Node floor(Node x, Key k)
    {
        if(x == null) return null;
        int comp =  k.compareTo(x.k);
        if(comp == 0) return x;
        else if(comp < 0) return floor(x.leftPointer, k);

            Node t = floor(x.rightPointer, k);
            if(t != null)
            {
                return t;
            }

        return x;
    }
    public Key ceil(Key k)
    {
        Node x = ceil(root,k);
        if(x==null) return null;        
        return x.k; 
    }
    
    private Node ceil(Node x, Key k)
    {
        if(x == null) return null;
        int comp =  k.compareTo(x.k);
        if(comp == 0) return x;
        else if(comp > 0) return ceil(x.rightPointer, k);
        else
        {
            Node t = ceil(x.leftPointer, k);
            if(t != null)
            {
                return t;
            }
            
        }
        return x;
    }
    
    int height(Node node)
    {
        if(node == null) return 0;
        else
        {
            int lheight = height(node.leftPointer);
            int rheight = height(node.rightPointer);
            if(lheight>rheight)
                return lheight + 1;
            else
                return rheight +1;
        }
    }
    
    public int height()
    {
        return height(root);
    }
    public void levelOrder()
    {
        int height = height(root);
        for (int i = 1; i <= height; i++)
        {
          printCurrentLevel(root,i);
          System.out.println("");
        }
    }
    private void printCurrentLevel(Node node, int level)
    {
        if(node == null)
            return;
        if(level == 1)
            System.out.print("["+node.v+" "+node.colour+" ] ");
        if(level > 1)
        {
            printCurrentLevel(node.leftPointer, level - 1);
            printCurrentLevel(node.rightPointer, level -1);
        }
    }
//    public void delMin()
//    {
//        root = delMin(root);
//    }

//    private Node delMin(Node x)
//    {
//        if(x==null) return null;
//        if(x.leftPointer == null) return x.rightPointer;
//        x.leftPointer = delMin(x.leftPointer);
//        x.count = 1+size(x.leftPointer) + size(x.rightPointer);
//        return x;
//    }
//
//    public void delete(Key k)
//    {
//        root = delete(root,k);
//    }
//    
//    private Node delete(Node x, Key k)
//    {
//        if(x == null) return null;
//        int comp = k.compareTo(x.k);
//        if(comp < 0) x.leftPointer = delete(x.leftPointer, k);
//        else if(comp > 0) x.rightPointer = delete(x.rightPointer, k);
//        else
//        {
//            if(x.leftPointer == null) return x.rightPointer;
//            if(x.rightPointer == null) return x.leftPointer;
//            Node t = x;
//            x = min(t.rightPointer);
//            x.rightPointer = delMin(t.rightPointer);
//            x.leftPointer = t.leftPointer;            
//        }
//        x.count = 1+size(x.leftPointer) + size(x.rightPointer);
//        return x;
//    }
    public void inorder()
    {
        inorder(root);
    }
    private boolean isRed(Node h)
    {
        if (h == null) return false;
        return h.colour == RED;
    }
    private Node rotateLeft(Node h)
    {
        assert isRed(h);
        Node x = h.rightPointer;
        h.rightPointer = x.leftPointer;
        x.leftPointer = h;
        x.colour = h.colour;
        h.colour = RED;
        return x;
    }
    
    private Node rotateRight(Node h)
    {
        assert isRed(h.leftPointer);
        Node x = h.leftPointer;
        h.leftPointer = x.rightPointer;
        x.rightPointer = h;
        x.colour = h.colour;
        h.colour = RED;
        return x;
    }
    private void flipcolour(Node h)
    {
        assert !isRed(h);
        assert isRed(h.rightPointer);
        assert isRed(h.leftPointer);
        h.colour = RED;
        h.leftPointer.colour = BLACK;
        h.rightPointer.colour = BLACK;
    }
    private void inorder(Node x)
    {
        if(x == null ) return;
        inorder(x.leftPointer);
        System.out.println(x.k);
        inorder(x.rightPointer);
    }
    public void preOrder()
    {
        preOrder(root);
    }
    private void preOrder(Node x)
    {
        if(x == null ) return;
        System.out.println(x.k);
        preOrder(x.leftPointer);
        preOrder(x.rightPointer);
    }

    public void postOrder()
    {
        postOrder(root);
    }
    private void postOrder(Node x)
    {
        if(x == null ) return;
        
        postOrder(x.leftPointer);
        postOrder(x.rightPointer);
        System.out.println(x.k);
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        RBTree<Integer,Integer> rbst = new RBTree<>();
        int read;
        String opt;
        while (true)
        {  
            System.out.println(" - insert");
            System.out.println(" 0 height");
            System.out.println(" 9 level Order");
            System.out.println(" 8 ceil");
            System.out.println(" 7 min");
            System.out.println(" 6 max");
            System.out.println(" 5 get");
            System.out.println(" 4 inorder");
            System.out.println(" 3 pre order");
            System.out.println(" 2 post order");
            opt = in.next();            
            switch(opt)
            {
                case "-":
                    while ((read = in.nextInt()) != -1)
                    {
                        rbst.put(read, read);
                    }
                    break;                
                case "0":
                    System.out.println(" Height of the tree =" + rbst.height());
                    break;
                case "9":
                    rbst.levelOrder();
                    break;
                case "8":
                    System.out.println("Enter ceil key =>");
                    read = in.nextInt();
                    System.out.println("ceil of key " +read + "is "+rbst.ceil(read));
                    break; 
                case "7":
                    System.out.println("min is "+rbst.min());
                    break;
                case "6":
                    
                    System.out.println("max is "+rbst.max());
                    break;
                case "5":
                    System.out.println("Enter get key =>");
                    read = in.nextInt();
                    System.out.println("get of key " +read + "is "+rbst.get(read));
                    break; 
                case "4":
                    rbst.inorder();
                    break;
                case "3":
                    rbst.preOrder();
                    break;
                case "2":
                    rbst.postOrder();
                    break; 
                case "1":
                    return;
                    
            }
            
        }
    }
}
