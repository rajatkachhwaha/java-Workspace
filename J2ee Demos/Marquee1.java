import java.awt.*;
import java.appplet.*;


/*
 <applet code="Marquee1" width=700 height=500>
 </applet>
*/



public call Marquee1 extends Applet implements Runnable
{
 private int x=700;
 private threead thd;
 
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
  while(true)
  {
   repaint();
   x=x-2;
   if(x<-100)
   x=700;
  }
 }
 
 public void paint(Graphics g)
 {
  g.drawString("DMATICS",x,100);
 }
}