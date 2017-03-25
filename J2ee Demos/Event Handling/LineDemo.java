import java.applet.*; 
import java.awt.*;
import java.awt.event.*;

/*<applet code="LineDemo.java" width=600 height=500>
</applet>*/


public class LineDemo extends Applet implements MouseListener,MouseMotionListener
{
 int ox,oy,px,py;  

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
 }
 
 public void mouseMoved(MouseEvent me) {}

 public void mouseDragged(MouseEvent me)
 {
  Graphics g=getGraphics();
  g.setXORMode(Color.white);
  g.drawLine(ox,oy,px,py);
  px=me.getX();
  py=me.getY();
  g.drawLine(ox,oy,px,py);
 }
}