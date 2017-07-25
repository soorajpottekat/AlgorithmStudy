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
public class BST<Key extends Comparable<Key>, Value>
{
    Node root;

    


    private class Node
    {
        Node leftPointer;
        Node rightPointer;
        Key k;
        Value v;
        int count;
        Node(Key k, Value v, int count)
        {
            this.k = k;
            this.v = v;
            this.count = count;
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
        if(x == null) return new Node(k, v,1);
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
    
    public void delMin()
    {
        root = delMin(root);
    }

    private Node delMin(Node x)
    {
        if(x==null) return null;
        if(x.leftPointer == null) return x.rightPointer;
        x.leftPointer = delMin(x.leftPointer);
        x.count = 1+size(x.leftPointer) + size(x.rightPointer);
        return x;
    }

    public void delete(Key k)
    {
        root = delete(root,k);
    }
    
    private Node delete(Node x, Key k)
    {
        if(x == null) return null;
        int comp = k.compareTo(x.k);
        if(comp < 0) x.leftPointer = delete(x.leftPointer, k);
        else if(comp > 0) x.rightPointer = delete(x.rightPointer, k);
        else
        {
            if(x.leftPointer == null) return x.rightPointer;
            if(x.rightPointer == null) return x.leftPointer;
            Node t = x;
            x = min(t.rightPointer);
            x.rightPointer = delMin(t.rightPointer);
            x.leftPointer = t.leftPointer;            
        }
        x.count = 1+size(x.leftPointer) + size(x.rightPointer);
        return x;
    }
    public void inorder()
    {
        inorder(root);
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
        BST<Integer,Integer> bst = new BST<>();
        int read;
        String opt;
        while (true)
        {  
            System.out.println(" - insert");
            System.out.println(" = delete");
            System.out.println(" 0 rank");
            System.out.println(" 9 floor");
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
                        bst.put(read, read);
                    }
                    break;
                case "=":
                    System.out.println("Enter key to delete =>");
                    read = in.nextInt();
                    bst.delete(read);
                    break;
                case "0":
                    System.out.println("Enter rank key =>");
                    read = in.nextInt();
                    System.out.println("rank of key " +read + "is "+bst.rank(read));
                    break;
                case "9":
                    System.out.println("Enter floor key =>");
                    read = in.nextInt();
                    System.out.println("floor of key " +read + "is "+bst.floor(read));
                    break;
                case "8":
                    System.out.println("Enter ceil key =>");
                    read = in.nextInt();
                    System.out.println("ceil of key " +read + "is "+bst.ceil(read));
                    break; 
                case "7":
                    System.out.println("min is "+bst.min());
                    break;
                case "6":
                    
                    System.out.println("max is "+bst.max());
                    break;
                case "5":
                    System.out.println("Enter get key =>");
                    read = in.nextInt();
                    System.out.println("get of key " +read + "is "+bst.get(read));
                    break; 
                case "4":
                    bst.inorder();
                    break;
                case "3":
                    bst.preOrder();
                    break;
                case "2":
                    bst.postOrder();
                    break; 
                case "1":
                    return;
                    
            }
            
        }
    }
}
