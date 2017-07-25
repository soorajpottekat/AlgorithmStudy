/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon.interview;

import java.util.Scanner;
import snippet.Stack;

/**
 *
 * @author soorajpottekat
 */
public class PalindromeSingleLL
{
    private LLNode head = null;
    private LLNode tail = null;
    class LLNode{
        char value;
        LLNode next;        
    }
    public void addNode(char c)
    {
        LLNode newNode = new LLNode();
        newNode.value  = c;
        if(head == null)
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void displayLL()
    {
        System.out.println("=============== Linked List ============");
        LLNode tempNode = head;
        while (tempNode != null)
        {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print("NULL");
        System.out.println("");
        System.out.println("=============== END ============");
    }
    public boolean isPaliandrome()
    {
        LLNode tempNode = head;
        Stack<LLNode> stack = new Stack<LLNode>();
        while (tempNode != null)
        {
          stack.push(tempNode);
          tempNode = tempNode.next;
        }
        boolean isPali = true;
        tempNode = head;
        while (tempNode != null)
        {
            LLNode pop = stack.pop();
            if(tempNode.value != pop.value)
            {
                isPali = false;
                break;
            }
            tempNode = tempNode.next;
        }
        return isPali;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String");
        String checkString = in.nextLine();
        PalindromeSingleLL psl =  new PalindromeSingleLL();
        for (int i = 0; i < checkString.length(); i++)
        {
            psl.addNode(checkString.charAt(i));
        }
        psl.displayLL();
        System.out.println(" ==== Is pali " + psl.isPaliandrome());
    }
}
