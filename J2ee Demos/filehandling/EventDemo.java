import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
 <applet code="EventDemo" width=700 height=600>
 </applet>
*/

public class EventDemo extends Applet implements MouseListener
{
 AudioClip ac;

 public void init()
 {
  setBackground(Color.yellow);
  setForeground(Color.red);
  setFont(new Font("lucida console",Font.PLAIN,20));
  ac=getAudioClip(getCodeBase(),"yahoo.au");

  addMouseListener(this);
 }

 public void mouseEntered(MouseEvent me) {}
 public void mouseExited(MouseEvent me)  {}
 public void mouseClicked(MouseEvent me) {}
 public void mouseReleased(MouseEvent me){}

 public void mousePressed(MouseEvent me)
 {
  int x,y;
  x=me.getX();
  y=me.getY();
  ac.play();
  Graphics g=getGraphics();
  g.drawString("Yahoo !",x,y);
 }
}