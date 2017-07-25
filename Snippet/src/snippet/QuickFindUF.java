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
public class QuickFindUF
{
    
    private int id[];
    public QuickFindUF(int n)
    {
        id = new int[n];
        for (int i = 0; i < n; i++)
        {
            id[i] = i;
            
        }
    }
    
    public boolean isConnected(int p, int q)
    {
        return id[p] == id [q];
    }
    
    public void union(int p, int q)
    {
        if(isConnected(p, q))
        {
            return;
        }
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
        {
            if(id[i] == pid)
            {
                id[i] = qid;
            }
            
        }
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("QuickFindUF Enter the number of nodes=>");
        int nodes = in.nextInt();
        QuickFindUF qf = new QuickFindUF(nodes);
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
