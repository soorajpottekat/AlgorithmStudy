/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon.interview;

/**
 *
 * @author soorajpottekat
 */
class Node
    {
        int value;
        Node leftPointer,rightPointer;
        Node(int value)
        {
            this.value = value;
        }
    }
public class BTree
{
    public Node root;

    private Node findLCA(Node node, int num1, int num2)
    {
        if(node == null) return null;
        if(node.value == num1 || node.value == num2)
        {
            return node;
        }
        Node lsubtree = findLCA(node.leftPointer, num1, num2);
        Node rsubtree = findLCA(node.rightPointer, num1, num2);
        if(lsubtree != null && rsubtree != null)
            return node;
       return lsubtree != null ? lsubtree : rsubtree;
    }
    
    public Node findLCA(int num1,int num2)
    {
        return findLCA(root,num1, num2);
    }
    
    public static void main(String[] args)
    {
        BTree fca = new BTree();
        fca.root = new Node(1);
        fca.root.leftPointer = new Node(2);
        fca.root.rightPointer = new Node(3);
        fca.root.leftPointer.leftPointer = new Node(4);
        fca.root.leftPointer.rightPointer = new Node(5);
        fca.root.rightPointer.leftPointer = new Node(6);
        fca.root.rightPointer.rightPointer = new Node(7);
        System.out.println("LCA(4, 5) = " +
                            fca.findLCA(4, 5).value);
        System.out.println("LCA(4, 6) = " +
                            fca.findLCA(4, 6).value);
        System.out.println("LCA(3, 4) = " +
                            fca.findLCA(3, 4).value);
        System.out.println("LCA(2, 4) = " +
                            fca.findLCA(2, 4).value);
         System.out.println("LCA(6, 7) = " +
                            fca.findLCA(6, 7).value);
         System.out.println("LCA(2, 7) = " +
                            fca.findLCA(1, 7).value);
    }
}
