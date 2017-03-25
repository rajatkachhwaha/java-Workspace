import java.awt.*;
import java.applet.*;

/*
 <applet code="MarqueeXOR" width=700 height=500>
 <param name="title" value="Rajat">  
 <param name="size" value="40">
 </applet>
*/
 
public class MarqueeXOR extends Applet implements Runnable
{
 private Thread thd;
 private int x;
 private Dimension d;
 private String str;

 public void init()
 {
  setBackground(Color.blue);
  setForeground(Color.white);

  int n;
  try
  {
   n=Integer.parseInt(getParameter("size"));
  }
  catch(NumberFormatException e)
  {
   n=20; 
  }
  setFont(new Font("lucida console",Font.PLAIN,n));

  d=getSize();
  x=d.width;

  str=getParameter("title");  
  if(str==null)
   str="dmatics";
  
  AudioClip ac=getAudioClip(getCodeBase(),"spacemusic.au");
  thd=new Thread(this);
  thd.start();
   
 }

 public void run()
 {
  Graphics g=getGraphics();
  g.setXORMode(Color.blue);
  
  while(true)
  {
   g.drawString(str,x,50);
      
   try
   {
    Thread.sleep(10);
   }
   catch(InterruptedException e){}
   g.drawString(str,x,50);
   
   x--;
   
   if(x<-100)
    x=d.width;
  }
 }

 public void paint(Graphics g)
 {
  d=getSize();
  x=d.width;
 }
} 
 