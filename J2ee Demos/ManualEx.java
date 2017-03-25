//Automatic Exception generation and Manual handling

import java.util.*;

class ManualEx
{
 public static void main(String arg[])
 {
  Scanner sc=new Scanner(System.in);
  int x,y,z;
  
   
  System.out.println();
  System.out.print("Enter Value for x : ");
  x=sc.nextInt();
  System.out.print("Enter value for y : ");
  y=sc.nextInt();
  try
  {
   z=x/y;
   System.out.print("\nOperation Sucessful..");
  }
  catch(ArithmeticException e)
  {
   System.err.println("\n"+e);
   System.err.println("\n------------------");
   System.err.println("\nMessage : "+e.getMessage());
   System.err.println("Stack Trace - ");
   e.printStackTrace();
   z=0;
  }
    
  System.out.println("\nResult : "+z);
 }
}