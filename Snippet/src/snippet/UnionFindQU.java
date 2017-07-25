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
public class UnionFindQU
{
    int[] id;
    public UnionFindQU(int n)
    {
        id = new int[n];
        for (int i = 0; i < n; i++)
        {
            id[i] = i;
            
        }
    }
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
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
        System.out.print("Enter the number of nodes=>");
        int nodes = in.nextInt();
        UnionFindQU qf = new UnionFindQU(nodes);
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
