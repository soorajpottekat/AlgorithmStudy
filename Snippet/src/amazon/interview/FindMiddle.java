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

public class FindMiddle
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
public char findMiddle()
{
    Node fast_node = head;
    Node slow_node = head;
    while(fast_node != null)
    {
        if(fast_node.next != null && fast_node.next.next != null)
        {
            fast_node = fast_node.next.next;
            slow_node = slow_node.next;
        }
        else
        {
            break;
        }
        
    }
    return slow_node.val;
}
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String");
        String checkString = in.nextLine();
        FindMiddle psl =  new FindMiddle();
        for (int i = 0; i < checkString.length(); i++)
        {
            psl.addNode(checkString.charAt(i));
        }
        
        System.out.println(" ==== Middle is " + psl.findMiddle());
    }
}
