import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="Bouncy" height=600 width=700>
</applet>
*/

public class Bouncy extends Applet implements Runnable,MouseListener
{
 int x,y;
 public void init()
 {
  setBackground(Color.white);
  addMouseListener(this);
 }

 public void mouseEntered(MouseEvent me) {}
 public void mouseExited(MouseEvent me)  {}
 public void mouseClicked(MouseEvent me) {}
 public void mouseReleased(MouseEvent me){}

 public void mousePressed(MouseEvent me)
 {
  x=me.getX();
  y=me.getY();
  Thread thd=new Thread(this);
  thd.start();
 }

 public void run()
 {
  Graphics g=getGraphics();
  g.setXORMode(Color.white);
  g.fillOval(x-10,y-10,30,30);
  while(true)
  {
   try
   {
    Thread.sleep(1000);
   }
   catch(InterruptedException e){}
   g.fillOval(x,y,20,20);
   if(x<30)
    x=700;
   x=x-10;
  }
 }
}