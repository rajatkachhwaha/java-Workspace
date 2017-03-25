import java.util.Scanner;

class PascalTriangle
{
 public static void main(String arg[])
 {
  Scanner sc= new Scanner(System.in);

  int n;
  System.out.print("Enter the No. of Rows : ");
  n=sc.nextInt();

  int m[][]= new int[n][];
  for(int i=0;i<n;i++)
  {
   m[i]=new int[i+1];
  }
  
  for(int i=0;i<n;i++) 
  {
   m[i][0]=m[i][i]=1;

   for(int j=1;j<i;j++)
   { 
    m[i][j]=m[i-1][j-1]+m[i-1][j];
   } 
  }

  System.out.println("\n");
  
  for(int terms[] : m)
  {
   for(int x : terms)
   {
    System.out.printf("%6d ",x);
   }
   System.out.println();
  }
 }
}
   