import java.applet.*;
import java.awt.*;

/*
<applet code="Ball" height=600 width=700>
</applet>
*/

public class Ball extends Applet implements Runnable
{
 int x=30,y=30;
 int xinc=3,yinc=1; 
 AudioClip ac;

 String s=".";

 Thread thd;

 public void init()
 {
  setBackground(Color.white);
  setForeground(Color.red);

  ac=getAudioClip(getCodeBase(),"drip.au");  
  thd=new Thread(this);
  thd.start();  
 }

 public void run()
 {
  Graphics g=getGraphics();
  g.setXORMode(Color.white);
  while(true)
  {
   g.fillOval(x-15,y-15,30,30); 
   try
   {
    Thread.sleep(13);
   }
   catch(InterruptedException e){}
   g.fillOval(x-15,y-15,30,30);

   x=x+xinc;
   y=y+yinc;

   if(x<=15)
   {
    xinc=3;
    ac.play();
   }
   else
   if(x>=685)
   {
    xinc=-3;
    ac.play();
   }

   if(y<=15)
   {
    yinc=1;
    ac.play();
   }
   else
   if(y>=585)
   {
    yinc=-1;
    ac.play();
   } 
  }
 }

 public void paint(Graphics g)
 {
  g.fillOval(x-15,y-15,30,30); 
 }

}