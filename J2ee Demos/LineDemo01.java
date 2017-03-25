//to draw lines by joining points

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 <applet code="LineDemo01" width=500 height=500>
 </applet>
*/ 


public class LineDemo01 extends Applet implements MouseListener
{
 int px,py;
 boolean draw;

 public void init()
 {
  setBackground(Color.yellow);

  addMouseListener(this);
 }

 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseClicked(MouseEvent me){}
 public void mouseReleased(MouseEvent me){}

 public void mousePressed(MouseEvent me)
 {
  Graphics g=getGraphics();
  g.setColor(Color.red);
  int x,y;
  x=me.getX();
  y=me.getY();

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

 