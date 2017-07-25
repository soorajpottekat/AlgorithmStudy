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
public class LoopLL
{
    Node head;
    class Node 
    {
        int val;
        Node next;
        Node(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    public void addNode(int val)
    {
        Node newnode = new Node(val);
        if(head == null)
        {
           head = newnode;
        }
        else
        {
            newnode.next = head;
            head = newnode;                    
        }
    }
    public boolean checkForLoop()
    {
        if(head == null)
        {
            return false;
        }
        else
        {
            Node slow = head;
            Node fast = head;
            while (fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast)
                {
                    // there is loop
                    return true;
                }
                
            }
            return false;
        }
    }
    public static void main(String[] args)
    {
        LoopLL loopLL = new LoopLL();
        loopLL.addNode(10);
        loopLL.addNode(12);
        loopLL.addNode(32);
        loopLL.addNode(14);
        loopLL.addNode(42);
        loopLL.head.next.next.next.next.next = loopLL.head.next.next.next.next;
        System.out.println(" is there is any lopps" + loopLL.checkForLoop());
    }
    
}
