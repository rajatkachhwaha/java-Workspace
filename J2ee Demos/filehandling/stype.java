//usage <java stype <filename>


import java.io.*;

class stype 
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
   System.exit(1);
  }
  try
  {
   FileReader fr=new FileReader(arg[0]);
   BufferedReader br=new BufferedReader(fr);
   int l=1;
   String s;
   s=br.readLine();
   while(s!=null)
   {
    System.out.printf("\n%3d  %s",l,s);
    l++;
    s=br.readLine();
   }
   fr.close();
  }
  catch(FileNotFoundException e)
  {
   System.err.println("\nfile not found - "+arg[0]+"\n");
  }
  catch(IOException e)
  {
   System.err.println("i/o failed..\n");
  }
 }
}