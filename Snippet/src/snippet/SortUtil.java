/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snippet;

/**
 *
 * @author soorajpottekat
 */
public class SortUtil
{
    public static boolean less(Comparable v, Comparable w)
    {
        return (v.compareTo(w) < 0);
    }
    
    public static void exch(Comparable[] arr, int i, int j)
    {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}
