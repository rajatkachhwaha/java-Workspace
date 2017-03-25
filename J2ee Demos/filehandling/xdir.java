import java.io.File;
import java.util.Date;

class xdir
{
 public static void main(String arg[])
 { 
  String dirname=".";
  if (arg.length>1)
  {
   System.err.print("\ninvalid use of command..\n");
   System.exit(1); 
  }

  if (arg.length==1)
  {
   dirname=arg[0];
  }

  File d=new File(dirname);
  if(!d.exists())
  {
   System.err.print("\n directory not found..\n");
   System.exit(2);
  }
 
  File refs[]=d.listFiles();

  for(File f:refs)
  {
   Date dt=new Date(f.lastModified());
   int dd,mm,yy,hrs,min;
   dd=dt.getDate();
   mm=dt.getMonth()+1;
   yy=dt.getYear()+1900;
   hrs=dt.getHours();
   min=dt.getMinutes();

   String str="AM";
   if(hrs>=12)
   {
    str="PM";
    if(hrs>12)
     hrs=hrs-12;
   }

   System.out.printf("\n%02d-%02d-%d  %02d:%02d %s%4s",dd,mm,yy,hrs,min,str,"");
  
   if(f.isDirectory())
   {
    System.out.printf("<DIR>%11s","");
   }
   else
   {
    System.out.printf("%14d ",f.length());
   }
   System.out.printf("%s",f.getName());
  }

 }
}