import static java.lang.System.*;

class FloatDemo
{
 public static void main(String arg[])
 {
  out.println("type Wrapped           : "+Float.TYPE);
  out.println("Lowest Value           : "+Float.MIN_VALUE);
  out.println("Largest Value          : "+Float.MAX_VALUE);
  out.println("Positive Infinity      : "+Float.POSITIVE_INFINITY);
  out.println("Negative Infinity      : "+Float.NEGATIVE_INFINITY);
  out.println("Not-a-Number           : "+Float.NaN);
  out.println("\n                                 \n");
  
  float x,y,z;
  //x=5/0;
  //x=5.0/0;
  
  x=5.0f/0;
  
  if(x==Float.POSITIVE_INFINITY)
  {
   out.println("x is infinity");
   out.println(x);
  }
  else
  out.println("x is finite");
  
  y=0.0f/0;
  out.println("0.0/0                  : "+y);
  
  y=x/x;
  out.println("infinite/infinte       : "+y);
 }
}     




 