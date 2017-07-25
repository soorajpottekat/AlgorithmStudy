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
public class BUMergeSort implements ISort
{

    @Override
    public void sort(Comparable[] arr)
    {
        int length = arr.length;
       Comparable[] aux = new Comparable[length];
        for (int sz = 1; sz < length; sz = sz+sz)
        {
            for (int lo = 0; lo < length-sz; lo += sz+sz)
            {
                merge(arr, aux, lo, lo+sz-1, Math.min(lo+sz+sz -1, length -1));
            }                       
        }
    }
    static int x =0;
    private void merge(Comparable a[],Comparable[] aux,int lo,int mid,int hi)
    {
        x++;
        for (int i = lo; i <= hi; i++)
        {
            aux[i] = a[i];            
        }
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if( i > mid)
                a[k] = aux[j++];
            else if(j>hi)
                a[k] = aux[i++];
            else if(SortUtil.less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
            
        }
        if(x == 7)
        {
            System.out.println("");
            for (int k = 0; k < a.length; k++)
            {
                System.out.print(" " + a[k]);
                
            }
        }
            
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        Integer[] arr = new Integer[total];
        for (int i = 0; i < total; i++)
        {
            arr[i] = in.nextInt();
            
        }
        new BUMergeSort().sort(arr);
        System.out.println("");
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
     }

    
    
}
