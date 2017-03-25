import java.applet.*;
import java.awt.*;

/*
<applet code="MyApplet" width=700 height=500>
</applet>
*/


public class MyApplet extends Applet
{
 public String str="";
 
 public void init()
 {
  str=str+"init..";
  setBackground(Color.yellow);
  setForeground(Color.red);
 }
 
 public void start()
 {
  str=str+"start..";
 }
 
 public void stop()
 {
  str=str+"stop..";
 }

 public void destroy()
 {
  str=str+"destroy..";
 }

 public void paint(Graphics g)
 {
  str=str+"paint..";
  g.drawString(str,50,100);
 }
} 

  
 