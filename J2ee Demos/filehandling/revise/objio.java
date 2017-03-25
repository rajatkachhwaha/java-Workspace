import java.io.*;

class Input
{
 static String getString()
 {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String s;
  try
  {
   s=br.readLine();
  }
  catch(IOException e)
  {
   s="";
  }
  return s;
 }

 static int getInt()
 {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  int n;
  try
  {
   n=Integer.parseInt(br.readLine());
  }
  catch(IOException|NumberFormatException e)
  {
   n=0;
  }
  return n;
 }

 static float getFloat()
 {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  float n;
  try
  {
   n=Float.parseFloat(br.readLine());
  }
  catch(IOException|NumberFormatException e)
  {
   n=0;
  }
  return n;
 }
} 

class Record implements Serializable
{
 private String name;
 private int age;
 private float basic;

 void get()
 {
  System.out.println();
  System.out.print("Enter Name  : ");
  name=Input.getString();
  System.out.print("Enter Age   : ");
  age=Input.getInt();
  System.out.print("Enter Basic : ");
  basic=Input.getFloat();
 }

 String getName()
 {
  return name;
 }

 void print()
 {
  System.out.printf("\n%-15s   %2d   %10.2f",name,age,basic);
 }

 public String toString()
 {
  String str=String.format("%-15s   %2d   %10.2f",name,age,basic);
  return str;
 }

}

class writeobj
{
 public static void main(String ...arg)
 {
  try
  {
   FileOutputStream fs=new FileOutputStream("data.dat");
   ObjectOutputStream os=new ObjectOutputStream(fs);

   while(true)
   {
    Record r=new Record();
    r.get();
    if(r.getName().length()==0)
     break;
    os.writeObject(r);
    os.flush();
   }

   fs.close();
  }
  catch(IOException e)
  {
   System.err.println("\ni/o failed..\n");
  }
 }
}

class readobj
{
 public static void main(String ...arg)
 {
  try
  {
   FileInputStream fs=new FileInputStream("data.dat");
   ObjectInputStream os=new ObjectInputStream(fs);

   int n=1;
   while(fs.available()>0)
   {
    Record r=(Record)os.readObject();
    System.out.printf("\nRec %d : %s",n,r);
    n++;
   }
   fs.close();
  }
  catch(ClassNotFoundException e)
  {
   System.err.println("\nclass not found...\n");
  }
  catch(IOException e)
  {
   System.err.println("\ni/o failed..\n");
  }
 }
}
