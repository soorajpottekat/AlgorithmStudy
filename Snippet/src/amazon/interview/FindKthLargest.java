/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon.interview;

import java.util.Scanner;
import snippet.QuickSort;
import snippet.Shuffle;
import snippet.SortUtil;

/**
 *
 * @author soorajpottekat
 */
public class FindKthLargest
{
    public int findKth(Integer[] arr,int k)
    {
        return findKth(arr,k,0,arr.length-1);
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
        System.out.println(" Find K => ");
        int k = in.nextInt();
        FindKthLargest fkl = new FindKthLargest();
        System.out.println("Kth largest => " + fkl.findKth(arr, k));
        for(Integer i : arr)
        {
            System.out.print(i + " | ");
        }
    }

    private int findKth(Integer[] arr, int k, int lo, int hi)
    {
        int lt = lo;
        int gt = hi +  1; // for clearing the loop
        Integer piv = arr[lo];
        while(lt < gt)
        {
            while(piv > arr[++lt]) if(lt == hi) break;
            while(piv < arr[--gt]) if(gt == lo) break;
            if(lt>=gt)
            {
                break;
            }
            SortUtil.exch(arr, lt, gt);            
        }
        SortUtil.exch(arr, lo, gt);
        if( gt == k)
        {
            return arr[gt];
        }
        else if(gt < k)
        {
            return findKth(arr,k,gt+1,hi);
        }
        else
        {
            return findKth(arr,k,0,gt-1);
        }
    }
}
