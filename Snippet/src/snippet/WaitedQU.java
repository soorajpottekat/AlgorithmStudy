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
public class WaitedQU
{
    int[] id;
    int[] sz;
    public WaitedQU(int n)
    {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++)
        {
            id[i] = i;
            sz[i] = 1;
            
        }
    }
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if(i == j)
        {
            return;
        }
        if(sz[i] < sz[j])
        {
            id[i] = j;
            sz[j] += sz[i];
        }
        else
        {
            id[j] = i;
            sz[i] += sz[j];
        }        
    }
    
    public boolean connect(int p, int q)
    {
         return (root(p) == root(q));
    }

    private int root(int i)
    {        
        while(i != id[i])
        {
            i = id[i];
        }
       return i; 
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("W Q Enter the number of nodes=>");
        int nodes = in.nextInt();
        WaitedQU qf = new WaitedQU(nodes);
        System.out.println("Number of unions =>");
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int p = in.nextInt();
            int q = in.nextInt();
            qf.union(p, q);
            
        }
        
        qf.display();
        
    }

    private void display()
    {
        System.out.println("");
        for (int i = 0; i < id.length; i++)
        {
            
            System.out.print(id[i] + " ");
            
        }
        System.out.println("");
    }
}
