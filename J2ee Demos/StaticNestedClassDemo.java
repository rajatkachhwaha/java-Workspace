class Alfa
{
 private int x=1;
 private static int n=10;

 void print()
 {
  System.out.println();
  System.out.println("Alfa(x) : "+x);
  System.out.println("Alfa(n) : "+n);
 }

 static void show()
 {
  System.out.println();
  System.out.println("Alfa(n) : "+n);
 }

 static class Beta
 {
  private String n;

  void set(int x,int n,String s)
  {
   //x of Alfa not available.. non-static members of the outer class are not accessible inside static nested class

   Alfa.n=n;
  
   this.n=s;
  } 

  void display()
  {
   //print();	  //invalid..

   show();
   
   System.out.println();
   System.out.println("Alfa(n) : "+Alfa.n);
   System.out.println("Beta(n) : "+n);
  }
 }
}

class Main
{
 public static void main(String arg[])
 {
  //Beta b;	//invalid.. Beta is nested inside the scope of Alfa

  Alfa.Beta b;

  b=new Alfa.Beta();

  //b.print();	//invalid.. print() is not a member of Beta
  //b.show();	//invalid..        --- do ----

  b.set(100,30,"rajat");
  b.display();  

 }
}
