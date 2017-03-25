import java.io.File;

class xdir1
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
 
  String refs[]=d.list();

  for(String s:refs)
   System.out.println(s);
 }
}