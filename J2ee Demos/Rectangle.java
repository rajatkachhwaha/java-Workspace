import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 <applet code="Rectangle" width=700 height=600>
 </applet>
*/

public class Rectangle extends Applet implements MouseListener,MouseMotionListener
{
 int ox,oy,px,py,wd,ht;

 public void init()
 {
  addMouseListener(this);
  addMouseMotionListener(this);
 }

 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseClicked(MouseEvent me){}

 public void mouseReleased(MouseEvent me)
 {
  Graphics g=getGraphics();
  g.setPaintMode();
  g.drawRect(px,py,wd,ht);
  setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  wd=ht=0;
 }

 public void mousePressed(MouseEvent me)
 {
  ox=px=me.getX();
  oy=py=me.getY();
  wd=ht=0;
  setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
 }
 
 public void mouseMoved(MouseEvent me)
 {
  int x=me.getX();
  int y=me.getY();
  showStatus("x : "+x+"     y : "+y);
 }

 public void mouseDragged(MouseEvent me)
 {
  Graphics g=getGraphics();
  g.setXORMode(Color.white);

  if(wd!=0||ht!=0)
   g.drawRect(px,py,wd,ht);

  px=me.getX();
  py=me.getY();
  showStatus("x : "+px+"     y : "+py);
  
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
  
  g.drawRect(px,py,wd,ht);
 }
}