import java.io.*;

class type
{
 public static void main(String arg[])
 {
  if(arg.length==0)
  {
   System.err.println("\nrequired parameter missing..\n");
   System.exit(1);
  }
  if(arg.length>1)
  {
   System.err.println("\ntoo many parameters..\n");
   System.exit(2);
  }
 try
 {
  FileInputStream fs=new FileInputStream(arg[0]);
  int x;
  x=fs.read();
  while(x!=-1)
  {
   System.out.print((char)x);
   x=fs.read();
  }
  fs.close();
 }
 catch(FileNotFoundException e)
  {
  System.err.println("\nfile not found - "+arg[0]);
  }
  catch(IOException e)
  {
  System.err.println("\ni/o failed..");
  }
 }
}
