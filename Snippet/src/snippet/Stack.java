/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snippet;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author soorajpottekat
 */
public class Stack<Item> implements IStack<Item>,Iterable<Item>

{
    private Node firstItem;

    public Stack()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push(Item item)
    {
        Node oldFirst = firstItem;
        firstItem = new Node();
        firstItem.item = item;
        firstItem.next = oldFirst;
    }

    @Override
    public Item pop()
    {
        Item val = null;
        if(null != firstItem)
        {
            val = firstItem.item;
            firstItem = firstItem.next;
           
        }
        return val;
    }

    @Override
    public Item peek()
    {
        Item val = null;
        if(null != firstItem)
        {
            val = firstItem.item;           
           
        }
        return val;
    }
    @Override
    public Iterator<Item> iterator()
    {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>
    {
        private Node currentItem = firstItem;

        @Override
        public boolean hasNext()
        {
            return currentItem != null;
        }

        @Override
        public Item next()
        {
            Item it =  currentItem.item;
            currentItem = currentItem.next;
            return it;
        }

        
    }
        
        
        
class Node
{
    Item item;
    Node next;
}

public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Stack<String> s = new Stack();
        String node;
        while(true)
        {
            node = in.next();
            switch(node)
            {
                case "-":
                    System.out.println(s.pop());
                    break;
                case "&":
                    System.out.println(s.peek());
                    break;
                case "-1":
                    return;
                case "-2":
                    System.out.println("");
                    for (String val : s)
                    {
                        System.out.print(val +" | ");
                    }
                    System.out.println("");
                    break;
                default:
                    s.push(node);
                    break;
                    
                            
                    
            }
            
        }
        
    }
        
    
}
