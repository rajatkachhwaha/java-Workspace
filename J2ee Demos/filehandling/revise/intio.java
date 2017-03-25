import java.io.*;

class writeint
{
 public static void main(String arg[])
 {
  java.util.Scanner sc=new java.util.Scanner(System.in);
  try
  {
   FileOutputStream fs=new FileOutputStream(arg[0]);
   ObjectOutputStream os=new ObjectOutputStream(fs);
   int n;
   
   while(true)
   {
    System.out.print("Enter a Number[0 to stop] : ");
    n=sc.nextInt();
    if(n==0)
     break;

    os.writeInt(n);
    os.flush();
   }
  }
  catch(IOException e)
  {
   System.err.println("I/o failed");
  }
 }
}

class readint
{
 public static void main(String arg[])
 {
  try
  {
   FileInputStream fs=new FileInputStream(arg[0]);
   ObjectInputStream os=new ObjectInputStream(fs);
   System.out.println();

   while(fs.available()>0)
   {
    int n;
    n=os.readInt();
    System.out.println(n);
   }
  }
  catch(FileNotFoundException e)
  {
   System.err.println("\nfile not found - "+arg[0]+"\n");
  }
  catch(IOException e)
  {
   System.err.println("\ni/o failed..\n");
  }
 }
}  