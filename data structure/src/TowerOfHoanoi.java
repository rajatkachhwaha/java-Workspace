
public class TowerOfHoanoi 
{

	
	
	 public void move(int numberOfDiscs, char from, char to, char inter)
	 {
	  if(numberOfDiscs==1)
	  {
		  System.out.println("Move Disc 1 from " +from + " to " + to);
		  
	  }
	  else
	  {
		  move(numberOfDiscs-1, from, inter, to);
		  System.out.println("Move Disc " +numberOfDiscs + " from " + from + " to " +to);
		  move(numberOfDiscs-1, inter, to, from);
	  }
	 
	 }	
	 
	 public static void main(String args[])
	 {
		TowerOfHoanoi Toh= new TowerOfHoanoi();
		Toh.move(3, 'A', 'C','B');
	 }
		

	

}
