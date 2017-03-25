class MyThd implements Runnable
{
 private int lo,hi;
 private Thread thd;
 
 MyThd(int lo, int hi)
 {
  this.lo=lo;
  this.hi=hi;
  thd= new Thread(this);
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

 void join() throws InterruptedException
 {
  thd.join();
 }
}

class RunDemo 
{
 public static void main(String arg[]) throws InterruptedException
 {
  MyThd t1=new MyThd(341,350);
  MyThd t2=new MyThd(2991,3000);
  t1.join();
  t2.join();
  
    
  System.out.print("end of code..");
   
 
 }
}
  
  