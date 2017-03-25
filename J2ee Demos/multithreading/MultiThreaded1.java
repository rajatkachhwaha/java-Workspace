//MultiThreading by extending thread


class MyThd extends Thread
{
 private int lo,hi;

 MyThd (int lo,int hi)
 {
  this.lo=lo;
  this.hi=hi;
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

class MultiThreaded1
{ 
 public static void main(String arg[])
 {
  MyThd t1= new MyThd(521,530);
  MyThd t2=new MyThd(70965,70975);

  try
  {
   t1.join();
   t2.join();
  }
  catch(InterrutedException exc){}
    
  System.out.println("\nend of code..\n");
 }
}