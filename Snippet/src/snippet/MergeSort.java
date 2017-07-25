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
public class MergeSort implements ISort
{

    @Override
    public void sort(Comparable[] arr)
    {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr,aux,0,arr.length-1);
    }
    
    private void sort(Comparable[] arr, Comparable[] aux, int lo,int hi)
    {
        if(hi<=lo)
        {
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid+1, hi);
        merge(arr, aux, lo, mid, hi);
    }
    //static int x = 0;
    private void merge(Comparable a[],Comparable[] aux,int lo,int mid,int hi)
    {
        //x++;
        for (int i = lo; i <= hi; i++)
        {
            aux[i] = a[i];            
        }
        int leftArrPointer = lo;
        int rightArrPointer = mid+1;
        for (int i = lo; i <= hi; i++)
        {
            if( leftArrPointer > mid)
                a[i] = aux[rightArrPointer++];
            else if(rightArrPointer>hi)
                a[i] = aux[leftArrPointer++];
            else if(SortUtil.less(aux[rightArrPointer], aux[leftArrPointer]))
                a[i] = aux[rightArrPointer++];
            else
                a[i] = aux[leftArrPointer++];
            
        }
//        if(x==7)
//        {
//            System.out.println("");
//            for (int k = 0; k < a.length; k++)
//            {
//                System.out.print(" " + a[k]);
//                
//            }
//        }
        
            
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print(" Enter the number of elements ?   ");
        int total = in.nextInt();
        Integer[] arr = new Integer[total];
        for (int i = 0; i < total; i++)
        {
            arr[i] = in.nextInt();
            
        }
        new MergeSort().sort(arr);
        System.out.println("");
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
    }

    
    
}
