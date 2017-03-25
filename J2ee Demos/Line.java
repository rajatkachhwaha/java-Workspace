import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 <applet code="Line" width=700 height=600>
 </applet>
*/

public class Line extends Applet implements MouseListener,MouseMotionListener
{
 int ox,oy,px,py;

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
  g.drawLine(ox,oy,px,py);
  setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
 }

 public void mousePressed(MouseEvent me)
 {
  ox=px=me.getX();
  oy=py=me.getY();
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

  g.drawLine(ox,oy,px,py);
  px=me.getX();
  py=me.getY();
  g.drawLine(ox,oy,px,py);
  showStatus("x : "+px+"     y : "+py);
 }
}