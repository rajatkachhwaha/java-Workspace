import java.io.*;




class abc1
{
 public static void main(String arg[])
 {
  try 
  {
   InputStreamReader fs=new InputStreamReader(System.in);
   
   System.out.println("\nEnter the text & press to quite..\n");
   char c; 
   
   do
   {
    
    c=(char)fs.read();
    System.out.println(c);
   }
   while(c!='q');
   fs.close();
  
  }
  catch(IOException e)
  {
   System.out.println("File not found");
  }
 }
}
         