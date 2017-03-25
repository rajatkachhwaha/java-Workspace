//to draw lines by joining two points


import java.applet.*;
import java.awt.*;
import java.awt.event.*;


/*
 <applet code="LineDemo02" width=500 height=500>
 </applet>
*/ 


public class LineDemo02 extends Applet implements MouseListener
{
 boolean draw;
 int px,py;
 


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
  if((me.getButton()&2)==2)
  { 
   px=py=0;
   return;
  }
  Graphics g=getGraphics();
  g.setColor(Color.red);
  int x=me.getX();
  int y=me.getY();
  
  g.fillOval(x-5,y-5,10,10);

  if(px!=0||py!=0)
  { 
   g.setColor(Color.blue);
   g.drawLine(px,py,x,y);
  }
  px=x;
  py=y;  
 }
}

 
  
  


 