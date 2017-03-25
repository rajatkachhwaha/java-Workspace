//Custom Exception generation and Manual handling

import java.util.*;

class MyExcep extends Exception
{
 private String msg="MyExcep : ";
 
 MyExcep()
 {
  msg=msg+"Unknown Exception..";
 }

 MyExcep(String s)
 {
  msg=msg+s;
 }

 public String toString()
 {
  return msg;
 }
}

class CustomEx
{
 public static void main(String arg[])throws MyExcep
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
    throw new MyExcep("Denominator is Larger..");
   z=x/y;
   System.out.print("\nOperation Sucessful..");
  }gt
  catch(ArithmeticException e)
  {
   System.err.println("\n"+e);
   z=0;
  }
 /* catch(MyExcep e)vfr rrrrrrrrrrrrrrrrrrrrf
  {
   System.err.println("\n"+e);
   z=-1;
  }*/


   
  System.out.println("\nResult : "+z);
 }
}