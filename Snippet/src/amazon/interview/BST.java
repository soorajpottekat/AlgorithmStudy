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
public class BST
{
    Node root;

    private void inorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " | ");
        inorder(node.right);
    }
    private void preOrder(Node node)
    {
        if(node == null)
        {
            return;
        }
        System.out.print(node.val + " | ");
        preOrder(node.left);
        preOrder(node.right);
    }
    private void postOrder(Node node)
    {
        if(node == null)
        {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " | ");
    }

    private int getHeight(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        int lheight  = getHeight(node.left);
        int rheight = getHeight(node.right);
        int height  = 1 + (lheight > rheight ? lheight : rheight);
        return height;
        
         
    }
   class Node
   {
       int val;
       Node left;
       Node right;
       Node(int val)
       {
           this.val = val;
           this.left = null;
           this.right = null;
       }
   }
   public void put(int val)
   {
       root = put(root, val);
   }
   private Node put(Node node, int val)
   {
       if(node == null)
       {
           return new Node(val);
       }
       else if(node.val > val)
       {
           node.left = put(node.left, val);
       }
       else if(node.val < val)
       {
           node.right = put(node.right, val);
       }
       else
       {
           System.out.println("value is alredy present");
       }
       return node;           
   }
   
   public void inorder()
   {
       inorder(root);
   }
   public void preorder()
   {
       preOrder(root);
   }
   public void postorder()
   {
       postOrder(root);
   }
   public int getHeight()
   {
       return getHeight(root);
   }
   public static void main(String[] args)
   {
        BST bst = new BST();
        bst.put(8);
        bst.put(4);
        bst.put(32);
        bst.put(2);
        bst.put(16);
        bst.put(64);
        bst.put(128);
        bst.put(256);
        bst.put(512);
        System.out.println("");
        bst.inorder();
        System.out.println("");
        bst.preorder();
        System.out.println("");
        bst.postorder();
        System.out.println("");
        System.out.println("height = " + bst.getHeight());
   }
}
