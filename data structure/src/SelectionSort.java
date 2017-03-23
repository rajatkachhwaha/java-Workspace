import java.util.Scanner;

public class SelectionSort
{
 public static void main(String args[])
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
	 
	 for(i=0;i<a.length;i++)
	 {
		int min=i;
		for (j=i+1;j<a.length;j++)
		{
			if (a[j]<a[min])
			{
				min=j;
				
				temp=a[min];
				a[min]=a[i];
				a[i]=temp;
			}
		}
	 }
	 System.out.println("sorted array is");
     for (i=0;i<a.length;i++)
     {
    	 System.out.println(a[i]);
     }
	 
 }
}
