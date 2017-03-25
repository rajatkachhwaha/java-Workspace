class StringBufferDemo
{
 public static void main(String arg[])
 {
  StringBuffer sb=new StringBuffer("Mickey");
 
//  System.out.println(sb.capacity());
//  System.out.println(sb.length());

    sb.setLength(3);
//  System.out.println(sb.capacity());
//  System.out.println(sb.length());
//  System.out.println(sb);       


    sb.setLength(6);
    System.out.println(sb.capacity());
    System.out.println(sb.length());
    System.out.println(sb); 


 }
}