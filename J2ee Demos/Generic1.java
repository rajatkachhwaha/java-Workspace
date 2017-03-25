class Sample
{
 public static <Type> Type getMiddleTerm(Type arr[])
 {
  return arr[arr.length/2];
 }
}

class Generic1
{
 public static void main(String arg[])
 {
  String str[]={"Rajat","Abhishek","Sourabh","Roy","Joy"};
  String s=Sample.getMiddleTerm(str);
  System.out.println(s);
   
  //int arr[]={1,5,8,10,54,67};		generic programming does not work with
  //                                    built in types
  
  Integer arr[]={1,5,8,10,54,67};
  
  int n=Sample.getMiddleTerm(arr);
  System.out.println(n);   
 }
}    