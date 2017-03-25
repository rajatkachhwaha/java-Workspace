import java.io.File;

class del
{
 public static void main(String arg[])
 {
  File f=new File(arg[0]);
   
  if(!f.delete())
  {
   System.err.println("\ncannot delete - "+arg[0]);
  }
 }
}