package Linklist;

public class LinkedListDemo
{
 public static void main(String args[])
 {
  LinkedList list = new LinkedList();
  
  list.insertAtHead(5);
  list.insertAtHead(10);
  list.insertAtHead(2);
  list.insertAtHead(12);
  list.insertAtHead(19);
  list.insertAtHead(20);
  System.out.println("found:" +list.findData(12));
  list.deleteNode();
  System.out.println(list);
  System.out.println("The length of the linkedlist is " + list.length());
 
 }
}
