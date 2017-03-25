import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
 <applet code="Ripples" width=700 height=600>
 </applet>
*/

public class Ripples extends Applet implements MouseListener,Runnable
{
 AudioClip ac;
 int x,y;

 public void init()
 {
  setBackground(new Color(50,50,255));
  setForeground(new Color(0,0,255));

  ac=getAudioClip(getCodeBase(),"drip.au");
 
  addMouseListener(this);
 }

 public void mouseEntered(MouseEvent me) {}
 public void mouseExited(MouseEvent me)  {}
 public void mouseClicked(MouseEvent me) {}
 public void mouseReleased(MouseEvent me){}

 public void mousePressed(MouseEvent me)
 {
  x=me.getX();
  y=me.getY();
  ac.play();
  Thread thd=new Thread(this);
  thd.start();
 }

 public void run()
 {
  int x,y,cnt;
  x=this.x;
  y=this.y;
  Graphics g=getGraphics();
  g.setXORMode(new Color(50,50,255));
  for(cnt=1;cnt<=7;cnt++)
  {
   g.drawOval(x-cnt*10,y-cnt*10,2*cnt*10,2*cnt*10);   
   try
   {
    Thread.sleep(100);
   }
   catch(InterruptedException e){}
   g.drawOval(x-cnt*10,y-cnt*10,2*cnt*10,2*cnt*10);   
  }
 }
}