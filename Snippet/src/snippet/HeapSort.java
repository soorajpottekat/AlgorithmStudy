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
 * 
 */
public class HeapSort implements ISort
{
    private Comparable pq[];
    int totalElements;
    private void sink(int pos)
    {
        
        while (2*pos + 1 <= totalElements)            
        {
            
            int childPos = 2*pos+1;

            // find the high value child.
            if(childPos<totalElements && SortUtil.less(pq[childPos], pq[childPos+1])) childPos++;
            if(!SortUtil.less(pq[pos], pq[childPos])) break;
            SortUtil.exch(pq, childPos, pos);
            pos = childPos;
                        
        }
    }
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        Integer[] arr = new Integer[total];
        for (int i = 0; i < total; i++)
        {
            arr[i] = i;            
        }
        new Shuffle().shuffle(arr);
        new HeapSort().sort(arr);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
            
        }
    
    }

    @Override
    public void sort(Comparable[] arr)
    {
        totalElements = arr.length - 1;
        pq = arr;
        for (int i = totalElements/2; i >=0 ; i--)
        {
            sink(i);
            
        }
        // result of the above code is a heap ordered array
        while (totalElements > 0)
        {
            SortUtil.exch(arr, 0, totalElements--);
            sink(0);
            
        }
        
    }
}
