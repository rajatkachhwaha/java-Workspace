import java.io.*;

class TypeDemo
{
 public static void main(String arg[])
 {
  try 
  {
   FileInputStream fs=new FileInputStream(arg[0]);
   int n=fs.available();
   System.out.println("\nBytes available..\n"+n);
   fs.skip(n/2);
   n=fs.available();
   System.out.println("Bytes available after skipping :"+n);
   fs.close();
  }
  catch(FileNotFoundException e)
  {
   System.err.println("\nFile not found..\n");
  }
  catch(IOException e)
  {
   System.err.println("\ni/i failed..\n");
  }
 }
}
  
