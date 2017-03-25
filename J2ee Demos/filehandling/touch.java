import java.io.File;
import java.util.Date;

class touch
{
 public static void main(String arg[])
 { 
  Date dt; 
  if(arg.length==0)
  {
   System.err.println("\n reqd parameters missing..\n");
   System.exit(1);
  }
  if(arg.length>2)
  {
   System.err.println("\n too many parameters..\n");
   System.exit(2);
  }
  if(arg.length==2)
  {
   dt=new Date(arg[1]);
  } 
  else
  {
   dt=new Date();
  }
  File f=new File(arg[0]);
  if(!f.exists())
  {
   System.err.println("\n file not found.."+arg[0]);
   System.exit(3);
  }
  f.setLastModified(dt.getTime());
 } 
}