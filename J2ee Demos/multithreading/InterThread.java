class Producer extends Thread
{
 private int lo,hi;
 Pipe ob;

 Producer(int lo,int hi,Pipe ob)
 { 
  this.hi = hi;
  this.lo = lo;
  this.ob = ob;
  start();
 }

 public void run()
 {
  while(lo<=hi)
  {
   ob.set(lo);
   lo++;
  }
  ob.set(-1);
 }
}

class Consumer extends Thread
{
 private static String wrds[]={"Zero ","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
 Pipe ob;
  
 Consumer(Pipe ob)
 {
  this.ob = ob;
  start();
 }
 
 public void run()
 { 
  while(true)
  {
   int n;
   n=ob.get();
   if(n==-1)
    break;

   String s=String.valueOf(n);

   for(int i=0;i<s.length();i++)
   {
    String str=wrds[s.charAt(i)-48];
    for(int j=0;j<str.length();j++)
    {
     System.out.print(str.charAt(j));
     try
     {
      Thread.sleep(20);
     }
     catch(InterruptedException e){}
    } 
   }
   System.out.println();
  }
 }
}

class Pipe
{
 private int val;
 private boolean valset;

 synchronized void set(int val)
 {
  if(valset)
   try
   {
    wait();
   }
   catch(InterruptedException exc){}
  
  this.val = val;
  valset = true;
  notify();
 }

 synchronized int get()
 {
  if(!valset)
  {
   try
   {
    wait();
   }
   catch(InterruptedException exc){}
  }

  valset = false;
  notify();
  return val;    
 }
}
 
class Main
{
 public static void main(String[] args)
 {
  Pipe ob = new Pipe();

  Producer ob1 = new Producer(1234,1240,ob);
  Consumer ob2 = new Consumer(ob);
 }
} 