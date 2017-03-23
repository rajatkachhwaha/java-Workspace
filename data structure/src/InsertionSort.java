import java.util.Scanner;

public class InsertionSort 
{
 public static void main(String arg[])
 {
	 int[] a = new int[5];
	 int i,j,temp;
	 Scanner scn= new Scanner(System.in);
	 
	 System.out.println("please enter the values of array");
	 
	 for (i=0;i<a.length;i++)
	 {
		 a[i]=scn.nextInt();
	 }
     System.out.println("list of numbers is");
	 
	 for (i = 0; i < a.length; i++) 
	 {
	  System.out.println(a[i]);
	 }
	 
	 int current;
	 for(i=0;i<a.length;i++)
	 {
		current=a[i];
		j=i-1;
		while ((j>=0) && (a[j]>current))
		{
			a[j+1]=a[j];
			j--;
		}
		a[j+1]=current;
	 }
	 System.out.println("sorted array is");
     for (i=0;i<a.length;i++)
     {
    	 System.out.println(a[i]);
     }
	 
 }
}
