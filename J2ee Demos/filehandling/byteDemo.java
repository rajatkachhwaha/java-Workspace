import java.io.*;
class ByteDemo
{
 public static void main(String arg[])
 {
  try
  {
   FileInputStream fs=new FileInputStream(arg[0]);
   int n=fs.available();
   System.out.println("Bytes available after opening  : "+n);
   fs.skip(n/2);
   n=fs.available();
   System.out.println("Bytes available after skipping : "+n);
   fs.close();
  }
  catch(FileNotFoundException e)
  {
   System.err.println("\nfile Not Found - "+arg[0]);
  }
  catch(IOException e)
  {
   System.err.println("\ni/o failed..");
  }
 }
}




