import java.io.File;

class setreadonly
{
 public static void main(String arg[])
 {

  File f=new File(arg[0]);
   if(!f.exists())
  {
   System.err.print("\n File not Found..\n");
   System.exit(1); 
  }
   f.setReadOnly();
 
 
 }
}