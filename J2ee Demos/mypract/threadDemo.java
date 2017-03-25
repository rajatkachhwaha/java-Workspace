class MyThd extends Thread
{
 private int hi,lo;
 
 MyThd(int lo, int hi)
 {
  this.hi=hi;
  this.lo=lo;
  start();
 }
 
 public void run()
 {
  while(lo<=hi)
  {
   System.out.println(lo);
   lo++;
  }
 }
}

class ThreadDemo
{
 public static void main(String arg[])
 {
  MyThd t1=new MyThd(20751,20769);
  MyThd t2=new MyThd(341,350);
  try
  {
   t1.join();
   t2.join();
  }
  catch(InterruptedException e){}
  System.out.println("\nend of code..\n");
 }
}