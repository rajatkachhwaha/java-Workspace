import java.awt.*;
import java.applet.*;


/*
 <applet code="Marquee2" width=700 height=500>
 </applet>
*/



public class Marquee2 extends Applet implements Runnable
{
 private int x=700;
 private Thread thd;
 
 public void init()
 {
  setBackground(Color.blue);
  setForeground(Color.white);
  setFont(new Font("lucida console",Font.PLAIN,20));		
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
   x=700;
  }
 }



}