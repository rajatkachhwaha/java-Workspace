//Manual Exception generation and Manual handling

import java.util.*;

class ManualExGen
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
   if(y==0)
    throw new ArithmeticException();
   if(y>x)
    throw new IndexOutOfBoundsException("Denominator is Larger..");
   z=x/y;
   System.out.print("\nOperation Sucessful..");
  }
  catch(ArithmeticException e)
  {
   System.err.println("\n"+e);
   z=0;
  }
  catch(IndexOutOfBoundsException e)
  {
   System.err.println("\n"+e);
   z=-1;
  }

   
  System.out.println("\nResult : "+z);
 }
}