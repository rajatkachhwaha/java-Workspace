import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 <applet code="EventDemo" width=500 height=500>
 </applet>
*/ 

public class EventDemo extends Applet implements MouseListener
{
 AudioClip ac;
 public void init()
 {
  setFont(new Font("lucida console",Font.PLAIN,13));
  ac=getAudioClip(getCodeBase(),"yahoo.au");
  addMouseListener(this);
 }
 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseClicked(MouseEvent me){}
 public void mouseReleased(MouseEvent me){}
 
 public void mousePressed(MouseEvent me)
 {
  int x=me.getX();
  int y=me.getY();
  int red,grn,blu;
  red=((int)(Math.random()*1000))%256;
  grn=((int)(Math.random()*1000))%256;
  blu=((int)(Math.random()*1000))%256;
  Graphics g=getGraphics();
  g.setColor(new Color(red,grn,blu));
  ac.play();
  g.drawString("yahoo",x,y);
 }
}