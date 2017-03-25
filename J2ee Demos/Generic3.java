import java.awt.Rectangle;

class Pair1 <Type extends Comparable>
{
 private Type item1,item2;
 
 Pair1(){}
 
 Pair1(Type item1,Type item2)
 {
  this.item1=item1;
  this.item2=item2;
 }

 Type getMin()
 {
  if(item1.compareTo(item2)<0)
   return item1;
  
  return item2;
 }

}

class Generic3
{
 public static void main(String arg[])
 {
  Pair1 <String>p1;
  //Pair1 <Rectangle>p2; 
 }
}