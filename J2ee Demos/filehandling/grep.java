import java.io.*;

class grep
{
 public static void main(String arg[])
 {
  if(arg.length<2)
  {
   System.err.println("\nrequired parameter(s) missing..\n");
   System.exit(1);
  }
  if(arg.length>3)
  {
   System.err.println("\ntoo many parameters..\n");
   System.exit(1);
  }

  byte opt=0;
  if(arg.length==3) 
  {
   boolean err=false;

   if(arg[0].charAt(0)!='-')
    err=true;
   for(int i=1;i<arg[0].length();i++)
   {
    switch(arg[0].toUpperCase().charAt(i))
    {
     case 'N' : if((opt&1)==1)
		 err=true;
                else
 		 opt=(byte)(opt|1);
                break;
     case 'C' : if((opt&2)==2)
		 err=true;
		else
		 opt=(byte)(opt|2);
		break;
     case 'V' : if((opt&4)==4)
		 err=true;
		else
		 opt=(byte)(opt|4);
                break;
     default  : err=true; 
    }
   }  
   if(err)
   {
    System.err.println("\ninvalid switch - "+arg[0]+"\n");
    System.exit(2);
   }
  }
  try
  {
   FileReader     fr=new FileReader(arg[arg.length-1]);
   BufferedReader br=new BufferedReader(fr);
   int l=0, cnt=0;
   String str=br.readLine();   
   while(str!=null)
   {
    l++;
    if(str.indexOf(arg[arg.length-2])!=-1)
    {
     if(opt==0)
      System.out.printf("\n%s",str);
     else
     if(opt==1)
      System.out.printf("\n%3d   %s",l,str);
     else
     if(opt==2||opt==3)
      cnt++;
    }
    else
    {
     if(opt==4)
      System.out.printf("\n%s",str);
     else
     if(opt==5)
      System.out.printf("\n%3d   %s",l,str);
     else
     if(opt==6||opt==7)
      cnt++;
    } 
    str=br.readLine();
   }
   fr.close();
   if((opt&2)==2)
    System.out.println("\nCount : "+cnt);

  }
  catch(FileNotFoundException e)
  {
   System.err.println("\nfile not found - "+arg[1]+"\n");
  }
  catch(IOException e)
  {
   System.err.println("\ni/o failed..\n");
  }
 }
}