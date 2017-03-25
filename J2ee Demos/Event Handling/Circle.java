import java.applet.*; 
import java.awt.*;
import java.awt.event.*;

/*<applet code="Circle.java" width=600 height=500>
</applet>*/


public class Circle extends Applet implements MouseListener,MouseMotionListener
{
 int ox,oy,px,py,wd,ht;

 public void init()
 {
  setBackground(new Color(255,255,255));             
  addMouseListener(this);
  addMouseMotionListener(this);
 }
 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseClicked(MouseEvent me){}
 public void mouseReleased(MouseEvent me){}
 public void mousePressed(MouseEvent me)
 {
  ox=px=me.getX();
  oy=py=me.getY();
  wd=ht=0;
 }
 public void mouseMoved(MouseEvent me){}
 public void mouseDragged(MouseEvent me)
 {
  Graphics g=getGraphics();
  g.setXORMode(Color.white);
  g.drawOval(px,py,wd,ht);
  px=me.getX();
  py=me.getY();
  wd=px-ox;
  ht=py-oy;
  if(wd<0)
   wd=-wd;
  else
   px=ox;
  if(ht<0)
   ht=-ht;
  else
   py=oy;
  g.drawOval(px,py,wd,ht);
 }
}