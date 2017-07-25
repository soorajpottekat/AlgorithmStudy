/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snippet;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author soorajpottekat
 */
public class Shuffle
{
    public void shuffle(Comparable[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int ran = ThreadLocalRandom.current().nextInt(0, i+1);
            SortUtil.exch(arr, ran, i);           
            
        }
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
        System.out.println("");
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
    }
}
