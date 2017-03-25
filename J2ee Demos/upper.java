import java.util.Scanner;

class Upper
{
 public static void main(String arg[])
 {
  Scanner sc=new Scanner(System.in);
  
  System.out.print("\nEnter a String : ");
  String s=sc.nextLine();
  
  char str[]=s.toCharArray();
   
  for(int i=0;i<str.length;i++)
  {
   if(str[i]>='a'&&str[i]<='z')
    str[i]=(char)(str[i]-32);
  }
  
  s=new String(str);
 
  System.out.println("\nCoverted String : "+s);
 }
} 