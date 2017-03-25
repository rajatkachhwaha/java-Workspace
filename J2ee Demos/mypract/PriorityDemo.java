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
  return getName()+" : "+cnt;
 }
}

class Main
{
 public static void main(String arg[])
 {
  MyThd t1=new MyThd("alfa",3);
  MyThd t2=new MyThd("beta",7);
  
  try
  {
   Thread.sleep(5000);
  }
  catch(InterruptedException e){}
  t1.stop();
  t2.stop();
  
  System.out.println();
  System.out.println("alfa is alive? "+t1.isAlive());
  System.out.println("beta is alive? "+t2.isAlive());
  System.out.println();
  System.out.println(t1);
  System.out.println(t2);
 }
} 

 
 