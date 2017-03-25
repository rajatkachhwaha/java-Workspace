import java.io.*;
 
class sort
{
 public static void main(String arg[])
 {
  try
  {
   FileInputStream   fs=new FileInputStream(arg[0]);
   ObjectInputStream os=new ObjectInputStream(fs);
      
   int arr[]=new int[fs.available()/6];
   for(int i=0;i<arr.length;i++)
   {
    arr[i]=os.readInt();
   }

   fs.close();

   java.util.Arrays.sort(arr);

   FileOutputStream   fd=new FileOutputStream(arg[0]);
   ObjectOutputStream od=new ObjectOutputStream(fd);
         
   for(int n : arr)
   {
    od.writeInt(n);
    od.flush();
   }

   fd.close();
  }
  catch(FileNotFoundException e)
  {
   System.err.println("\nfile not found - "+arg[0]+"\n");
  }
  catch(IOException e)
  {
   System.err.println("\ni/o failed.. aborting..\n");
  }
 }
} 
         
 
   
  
 






 