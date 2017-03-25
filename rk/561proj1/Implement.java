
import java.net.*;   
import java.io.*;
import java.util.*;

public class Implement extends Thread
{   
private Socket client;   
  
public Implement(Socket s){   
this.client=s;   
}   
  
public void run(){   
try{   
BufferedReader br= new BufferedReader(new InputStreamReader(client.getInputStream()));   
PrintWriter pw=new PrintWriter(client.getOutputStream());      
while(true){   
String sr=in.readLine();   
System.out.println(sr);   
out.println("recieved");   
out.flush();   
if(sr.equals("end"))   
break;   
}   
client.close();   
}
catch(IOException ex)
{   
}
finally
{   
  
} 
}   
 
public static void main(String[] args)throws IOException
{   
ServerSocket server=new ServerSocket(1608);   
while(true){      
Implement im=new implement(server.accept());   
im.start();   
}   
}   
public static byte[] encryptString(byte[] source, byte[] mykey, byte[] i_iv) {
         byte[] cnt = null;
         try 
	{
             IPad padding = PadFactory.getInstance("PKCS7");
             padding.init(16);
             IMode mode = ModeFactory.getInstance("CBC", "AES", 16);
             Map attributes = new HashMap();
             byte[] pnt1 = source;
             byte[] pad = padding.pad(pnt1, 0, pnt1.length);
             byte[] pnt = null;
             if (pad.length == 16) {
                 pnt = new byte[pnt1.length];
                 System.arraycopy(pt1, 0, pnt, 0, pnt1.length);
             } else {
                 pt = new byte[pnt1.length + pad.length];
                 System.arraycopy(pnt1, 0, pnt, 0, pnt1.length);
                 System.arraycopy(pad, 0, pnt, pnt1.length, pad.length);
             }
 
            cnt = new byte[pnt.length];
 
            byte[] iv = i_iv;
            byte[] key = mykey;
            attributes.put(IMode.KEY_MATERIAL, key);
            attributes.put(IMode.CIPHER_BLOCK_SIZE, new Integer(16));
            attributes.put(IMode.IV, iv);
            attributes.put(IMode.STATE, new Integer(IMode.ENCRYPTION));
            mode.init(attributes);
 
            for (int i = 0; i + 16 <= pt.length; i += 16) 
	     {
                 mode.update(pnt, i, cnt, i);
             }
         } 
         catch (Exception e)
         {
         e.printStackTrace();
         }
 
        return cnt;
     }
 
 public static String decryptString(byte[] source, byte[] mykey, byte[] i_iv) {
         String sr = null;
         try 
	{
             IPad padding = PadFactory.getInstance("PKCS7");
             padding.init(16);
             IMode mode = ModeFactory.getInstance("CBC", "AES", 16);
             Map attributes = new HashMap();
 
             byte[] iv = i_iv;
             byte[] cnt = new byte[source.length];
             byte[] key = mykey;
 
             attributes.put(IMode.KEY_MATERIAL, key);
             attributes.put(IMode.CIPHER_BLOCK_SIZE, new Integer(16));
             attributes.put(IMode.IV, iv);
             attributes.put(IMode.STATE, new Integer(IMode.DECRYPTION));
             mode.init(attributes);
 
             for (int i = 0; i + 16 <= source.length; i += 16) 
	     {
                 mode.update(source, i, cnt, i);
             }
 
             byte[] out = null;
             try {
                 int unpad = padding.unpad(cnt, 0, cnt.length);
                 out = new byte[cnt.length - unpad];
                 System.arraycopy(cnt, 0, out, 0, out.length);
             } catch (Exception e) {
                 out = new byte[cnt.length];
                 System.arraycopy(cnt, 0, out, 0, out.length);
             }
 
            sr = new String(out);
 
         } 
         catch (Exception e) {
             e.printStackTrace();
         }
         return sr;
 }
}