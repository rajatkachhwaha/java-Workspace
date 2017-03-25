import java.io.*;

class dir				
{
 public static void main(String arg[])
 {
  String dirname=".";
  if(arg.length!=0)
  {
   dirname=arg[0];
  }
  File d=new File(dirname);
  String fnames[]=d.list();


/*-----------------------------
  for(String s:fnames)
  System.out.println(s); 
 -----------------------------*/
  
  for(String s:fnames)
  {
   File f=new File(d.getAbsolutePath()+"/"+s);
   System.out.println(d.exists()+"  :  "+f.getName()); 
  }
  File files[]=d.listFiles();
  for(File f:files)
  {
   System.out.println(f.getName());
  }
 }
}
 