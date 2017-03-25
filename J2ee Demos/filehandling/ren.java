import java.io.File;

class ren
{
 public static void main(String arg[])
 {
  File fs=new File(arg[0]);
  File fd=new File(arg[1]);
 
  if(!fs.renameTo(fd))
  {
   System.err.println("\ncannot rename - "+arg[0]);
  }
 }
}