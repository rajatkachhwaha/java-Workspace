import java.awt.*;
import java.applet.*;

/*
 <applet code="Marquee" width=700 height=500>
 </applet>
*/
 
public class Marquee extends Applet implements Runnable
{
 private Thread thd;
 private int x;
 
 public void init()
 {
  setBackground(Color.blue);
  setForeground(Color.white);
  setFont(new Font("lucida console",Font.PLAIN,20));
  x=700;
  
  thd=new Thread(this);
  thd.start();
   
 }

 public void run()
 {
  while(true)
  {
   x--;
   if(x<-100)
    x=700;
   
   repaint();
   
   try
   {
    Thread.sleep(10);
   }
   catch(InterruptedException e){}

  }
 }
 
 public void paint(Graphics g)
 {
  g.drawString("dmatics",x,50);
 }
}