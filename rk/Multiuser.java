
import java.net.*;   
import java.io.*;
import java.util.*;
//import java.lang.Object;

public class Multiuser extends Thread{   
private Socket client;   
  
public Multiuser(Socket c){   
this.client=c;   
}   
  
public void run(){   
try{   
BufferedReader in=  
new BufferedReader(new InputStreamReader(client.getInputStream()));   
PrintWriter out=new PrintWriter(client.getOutputStream());      
while(true){   
String str=in.readLine();   
System.out.println(str);   
out.println("has received....");   
out.flush();   
if(str.equals("end"))   
break;   
}   
client.close();   
}catch(IOException ex){   
}finally{   
  
} 
}   
 
public static void main(String[] args)throws IOException{   
ServerSocket server=new ServerSocket(5678);   
while(true){      
Multiuser mu=new Multiuser(server.accept());   
mu.start();   
}   
}   
public static byte[] encryptString(byte[] source, byte[] mykey, byte[] i_iv) {
         byte[] ct = null;
         try {
             IPad padding = PadFactory.getInstance("PKCS7");
             padding.init(16);
             IMode mode = ModeFactory.getInstance("CBC", "AES", 16);
             Map attributes = new HashMap();
             byte[] pt1 = source;
             byte[] pad = padding.pad(pt1, 0, pt1.length);
             byte[] pt = null;
             if (pad.length == 16) {
                 pt = new byte[pt1.length];
                 System.arraycopy(pt1, 0, pt, 0, pt1.length);
             } else {
                 pt = new byte[pt1.length + pad.length];
                 System.arraycopy(pt1, 0, pt, 0, pt1.length);
                 System.arraycopy(pad, 0, pt, pt1.length, pad.length);
             }
 
            ct = new byte[pt.length];
 
            byte[] iv = i_iv;
            byte[] key = mykey;
            attributes.put(IMode.KEY_MATERIAL, key);
            attributes.put(IMode.CIPHER_BLOCK_SIZE, new Integer(16));
            attributes.put(IMode.IV, iv);
            attributes.put(IMode.STATE, new Integer(IMode.ENCRYPTION));
            mode.init(attributes);
 
            for (int i = 0; i + 16 <= pt.length; i += 16) {
                 mode.update(pt, i, ct, i);
             }
         } catch (Exception e) {
         e.printStackTrace();
         }
 
        return ct;
     }
 
 public static String decryptString(byte[] source, byte[] mykey, byte[] i_iv) {
         String str = null;
         try {
             IPad padding = PadFactory.getInstance("PKCS7");
             padding.init(16);
             IMode mode = ModeFactory.getInstance("CBC", "AES", 16);
             Map attributes = new HashMap();
 
             byte[] iv = i_iv;
             byte[] ct = new byte[source.length];
             byte[] key = mykey;
 
             attributes.put(IMode.KEY_MATERIAL, key);
             attributes.put(IMode.CIPHER_BLOCK_SIZE, new Integer(16));
             attributes.put(IMode.IV, iv);
             attributes.put(IMode.STATE, new Integer(IMode.DECRYPTION));
             mode.init(attributes);
 
             for (int i = 0; i + 16 <= source.length; i += 16) {
                 mode.update(source, i, ct, i);
             }
 
             byte[] out = null;
             try {
                 int unpad = padding.unpad(ct, 0, ct.length);
                 out = new byte[ct.length - unpad];
                 System.arraycopy(ct, 0, out, 0, out.length);
             } catch (Exception e) {
                 out = new byte[ct.length];
                 System.arraycopy(ct, 0, out, 0, out.length);
             }
 
            str = new String(out);
 
         } 
         catch (Exception e) {
             e.printStackTrace();
         }
         return str;
 }
}