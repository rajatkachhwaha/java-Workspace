import java.io.File;

class md
{
 public static void main(String arg[])
 { 
  if(arg.length!=1)
  {
   System.err.println("\n invalid use of command../n");
   System.exit(1);
  }
  File d=new File(arg[0]);
  if(!d.mkdirs())
  {
   System.err.println("cant create-"+arg[0]);
  }
 }
}  




