import java.util.*;

class jaggedArray
{
 public static void main(String arg[])
 {
  int c;
  System.out.print("Enter the No. of cols: ");
  Scanner sc= new Scanner(System.in);
  c=sc.nextInt();
  int m[][]= new int[c][];
  for(int i=0;i<c;i++)
  {
   m[i]=new int[i+1];
  }
  
  for(int i=0;i<c;i++) 
  {
   for(int j=0;j<i+1;j++)
   { 
   m[i][j]=i+j;
   }
  }

  System.out.println("\n");
  
  for(int i=0;i<c;i++)
  {
   for(int j=0;j<i+1;j++)
   {
    System.out.printf("%7d  ",m[i][j]);
   }
   System.out.println();
  }
 }
}   