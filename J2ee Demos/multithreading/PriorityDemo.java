class MyThd extends Thread 
{
 private long cnt;
 MyThd(String name, int p)
 {
  super(name);
  setPriority(p);
  start();
 }
 
 public void run()
 {
  while(true)
  {
   cnt++;
  }
 }
 
 public String toString()
 {
  return getName()+"  :  "+cnt;
 }
}

class ThreadPriority
{
 public static void main(String arg[])
 {
  MyThd ta=new MyThd("alfa",3);
  MyThd tb=new MyThd("beta",7);
 
  try
  {
   Thread.sleep(5000);
  }
  catch(InterruptedException e){}
  
  ta.stop();
  tb.stop();
  System.out.println();
  System.out.println("alfa is alive ? "+ta.isAlive());
  System.out.println("beta is alive ? "+tb.is alive());
  system.out.println();
  System.out.println(ta);
  System.out.println(tb);
 }
} 
