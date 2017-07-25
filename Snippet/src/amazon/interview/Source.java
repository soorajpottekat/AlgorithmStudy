/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon.interview;

// Java 7 program to read an integer from STDIN and output it to STDOUT
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Class name should be "Source",
// otherwise solution won't be accepted
public class Source {
    private static HashMap<Integer,Integer> map = new HashMap();
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int[] arr;
        int arrSize = in.nextInt();
        int numQueries = in.nextInt();
        arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++)
        {
            arr[i] = in.nextInt();
        }
        
        for (int i = 0; i < numQueries; i++)
        {
            int first = in.nextInt();
            int last = in.nextInt();
            System.out.println(CalculateBeautyNumber(arr,first-1,last-1));
        }
        
   }

    private static BigInteger CalculateBeautyNumber(int[] array, int first, int last)
    {
        map.clear();
        for (int i = first; i <= last; i++)
        {
            Integer count = map.get(array[i]);
            if(count == null)
            {
                count = 1;                
            }
            else
            {
                count++;                
            }
            map.put(array[i], count);
        }
        BigInteger beauty = new BigInteger("0");
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int number = entry.getKey();
            int count  = entry.getValue();            
            beauty = beauty.add( BigInteger.valueOf(count * count * number));
       }
        return beauty;
    }
}

