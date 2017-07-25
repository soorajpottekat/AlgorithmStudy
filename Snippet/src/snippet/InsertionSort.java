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
public class InsertionSort implements ISort
{

    @Override
    public void sort(Comparable[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if(SortUtil.less(arr[j], arr[j-1]))
                {
                    SortUtil.exch(arr, j, j-1);
                }
                else
                {
                    break;
                }
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
        new InsertionSort().sort(arr);
        System.out.println("");
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
    }
    
}
