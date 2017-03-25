class Resource
{
 static String words[]={"Zero ","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
 
/*synchronized*/ void toWords(int n)
 {
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

class Main
{
 public static void main(String arg[])
 {
  Resource r=new Resource();
  new MyThd(27031,27040,r);
  new MyThd(585,595,r);
 }
}  
    