import java.util.*;

class CountStr
{
 public static void main(String arg[])
 {
  Scanner sc=new Scanner(System.in);
  
  String s1,s2;
  System.out.print("\nEnter a String         : ");
  s1=sc.nextLine();
  
  System.out.print("Enter String to search : ");
  s2=sc.nextLine();
  
  int i,cnt;
  cnt=0;
  
  i=s1.indexOf(s2);
  while(i!=-1)
  {
   cnt++;
   i=s1.indexOf(s2,i+s2.length());
  }

  System.out.println("\nCount of Occurence : "+cnt);
 }
}
  
   