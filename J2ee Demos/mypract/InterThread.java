class Buffer extends Thread
{
 private int val;
 private boolean valSet;
 
 synchronized void set(int val)
 {
  if(valSet)
  {
   try
   {
    wait();
   }
   catch(InterruptedException e){}
  }
  this.val=val;
  valSet=true;
  notify();
 }
 
 synchronized int get()
 {
  if(!valSet)
  {
   try
   {
    wait();
   }
   catch(InterruptedException e){}
  }
  valSet=false;
  notify();
  return val;
 }
}


class Consumer extends Thread
{
 int n;
 static String words[]={"Zero ","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
 Buffer buf;
 Consumer(Buffer buf)
 {
  this.buf=buf;
  start();
 }
 
 public void run()
 {
  while(true)
  {
   n=buf.get();
   if(n==-1)
   break;
   String s=String.valueOf(n);
   for(int i=0;i<s.length();i++)
   {
    int j=s.charAt(i)-48;
    for(int k=0;k<words[j].length();k++)
    {
     System.out.print(words[j].charAt(k));
     try
     {
      Thread.sleep(10);
     }
     catch(InterruptedException e){}
    }
   }
    System.out.println();
       
  }
 }
}


class Producer extends Thread
{
 private int lo,hi;
 private Buffer buf;

 Producer(int lo, int hi, Buffer buf)
 {
  this.lo=lo;
  this.hi=hi;
  this.buf=buf;
  start();
 }
 
 public void run()
{
 while(lo<=hi)
 {
  buf.set(lo);
  lo++;
 }
  buf.set(-1);
 }
}

class main
{
 public static void main(String arg[])
 {
  Buffer b=new Buffer();
  new Producer(27031,27040,b);
  new Consumer(b);
 }
} 
 
