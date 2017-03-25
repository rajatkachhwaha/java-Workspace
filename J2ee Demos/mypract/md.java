import java.io.File;

class md
{
 public static void main(String arg[])
 {
  File f= new File(arg[0]);
  if(!f.mkdir())
  {
   System.err.println("\ncannot create directory- "+arg[0]+"\n");
  }
 }
}
 