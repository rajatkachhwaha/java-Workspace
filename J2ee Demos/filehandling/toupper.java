//usage   >java toupper <filename>

import java.io.*;

class toupper
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
   byte arr[]=new byte[fs.available()];
   fs.read(arr);
   fs.close();
   for(int i=0;i<arr.length;i++)
   {
    if(arr[i]>='a' && arr[i]<='z')
    {
     arr[i]=(byte)(arr[i]-32);
    }  
   }
  FileOutputStream fd=new FileOutputStream(arg[0]);
  fd.write(arr);
  fd.close();
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