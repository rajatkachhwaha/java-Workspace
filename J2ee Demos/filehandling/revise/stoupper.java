//usage   >java toupper <filename>

import java.io.*;

class stoupper
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

  File fs=new File(arg[0]);
  if(!fs.exists())
  {
   System.err.println("\nfile not found - "+arg[0]+"\n");
   System.exit(1);
  }

  File ft=new File("001.tmp");

  try
  {
   FileReader fr=new FileReader(fs);
   FileWriter fw=new FileWriter(ft);

   BufferedReader br=new BufferedReader(fr);
   BufferedWriter bw=new BufferedWriter(fw);

   String s=br.readLine();
   while(s!=null)
   {
    s=s.toUpperCase();
    bw.write(s+"\r\n");
    bw.flush();
    s=br.readLine();
   }

   fr.close();
   fw.close();

   fs.delete();
   ft.renameTo(fs);
  }
  catch(IOException e)
  {
   System.err.println("\ni/o failed..");
  }
 }
}