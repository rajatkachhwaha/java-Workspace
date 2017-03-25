class Alfa
{
 private int n;
 protected int x,y,z;

 void set(int n,int x,int y,int z)
 {
  this.n=n;
  this.x=x;
  this.y=y;
  this.z=z;
 }

 void print()
 {
  System.out.println("Alfa(n) : "+n);
  System.out.println("Alfa(x) : "+x);
  System.out.println("Alfa(y) : "+y);
  System.out.println("Alfa(z) : "+z);
 }

 void show()
 {
  System.out.println("Alfa(n) : "+n);
  System.out.println("Alfa(x) : "+x);
  System.out.println("Alfa(y) : "+y);
  System.out.println("Alfa(z) : "+z);
 }

}

class Beta extends Alfa
{
 private int x;
 protected String y;

 void set(int n,int x,int y,int z,int p,String s)
 {
  set(n,x,y,z);
  this.x=p;
  this.y=s;
 }

 void print()
 {
  super.print();
  System.out.println("Beta(x) : "+x);
  System.out.println("Beta(y) : "+y);
 }

 void display()
 {
  System.out.println("Beta(x) : "+x);
  System.out.println("Beta(y) : "+y);
 }
}

class Gama extends Beta
{
 void set(int n,int x,int y,int z,String s)
 {
  //n not available
  //x not available
  //int y not available

  this.z=z;
    //or
  super.z=z;

  this.y=s;
    //or
  super.y=s;
 }
}

class Main
{
 public static void main(String arg[])
 {
  Gama g=new Gama();
  g.set(100,200,300,400);
  g.print();			//invokes print() of Beta

  System.out.println();
  
  g.set(1,2,3,4,"Ronnie");
  g.show();
  g.display();

  
 }
}