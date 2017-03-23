package Linklist;

public class Node 
{
 private int data;
 private Node nextNode;      //declare a node type
 
 public Node (int data)      //constructor
 {
	 this.data=data;
 }
 
 public int getData()        //fetch data
 {
	 return this.data;
 }
 
 public Node getNextNode()   //return node
 {
	 return this.nextNode;
 }
 
 public void setData(int data) //set value 
 {
	 this.data=data;
	 
 }
 
 public void setNextNode( Node nextNode) //set nextNode
 {
	 this.nextNode=nextNode;
 }
 @Override
 public String toString()
 {
	return "data: " + this.data; 
 }
 
 
 
}
