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
 */
public class MaxPQ<Key extends Comparable<Key>>implements IPriorityQueue
{
    private Key pq[];
    int totalElements;
    
    public MaxPQ(int capacity)
    {
        pq = (Key[])new Comparable[capacity+1];        
    }

    @Override
    public void insert(Object v)
    {
        pq[++totalElements] = (Key)v;
        swim(totalElements);
    }

    @Override
    public Object delMax()
    {
        Key max = pq[1];
        SortUtil.exch(pq, 1, totalElements--);
        sink(1);
        pq[totalElements+1] = null;
        return max;        
    }

    @Override
    public boolean isEmpty()
    {
        return totalElements == 0;
    }
    
    private void sink(int pos)
    {
        
        while (2*pos <= totalElements)            
        {            
            int childPos = 2*pos;
            // find the high value child.
            if(childPos<totalElements && SortUtil.less(pq[childPos], pq[childPos+1])) childPos++;
            if(!SortUtil.less(pq[pos], pq[childPos])) break;
            SortUtil.exch(pq, childPos, pos);
            pos = childPos;
                        
        }
    }
    private void swim(int pos)
    {
        while (pos > 1 && SortUtil.less(pq[pos/2], pq[pos]))
        {
            SortUtil.exch(pq, pos, pos/2);
           pos = pos/2;
        }
    }
    
    public void display()
    {
        System.out.println("");
        for (int i = 1; i <= totalElements; i++)
        {
            System.out.print(" " + pq[i]);
            
        }
        System.out.println("");
        
    }
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        MaxPQ<String> pq = new MaxPQ(20);
        for (int i = 0; i < 10; i++)
        {
            String string = in.next();
            pq.add(string);
            
        }
        
        String node;
        while(true)
        {
            node = in.next();
            switch(node)
            {
                case "-":
                    System.out.println(pq.delMax());
                    break;               
                case "-1":
                    return;
                case "-2":
                    pq.display();
                    break;
                default:
                    pq.insert(node);
                    break;  
            }
            
        }
    
    }

    private void add(String string)
    {
        pq[++totalElements] = (Key)string;
    }
}
