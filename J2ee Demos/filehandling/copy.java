//usage:  >java copy <source> <destination>


import java.io.*;


class copy
{
 public static void main(String arg[])
 {
  if(arg.length<2)
  {
   System.err.println("\nrequired parameter(s) missing..\n");
   System.exit(1);
  }
  if(arg.length>2)
  {
   System.err.println("\ntoo many parameters..\n");
   System.exit(1);
  }
  File src=new File(arg[0]);
  if(!src.exists())
  {
   System.err.println("\nSource not found - "+arg[0]);
   System.exit(2);
  }
  File dst=new File(arg[1]);
  if (dst.exists())
  {
   char ans;
   System.out.print("\nDestination exists.. Overwrite it?(y/n) : ");
   try 
   {
    ans=(char) System.in.read();
   }
   catch(IOException e)
   {
    ans='N';
   }
   if(ans!='Y' && ans!='y')
   {
    System.exit(3);
   }
  }  

  try
  {
   FileInputStream  fs=new FileInputStream(src);
   FileOutputStream fd=new FileOutputStream(dst);

   int x;
   
   x=fs.read();
   while(x!=-1)
   {
    fd.write((char)x);
    x=fs.read();
   }
   fs.close();
   fd.close();
  }
  catch(IOException e){}
 }
}