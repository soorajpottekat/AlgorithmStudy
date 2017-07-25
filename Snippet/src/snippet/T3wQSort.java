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
public class T3wQSort implements ISort
{
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        Integer[] arr = new Integer[total];
        for (int i = 0; i < total; i++)
        {
            if(i%5 == 0)
            {
                arr[i] = i;
            }
            else if(i%3 == 0)
            {
                arr[i] = 3;
            }
            else if(i%2 == 0)
            {
                arr[i] = 7;
            }
            else
            {
                arr[i] = 88;
            }
            
        }
        new Shuffle().shuffle(arr);
        
        new T3wQSort().sort(arr);
        System.out.println("");
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
    }

    @Override
    public void sort(Comparable[] arr)
    {
        sort(arr,0,arr.length -1);
    }

    private void sort(Comparable[] arr, int lo, int hi)
    {
        if(lo>=hi) return;
        int i = lo;
        int lt = lo;
        int gt = hi;
        Comparable v = arr[lo];
        while(i <= gt)
        {
            int comp = arr[i].compareTo(v);
            if(comp < 0) SortUtil.exch(arr, i++, lt++);
            else if(comp > 0) SortUtil.exch(arr, i, gt--);
            else i++;
        }
        sort(arr,lo,lt - 1);
        sort(arr, gt + 1, hi);
    }
    
}
