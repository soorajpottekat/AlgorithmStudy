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
 */
public class Queue<Item> implements IQueue<Item>
{
    private Node first,last;


    @Override
    public void enqueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;        
        if(isEmpty())
        {
            first = last;
        }
        else
        {
            oldLast.next = last;
        }
    }

    @Override
    public Item deQueue()
    {
        Item val=null;
        if(first != null)
        {
            val = first.item;
            first = first.next;
        }
        return val;
    }

    @Override
    public boolean isEmpty()
    {
        return (first == null);
    }

    
    
    class Node
    {
        Item item;
        Node next;
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Queue q = new Queue<Integer>();
        int node;
        while(true)
        {
            node = in.nextInt();
            switch(node)
            {
                case 0:
                    System.out.println(q.deQueue());
                    break;
//                case "&":
//                    System.out.println(q.peek());
//                    break;
                case -1:
                    return;                        
                default:
                    q.enqueue(node);
                    break;
                    
                            
                    
            }
            
        }
    }
    
}
