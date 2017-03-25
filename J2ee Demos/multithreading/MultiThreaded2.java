//Multithreading by implementing the Runnable Interface


class MyThd implements Runnable
{
 private int lo,hi;

 private Thread thd;
 MyThd (int lo,int hi)
 {
  this.lo=lo;
  this.hi=hi;
  thd=new Thread(this);
  thd.start();
  
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

class MultiThreaded2
{ 
 public static void main(String arg[])
 {
  MyThd t1= new MyThd(521,530);
  MyThd t2=new MyThd(70965,70975);
  
  System.out.println("\nend of code..\n");
 }
}