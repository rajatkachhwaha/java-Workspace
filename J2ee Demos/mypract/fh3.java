import java.io.*;

class copy
{
 public static void main(String arg[])
 {
  if(arg.length<2)
  {
   System.err.println("\nmissing arguments..\n");
   System.exit(1);
  }
  
  if(arg.length>2)
  {
   System.err.println("\ntoo many arguments..\n");
   System.exit(1);
  }
   
  File src=new File(arg[0]);
  if(!src.exists())
  {
   System.err.println("\nsource not found..\n");
   System.exit(2);
  }
  
  File dst=new File(arg[1]);
  
  if(dst.exists())
  {
   System.out.println("press y or Y to overwrite..");
   char c;
   try
   {
    
    c=(char)System.in.read();
   }
   catch(IOException e)
   {
   c='N';
   }
   if(c!='y'&&c!='Y')
   {
    System.exit(3);
   }
  }
  try
  {
   FileInputStream fs=new FileInputStream(src);
   FileOutputStream fo=new FileOutputStream(dst);
    
   int x;
   x=fs.read();

   while(x!=-1)
   {
    fo.write((char)x);
    x=fs.read();
   }
   fs.close();
   fo.close();
  }
  catch(IOException e)
  {}
 }
} 
       
  














  
  