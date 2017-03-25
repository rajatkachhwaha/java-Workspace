import java.io.*;

class skp
{
 public static void main(String arg[])
 {
  
  
  try
  {
   FileInputStream fs= new FileInputStream(arg[0]);
   
   System.out.println("\nbytes available="+fs.available());
   int n=fs.available();
   fs.skip(n/2);
  
   System.out.println("\nbytes available after skipping="+fs.available());
   fs.close();
  }
  catch(FileNotFoundException e)
  {
   System.err.println("\nfile not found..\n"+arg[0]);
  }
  catch(IOException e)
  {
  System.err.println("\ni/o failed..\n");
  }

  

 }
}