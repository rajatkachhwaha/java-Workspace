import java.io.*;




class abc
{
 public static void main(String arg[])
 {
  try 
  {
   FileInputStream fs=new FileInputStream("input.txt");
   FileOutputStream fo= new FileOutputStream("output.txt");
   
   int c; 
   while((c=fs.read())!=-1)
   {
    fo.write(c);
   }
  fs.close();
  fo.close();
  }
  catch(IOException e)
  {
   System.out.println("File not found");
  }
 }
}
         