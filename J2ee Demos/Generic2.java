class Pair <Type>
{
 private Type item1,item2;
 
 Pair(){}
 
 Pair(Type item1,Type item2)
 {
  this.item1=item1;
  this.item2=item2;
 }

 Type getFirst()
 {
  return item1;
 }
 
 
 Type getSecond()
 {
  return item2;
 }
}

class Generic2
{
 public static void main(String arg[])
 {
  //Pair p1=new Pair("Ron","Mon");
  //String s=p1.getFirst();			Invalid 
  
  //String s=(String)p1.getFirst();	OK but not recommended

  Pair <String>p1=new Pair<String>("Ron","Mon");
  String s=p1.getFirst();
  System.out.println(s);
 }    
}