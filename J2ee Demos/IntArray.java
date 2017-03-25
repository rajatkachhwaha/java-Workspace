import java.util.*;

class IntArray
{
 public static void main(String arg[])
 { 
  Scanner sc= new Scanner(System.in);
  int n;
  System.out.print("\nEnter the No. of Integes to Input : ");
  n=sc.nextInt();
  
  System.out.println();

  int arr[]=new int[n];
  
  for(int i=0;i<n;i++)
  {
   System.out.print("Enter a Number : ");
   arr[i]=sc.nextInt();
  }
    
  Arrays.sort(arr);
  
  System.out.println("\nItems in Sorted Order..\n");
  for(int x:arr)
  {
   System.out.println(x);  
  }
  
  
 }
}