import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="LineDemo1.java" width=700 height=600>
</applet>
*/

public class LineDemo1 extends Applet implements MouseListener 
{
 int px,py;
 boolean draw;

 public void init()
 {
  setBackground(new Color(255,255,255));
  addMouseListener(this);
 }

 public void mouseEntered(MouseEvent me) {}
 public void mouseExited(MouseEvent me)  {}
 public void mouseClicked(MouseEvent me) {}
 public void mouseReleased(MouseEvent me){}

 public void mousePressed(MouseEvent me)
 {
  Graphics g=getGraphics();
  int x=me.getX();
  int y=me.getY();
 
  g.setColor(Color.red);
  g.fillOval(x-5,y-5,10,10);
  
  if(draw)
  {
   g.setColor(Color.blue);
   g.drawLine(px,py,x,y);
  }
  else
  {
   px=x;
   py=y;
  }
  draw=!draw;
 }
}
  