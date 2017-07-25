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
class TNode 
{
    int val;
    TNode left,right;
    public TNode(int val)
    {
        this.val = val;
    }
}
public class LeftView
{
   TNode root;
   static int MaXLevel = 0;
   public void leftView()
   {
       leftView(root,1);
   }

    private void leftView(TNode node, int level)
    {
        if(node == null)
        {
            return;
        }
        if(MaXLevel < level)
        {
            System.out.print(node.val + " | ");
            MaXLevel++;
        }
        leftView(node.left,level+1);
        leftView(node.right,level+1);
    }
     public static void main(String[] args)
    {
        LeftView lefview = new LeftView();
        lefview.root = new TNode(1);
        lefview.root.left = new TNode(2);
        lefview.root.right = new TNode(3);
        lefview.root.left.left = new TNode(4);
        lefview.root.left.right = new TNode(5);
        lefview.root.right.left = new TNode(6);
        lefview.root.right.right = new TNode(7);
        lefview.root.right.right.left = new TNode(8);
        lefview.leftView();
        System.out.println("");
        System.out.println("get height = " + lefview.getHeight());
        lefview.printLevel();
    }

    private void printLevel()
    {
        int height = getHeight(root);
        for (int i = 0; i < height; i++)
        {
            printCurrentLevel(i,root);
            System.out.println("");
        }
    }

    private int getHeight(TNode node)
    {
        if(node == null)
        {
            return 0;
        }
        int lheight = getHeight(node.left);
        int rheight = getHeight(node.right);
        return lheight > rheight ? 1 + lheight : 1 + rheight; 
    }

    private void printCurrentLevel(int level, TNode node)
    {
        if(node == null) return;
            
        if(level == 0)
        {
            System.out.print(node.val);
        }
        else if(level > 0)
        {
            printCurrentLevel( level - 1, node.left);
            printCurrentLevel( level -1 , node.right);
        }
    }

    private int getHeight()
    {
        return getHeight(root);
    }
}
