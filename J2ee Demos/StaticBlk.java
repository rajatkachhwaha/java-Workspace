class Sample
{
 int n=1;
 static int x=10;

 Sample()
 {
  System.out.println("\ninside default constructor..");
  System.out.println("n : "+n);
  System.out.println("x : "+x);
 }

 Sample(int n)
 {
  System.out.println("\ninside argumented constructor..");
  System.out.println("n : "+this.n);
  System.out.println("x : "+x);
 }

 static void print()
 {
  System.out.println("\nprint(x) : "+x);
 }

 static
 {
  System.out.println("\ninside static block..");
  System.out.println("x : "+x);
  x=100;
 }
}

class Main
{
 public static void main(String arg[])
 {
  Sample s;		//creating an object reference does not invoke static block

  //Sample.print();	//static-block invoked first and then the print() method
			//output -
			//		inside static block
			//		x : 10
			//
			//		print(x) : 100


  //System.out.println("\nmain(x) : "+Sample.x);	//static block invoked first and then this statement is executed
	
  
  //Sample.x=200;					//static block invoked first and then x is set with 200
  //System.out.println("\nmain(x) : "+Sample.x);  


  s=new Sample(2);					//static block invoked first and then the constructor

 }
}