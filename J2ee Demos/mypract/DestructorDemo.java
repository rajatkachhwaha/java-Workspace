class Sample
{
 private int val;

 Sample(int val)
 {
  this.val=val;
  System.out.println("constructing object : "+val);
 }

 protected void finalize()
 {
  System.out.println("destroying object : "+val);
 }

}


class Main
{
 public static void main(String arg[])
 {
  Sample a,b,c;

  a=new Sample(1);
  new Sample(2);
  b=new Sample(3);

  int n=10;
  if(n>5)
  {
   c=new Sample(4);
   Sample d=new Sample(5);
  }

  a=new Sample(6);

  System.out.println();
   
  System.gc();	//forces java to initiate destroying objects in the garbage collection

  try
  {
   Thread.sleep(100);
  }
  catch(InterruptedException e){}
   
  System.out.println("\nend of code..\n");
 }
}