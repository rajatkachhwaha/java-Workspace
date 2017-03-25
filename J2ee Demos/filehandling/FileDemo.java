import java.io.File;

class FileDemo
{
 public static void main(String arg[])
 {

  if(arg.length!=1)
  {
   System.err.println("\ntoo few/many arguments..\n");
   System.exit(1);
  }

  File f=new File(arg[0]);
  
  if(!f.exists())
  {
   System.err.println("\nfile not found - "+arg[0]);
   System.exit(2);
  }

  System.out.println();

  System.out.println("Filename                                   : "+f.getName());
  System.out.println("Parent Name                                : "+f.getParent());
  System.out.println("Path                                       : "+f.getPath());
  System.out.println("Absolute Path                              : "+f.getAbsolutePath());
 }
}