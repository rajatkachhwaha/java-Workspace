class Resource
{
 private static String wrds[]={"Zero ","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};

 /*synchronized*/ void toWords(int n)
 {
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

class MyThd extends Thread
{
 private int lo,hi;
 private Resource res;
 
 MyThd(int lo,int hi,Resource res)
 {
  this.lo=lo;
  this.hi=hi;
  this.res=res;
  start();
 }

 public void run()
 {
  while(lo<=hi)
  {

   synchronized(res)
   {
    res.toWords(lo);
   }

   lo++;
  }
 }
}

class SyncDemo
{
 public static void main(String arg[])
 {
  Resource r=new Resource();

  MyThd t1=new MyThd(50171,50180,r);
  MyThd t2=new MyThd(29835,29845,r);
 
 }
}