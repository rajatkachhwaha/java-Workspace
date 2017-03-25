import java.applet.*; 
import java.awt.*;
import java.awt.event.*;

/*<applet code="LineDemo2.java" width=600 height=500>
</applet>*/


public class LineDemo2 extends Applet implements MouseListener
{
 int px,py;  
 boolean draw;

 public void init()
 {
  setBackground(new Color(255,255,255));             
  addMouseListener(this);
 }

 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseClicked(MouseEvent me){}
 public void mouseReleased(MouseEvent me){}

 public void mousePressed(MouseEvent me)
 {
  if((me.getButton()&2)==2)
   draw=false;
  else
  {
   Graphics g=getGraphics();
   int x,y;
   x=me.getX();
   y=me.getY();
   g.setColor(Color.red);
   g.fillOval(x-5,y-5,10,10);
   if(draw)
   {
    g.setColor(Color.blue);
    g.drawLine(px,py,x,y);
   }
   px=x;
   py=y;
   draw=true;
  }
 }
}