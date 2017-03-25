import java.io.IOException;


class ExitDemo
{
 public static void main(String arg[]) throws IOException,InterruptedException
 {
  Runtime r;
  r=Runtime.getRuntime();
  
  Process p=r.exec("notepad");
  p.waitFor();

 }
}
 