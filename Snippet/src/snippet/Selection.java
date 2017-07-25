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
public class Selection
{
    private Comparable select(Comparable[] arr, int select)
    {
        int lo = 0;
        int hi = arr.length -1;
        while(hi > lo)
        {
            int j = partition(arr,lo,hi);
            if(j<select) lo = j+1;
            else if(j>select) hi = j-1;
            else break;
                
        }
        return arr[select];
        
    }

    private int partition(Comparable[] arr, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        while(true)
        {
            while(SortUtil.less(arr[++i], arr[lo]))
                if(i == hi) break;
            while(SortUtil.less(arr[lo], arr[--j]))
                if(j == lo) break;
            if(j<=i)
            {
                break;
            }
            SortUtil.exch(arr, i, j);
                
        }
        SortUtil.exch(arr, lo, j);
        return j;
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        Integer[] arr = new Integer[total];
        for (int i = 0; i < total; i++)
        {
            arr[i] = i;
            
        }
        new Shuffle().shuffle(arr);
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
        System.out.println(" Select the i th item");
        int select = in.nextInt();
        System.out.println(new Selection().select(arr,select));
        
    }
}
