import java.io.*;

class MyFilter implements FilenameFilter
{
 public boolean accept(File d,String fname)
 {
  File f=new File(d,fname);
  return f.isDirectory();
 }
}


class tree
{
 public static void main (String arg[])
 {
  File d=new File(".");
  String path=d.getAbsolutePath().substring(0,2)+".";
  System.out.println(path);
  printTree(path,"");
 }

 static void printTree(String path,String spc)
 {
  File d=new File (path);
  spc=spc+"   ";
  String str[]=d.list(new MyFilter());
  for(String s : str)
  {
   System.out.println(spc+s);
   printTree(path+"/"+s,spc);   
  } 
 }
}

