import java.awt.*;
import java.applet.*;


/*
 <applet code="Marquee3" width=700 height=500>
  
<param name="title" value="RAJAT">
<param name="size" value="18">
</applet>
*/

public class Marquee3 extends Applet implements Runnable
{
 private String msg;
 private int x=700;
 private Thread thd;
 
 public void init()
 {
  setBackground(Color.blue);
  setForeground(Color.white);
  msg=getParameter("title");
  if(msg==null)
  msg="DMATICS";
  int n;
  try
  {
   n=Integer.parseInt(getParameter("size")); 
  }
  catch(NumberFormatException e)
  {
   n=18;
  }
  setFont(new Font("Aerial",Font.PLAIN,n));
  d=getSize();
  x=d.width;
  
  thd=new Thread(this);
  thd.start();
 }
  
 public void run()
 {
  Graphics g=getGraphics();
  g.setXORMode(Color.blue);
  while(true)
  {
   g.drawString("DMATICS",x,100);
   try
   { 
    Thread.sleep(10);
   }
   catch(InterruptedException e){}
   g.drawString("DMATICS",x,100);
   x--;
   if (x<-100)
   x=d.width;
  }
 }
 
 public void paint(Graphics g)
 {
  d=getSize();
  x=d.width;
 }
}

}