class Alfa
{
 private int x=1;
 private static int n=10;

 Alfa(){}

 Alfa(int x)
 {
  this.x=x;
 }

 void print()
 {
  System.out.println();
  System.out.println("Alfa(x) : "+x);
 }

 class Beta
 {
  private int n=2;
  //private static int y;		//invalid.. Inner classes cannot contain static declarations  

  Beta(){}

  Beta(int n)
  {
   this.n=n;
  }


  void set(int a,int n)
  {
   x=a;		
   this.n=n; 
  } 

  void display()
  {
   print();
   System.out.println();
   System.out.println("Alfa(x) : "+x);
   System.out.println("Beta(n) : "+n);   
  }
 }
}

class Main
{
 public static void main(String arg[])
 {
  Alfa.Beta b;

  //b=new Alfa.Beta();		//invalid.. Inner class objects must be built upon outer class objects.


  b=new Alfa().new Beta();

  //b.print();			//invalid.. print is not a member of Beta

  Alfa a=new Alfa(100);
  
  Alfa.Beta b1,b2,b3;

  b1=a.new Beta(21);
  b2=a.new Beta(31);
  b3=a.new Beta(41);

  b1.display();

  b2.set(200,101);

  b3.display();      

 }
}
