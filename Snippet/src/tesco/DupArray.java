/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tesco;

import java.io.*;
import  java.util.*;

// Read only region start
class DupArray
{

	public int[] DuplicateArray(int input1,int[] input2){
            // Read only region end
            // Write code here...
            // From examples, Safely Assuming that this array in sorted order.
            // to avoid multipple resizing of the array using array list.
            ArrayList<Integer> dup = new ArrayList();
            int next;
            for (int i = 0; i < input1; i++)
            {
                   next = i + 1;
                   if(next < input1)
                   {
                       if(input2[i] == input2[next])
                       {
                          dup.add(input2[i]);
                       }                       
                   }
            }
            if(dup.isEmpty())
            {
                dup.add(-1);
            }
            int[] dupArray = new int[dup.size()];
            for (int i = 0; i < dupArray.length; i++)
            {
                dupArray[i] = dup.get(i);
                
            }
            return dupArray;
	}
        public static void main(String[] args)
    {
            DupArray dupArray = new DupArray();
            int[] arr = new int[]{4,4,7,8,8,9,9};
            int[] DuplicateArray = dupArray.DuplicateArray(7, arr);
            for (int i = 0; i < DuplicateArray.length; i++)
            {
                System.out.println(DuplicateArray[i]);
            }
            
    }
}
