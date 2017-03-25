class Sample
{
 private int n=1;
 private static int x=2;

 void set(int n,int x)
 {
  this.n=n;

  this.x=x;
    //or
  Sample.x=x;

  print();
  show();
 }

 static void set(int x)
 {
  //n=x;	//invalid.. (1) non-static members cannot be accessed inside static context
  
  //this.x=x;	//invalid.. (2) 'this' and 'super' keywords not allowed inside static context
  
  Sample.x=x;	//ok

  //print();	//invalid.. (1)
  show();	//ok

  Sample s=new Sample();
  s.n=x;
  s.x=x;

  s.print();
  s.show();
 }

 void print()
 {
  System.out.println("n : "+n);
  System.out.println("x : "+x);
 } 

 static void show()
 {
  //System.out.println("n : "+n);		//invalid.. (1)
  System.out.println("x : "+x);
 }
}

class Main
{
 public static void main(String arg[])
 {
  //Sample.set(1,2);			//invalid.. non-static members cannot be accessed using classname
  Sample.show();

  Sample s=new Sample();

  s.set(100);
  s.print();
 }

}