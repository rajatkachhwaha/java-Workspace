class BoxingDemo
{
 public static void main(String arg[])
 {
  Integer x;
  int n;
  x=25;                      //autoboxing
  // is actually
  
  //x=new Integer(25);
 
  n=x;                       //Autounboxing
  // is actually 
  
  n=x.intValue();
  
    
  System.out.println(x);     //is actually(S.o.p(x.toString());
  
  System.out.println(n);     //is actually(S.o.p(String.valueOf(n));
 }
}
  