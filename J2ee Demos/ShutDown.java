import java.io.IOException;


class shutdown
{
 public static void main(String arg[]) throws IOException,InterruptedException
 {
  Runtime r;
  r=Runtime.getRuntime();
  
  r.exec("shutdown -s");                        //r.exec("restart  /r")
                                                //r.exec("shutdown after sometime  -s -t 10") 
                       
  

 }
}
 