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
public class ShellSort implements ISort
{

    @Override
    public void sort(Comparable[] arr)
    {
        int n = arr.length;
        int h = 1;
        while(h < n/3) h=3*h+1;
        
        while (h>=1)
        {
            for (int i = h; i < n; i++)
            {
                for (int j = i; j > -h && SortUtil.less(arr[j], arr[j-h]); j -=h)
                {
                    SortUtil.exch(arr, j, j-h);
                }
            }
            h =  h/3;
            
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
        new InsertionSort().sort(arr);
        System.out.println("");
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
    }
    
}
