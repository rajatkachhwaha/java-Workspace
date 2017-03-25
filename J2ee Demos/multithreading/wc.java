//USAGE :        >java wc <filename>

import java.io.*;
import java.util.StringTokenizer;
import java.awt.Toolkit;

class wc
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

  System.out.print("\n");
  Toolkit tk=Toolkit.getDefaultToolkit();  
  try
  {
   FileReader fr=new FileReader(arg[0]);
   BufferedReader br=new BufferedReader(fr);

   int c,w,l;
   c=w=l=0;

   String s=br.readLine();
   while(s!=null)
   {
    l++;
    c=c+s.length()+2;
    StringTokenizer st=new StringTokenizer(s," \t,;-.:");
    //w=w+st.countTokens();
   
    while(st.hasMoreTokens())
    {
     w++;
     tk.beep();
     System.out.print("\rReading : "+st.nextToken()+"\t\t"+w);
 
     Thread.sleep(200);     
    }
    s=br.readLine();
   }
   
   System.out.println("\n\n");

   System.out.println("Count of Chars : "+c);
   System.out.println("Count of Words : "+w);
   System.out.println("Count of Lines : "+l);
   
   fr.close();
  }
  catch(FileNotFoundException e)
  {
   System.err.println("\nfile not found - "+arg[0]+"\n");
  }
  catch(IOException e)
  {
   System.err.println("\ni/o failed..\n");
  }
  catch(InterruptedException e){}
 }
}
