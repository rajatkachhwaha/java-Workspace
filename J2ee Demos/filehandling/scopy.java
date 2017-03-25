//usage:  >java copy <source> <destination>


import java.io.*;


class scopy
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
   FileReader fr=new FileReader(src);
   BufferedReader br=new BufferedReader(fr);

   FileWriter fw=new FileWriter(dst);
   BufferedWriter bw=new BufferedWriter(fw);

   String s;
   
   s=br.readLine();
   while(s!=null)
   {
    s=s+"\r\n";
    bw.write(s);
    bw.flush();
    s=br.readLine();
   }
   fr.close();
   fw.close();
  }
  catch(IOException e){}
 }
}