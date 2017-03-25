//Automatic Exception generation and Automatic handling

import java.util.*;

class Autoex
{
 public static void main(String arg[])
 {
  Scanner sc=new Scanner(System.in);
  int x,y;
  float z;
   
  System.out.println();
  System.out.print("Enter Value for x : ");
  x=sc.nextInt();
  System.out.print("Enter value for y : ");
  y=sc.nextInt();
   
  z=(float)x/y;
  
  System.out.println("\nResult : "+z);
 }
}