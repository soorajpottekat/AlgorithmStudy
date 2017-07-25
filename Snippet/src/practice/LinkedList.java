/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

/**
 *
 * @author soorajpottekat
 */
public class LinkedList
{
    Node head;

    private int count(Node node)
    {
        if(node == null) return 0;
        
        return 1+count(node.next);
        
    }

    private void reverse()
    {
        head = reverse(head, null);
    }
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data =  data;
            this.next = null;
        }
    }
    public void delete(int data)
    {
        if(head == null) return;
        
        if(head.data == data)
        {
            head = head.next;
            return;
        }
        
        Node current = head.next;
        Node previous =  head;
        while(current != null)            
        {
            if(current.data == data)
            {
                previous.next = current.next;
                current.next = null;
                break;
            }
            previous = current;
            current = current.next;
        }
    }
    public void addNode(int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public void display()
    {
        Node temp = head;
        System.out.println("---------------------------");
        while(temp != null)
        {
            System.out.print("|"+temp.data+"|->");
            temp = temp.next;
        }
        
        System.out.print("null");
        System.out.println("");
        System.out.println("---------------------------");
    }
    private Node reverse(Node currNode, Node prevNode)
    {
        if(currNode.next == null)
        {
            head = currNode;
            currNode.next = prevNode;
            return null;
        }
        Node curNext = currNode.next;
        currNode.next = prevNode;
        reverse(curNext, currNode);
        return head;
        
    }
    public int count()
    {
        return count(head);
    }
    public static void main(String[] args)
    {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(5);
        linkedList.addNode(3);
        linkedList.addNode(1);
        linkedList.addNode(4);
        linkedList.addNode(8);
        linkedList.addNode(7);
        linkedList.addNode(0);
        linkedList.addNode(9);
        linkedList.addNode(6);
        linkedList.addNode(10);
        linkedList.display();
        linkedList.delete(7);
        linkedList.display();
        linkedList.delete(5);
        linkedList.display();
        linkedList.delete(10);
        linkedList.display();
        linkedList.delete(20);
        linkedList.display();
        System.out.println(linkedList.count());
        linkedList.reverse();
        linkedList.display();
    }
}
