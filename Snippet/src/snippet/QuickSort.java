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
public class QuickSort implements ISort
{

    @Override
    public void sort(Comparable[] arr)
    {
        sort(arr,0,arr.length-1);
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
        
        new QuickSort().sort(arr);
        System.out.println("");
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
    }

    private void sort(Comparable[] arr, int lo, int hi)
    {
        if(hi<= lo) return;
        
        int j = partiton(arr,lo,hi);
        sort(arr,lo,j-1);
        sort(arr,j+1,hi);
        
    }

    private int partiton(Comparable[] arr, int lo, int hi)
    {
        
        int leftPointer = lo;
        int rightPointer = hi+1;// for the while loop
        while(true)
        {
            while(less(arr[++leftPointer], arr[lo]))
                if(leftPointer == hi) break;
            while(less(arr[lo], arr[--rightPointer]))
                if(rightPointer == lo) break;

            if(leftPointer>=rightPointer)
            {
                break;
            }
            SortUtil.exch(arr, leftPointer, rightPointer);
        }
        SortUtil.exch(arr, lo, rightPointer);
        return rightPointer;
    }
    boolean less(Comparable v, Comparable w)
    {
        return (v.compareTo(w) < 0);
    }
}

