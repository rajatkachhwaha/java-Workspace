import java.util.Scanner;
 
class MatrixDemo
{
 public static void main(String arg[])
 {
  Scanner sc=new Scanner(System.in);
  int r,c;
  System.out.print("\nEnter the No. of Rows : ");
  r=sc.nextInt();
  System.out.print("Enter the No. of Cols : ");
  c=sc.nextInt();
  
  int m[][]=new int[r][c]; 
  
  System.out.println(); 
  for(int i=0;i<r;i++)
  {
   for(int j=0;j<c;j++)
   {
    System.out.print("Item["+i+","+j+"] : ");
    m[i][j]=sc.nextInt();
   }
   System.out.println();
  }
 
  System.out.println("\n");
  
  for(int i=0;i<r;i++)
  {
   for(int j=0;j<c;j++)
   {
    System.out.printf("%7d  ",m[i][j]);
   }
   System.out.println();
  }
 }
}
  
  