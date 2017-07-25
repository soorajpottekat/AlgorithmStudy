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
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int shift_3 = 0;
    private static int shift_5 = 0;
    private static int num = 0;
    private static int inp = 0;
    private static void findDNumber()
        {
        if(num<3)
            {
            return;
        }        
        int rem_3 = num%3;
        // check if the given number is directly divisible by 3
        if(rem_3 == 0)
            {
            shift_3 = num/3;
            return;
        }
        
        
        /**
        *  Checking shifting the 
        */
        int rem5 = (rem_3 + inp * 3) % 5;
        if(rem5 == 0)
            {
            shift_3 = num/3 - inp;
            shift_5 = (rem_3 + inp * 3) / 5;
            return;
            }
          inp++;
        if((inp * 3 + rem_3)> num)
        {
           shift_3 = 0;
           shift_5 = 0;
           return; 
        }
        
        findDNumber();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            num = n;
            findDNumber();
            if(shift_3==0 && shift_5==0)
                {
                System.out.println("-1");
            }
            else
                {
                for(int k = 0; k< shift_3*3;k++)
                    {
                    System.out.print("5");
                }
                for(int l = 0; l< shift_5*5;l++)
                    {
                    System.out.print("3");
                }
                System.out.println();                
            }
            shift_3=0; 
            shift_5=0;
            inp = 0;
        }
    }
}
