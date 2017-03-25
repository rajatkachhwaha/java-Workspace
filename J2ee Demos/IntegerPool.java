class IntegerPool
{
 public static void main(String arg[])
 {
  Integer a,b,c,d;
  
  a=new Integer(125);
  b=new Integer(125);
  c=125;
  d=125;
  
  System.out.println(a==b);         //false(Compares the references)
  System.out.println(c==d);         //true
  System.out.println(a==c);         //false(comapares the references)

  System.out.println(a.equals(b));  //true
  System.out.println(c.equals(d));  //true
  System.out.println(a.equals(c));  //true

  a=new Integer(128);
  b=new Integer(128);
  c=128;
  c=128;

  System.out.println(a==b);         //false(Compares the references)
  System.out.println(c==d);         //false(Not in the Integer Pool)
  System.out.println(a==c);         //false(Compares the referances)
 }
}