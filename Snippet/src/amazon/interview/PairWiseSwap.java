/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon.interview;

import java.util.Scanner;

/**
 *
 * @author soorajpottekat
 */

public class PairWiseSwap
{
    public Node head;
    public Node tail;

    private void addNode(char charAt)
    {
        Node now = new Node(charAt);
        if(head == null)
        {
            head = tail = now;
        }
        else
        {
            tail.next = now;
            tail = now;
        }
    }
private class Node
{
   char val;
   Node next;
   Node(char val)
   {
       this.val = val;
       this.next = null;
   }
}
public void pairSwap()
{
    Node first = head;
    Node second;
    head = null;
    while(first != null)
    {
        if(first.next != null)
        {
            second = first.next;
            first.next = second.next;
            second.next = first;
            first = first.next;
            if(head == null)
            {
                head = second;
            }
        }
        else
        {
            break;
        }
        
    }
    
}
public void displayLL()
    {
        System.out.println("=============== Linked List ============");
        Node tempNode = head;
        while (tempNode != null)
        {
            System.out.print(tempNode.val + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print("NULL");
        System.out.println("");
        System.out.println("=============== END ============");
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String");
        String checkString = in.nextLine();
        PairWiseSwap psl =  new PairWiseSwap();
        for (int i = 0; i < checkString.length(); i++)
        {
            psl.addNode(checkString.charAt(i));
        }
        psl.displayLL();
        psl.pairSwap();
        psl.displayLL();
        psl.pairSwap();
        psl.displayLL();
    }
}
