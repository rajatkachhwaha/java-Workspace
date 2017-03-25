import java.io.*;

class Record implements Serializable
{
 private String name;
 private int age;
 private float basic;
 Record(){};
 
 Record(String name,int age,double basic)
 {
  this.name=name;
  this.age=age;
  this.basic=(float)basic;
 }
 void print()
 {
  System.out.printf("\n%-20s %2d  %9.2f",name,age,basic);
 }
 public String toString()
 {
  String s=String.format("\n%-20s %2d  %9.2f",name,age,basic);
  return s;
 }
}

class writeobj
{
 public static void main(String arg[])
 {
  Record r1=new Record("rajat",22,10000);
  Record r2=new Record("Rk",24,20000);
  Record r3=new Record("Kachhwaha",32,30000);
  try
  {
   FileOutputStream fs= new FileOutputStream(arg[0]);
   ObjectOutputStream os=new ObjectOutputStream(fs);
  
   os.writeObject(r1);
   os.flush();
   os.writeObject(r2);
   os.flush();
   os.writeObject(r3);
   os.flush();
   fs.close();
  }
  catch(IOException e)
  {
   System.out.println("\nI/O failed..\n");
  }  
 }
}

class readobj
{
 public static void main(String arg[])
 {
 try
 {
  FileInputStream fs=new FileInputStream(arg[0]);
  ObjectInputStream os=new ObjectInputStream(fs);
  
  while(fs.available()>0)
  {
   Record r=(Record)os.readObject();
   System.out.println(r);
  }
  
  fs.close();
 }
 catch(ClassNotFoundException e)
 {
  System.err.println("\nClass Not found..\n");
 }
 catch(FileNotFoundException e)
 {
  System.err.println("\nFile Not found..\n");
 }
 catch(IOException e)
 {
  System.err.println("\nI/o failed..\n"); 
 }
}
} 
   