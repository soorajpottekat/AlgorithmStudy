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
public class SelectionSort implements ISort
{
    private static int currentPos = 0;

    @Override
    public void sort(Comparable[] arr)
    {
        int min = currentPos;
        for (int i = currentPos; i < arr.length; i++)
        {
            if (!SortUtil.less(arr[min], arr[i]))
            {
                min = i;
            }
            
        }
        SortUtil.exch(arr, min, currentPos);
        currentPos++;
        if(currentPos == arr.length)
        {
            return;
        }
        sort(arr);
                
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        String[] arr = new String[total];
        for (int i = 0; i < total; i++)
        {
            arr[i] = in.next();
            
        }
        new SelectionSort().sort(arr);
        System.out.println("");
        for(String i : arr)
        {
            System.out.print(i + " | ");
        }
    }
    
}
