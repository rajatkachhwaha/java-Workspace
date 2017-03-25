class Alfa
{
 private int n;
 protected int x,y;

 void set(int n,int x,int y)
 {
  this.n=n;
  this.y=y;
  this.x=x;
 }
 
 void print()
 {
  System.out.println("Alfa(n) : "+n);
  System.out.println("Alfa(x) : "+x);
  System.out.println("Alfa(y) : "+y);
 }

}

class Beta extends Alfa
{
 private String x;

 void set(int n,int x,int y,String s)
 {
  //n of Alfa is not available in Beta.. private members of the Base class are not accessible in the Derived class

  super.x=x;
  this.y=y;
    //or
  super.y=y;

  //instead of all of the above

  set(n,x,y);

  this.x=s;
 } 

 void print()
 {
  super.print();
  System.out.println("Beta(x) : "+x);  
 }
 
}

class Main
{
 public static void main(String arg[])
 {
  Alfa a=new Alfa();
  a.set(1,2,3);
  a.print();				// Alfa(n) : 1
					// Alfa(x) : 2
					// Alfa(y) : 3

  Beta b=new Beta();
  b.set(10,20,30);
  b.print();				// Alfa(n) : 10 
					// Alfa(x) : 20
					// Alfa(y) : 30
					// Beta(x) : null
  b.set(1,2,3,"Mickey");
  b.print(); 				// Alfa(n) : 1 
					// Alfa(x) : 2
					// Alfa(y) : 3
					// Beta(x) : Mickey
 }
}