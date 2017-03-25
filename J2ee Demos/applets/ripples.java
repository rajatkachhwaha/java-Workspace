import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 <applet code="Ripples" width=500 height=500>
 </applet>
*/ 

public class Ripples extends Applet implements MouseListener
{
 AudioClip ac;
 public void init()
 {
  ac=getAudioClip(getCodeBase(),"drip.au");
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
  new GenerateRipples(x-10,y-10);   
 }

 class GenerateRipples extends Thread
 {
  int x,y,wh=20;
  Graphics g;
  int red,grn,blu;

  GenerateRipples(int x,int y)
  {
   this.x=x;
   this.y=y;
   g=getGraphics();

   red=(int)(Math.random()*1000)%256;
   grn=(int)(Math.random()*1000)%256;
   blu=(int)(Math.random()*1000)%256;

   start();
  }
  
  public void run()
  {
   g.setColor(new Color(red,grn,blu));
   g.setXORMode(Color.white);
   while(wh<=80)
   {  
    g.drawOval(x,y,wh,wh);
    try
    {
     Thread.sleep(100);
    }
    catch(InterruptedException e){}
    g.drawOval(x,y,wh,wh);
    wh=wh+20;
    x=x-10;
    y=y-10;
   } 
  }  

 }
}