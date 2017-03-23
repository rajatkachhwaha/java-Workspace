package Linklist;

public class LinkedList 
{
 private Node head;              //only contain one element for now
 
 public void insertAtHead( int data)
 {
	Node newNode= new Node (data);  //new object of Node class
	newNode.setNextNode(this.head); //point to current head
	this.head=newNode;              //make the new head
	
	
 }
 
 public int length()
 {
	 
	 int length=0;
	 Node current= this.head;
	 
	 while(current!=null)
	 {
		 length++;
		 current=current.getNextNode();
	  
	 }
	 return length;
 }
 
 
 public void deleteNode()
 {
	 this.head=this.head.getNextNode();
 }
 
 public Node findData(int data)
 {
	 Node current=this.head;
	 
	 while(current!=null)
	 {
		if(current.getData()==data)
		{
			return current;
		}
        current=current.getNextNode();
	 
	 }
	 return null;
 }
 
 
 @Override
 
 public String toString()
 {
	 String result = "{";
	 Node current= this.head;  //declare variable and point it to head
	 
	 while (current !=null)
	 {
		result += current.toString() + ",";
		current= current.getNextNode(); //go to the next node
	 }
 
     result += "}";
     return result;
  }
 
 
 
 
 
}
