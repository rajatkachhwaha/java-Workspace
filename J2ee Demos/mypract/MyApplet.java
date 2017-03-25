import java.applet.*;
import java.awt.*;

/*
<applet code="MyApplet" width=600 height=500>
</applet>
*/

public class MyApplet extends Applet
{
 private String str="";
 
 public void init()
 {
  setBackground(Color.yellow);
  setForeground(Color.red);
  setFont(new Font("arial",Font.PLAIN,15));
  str=str+"init..";
 }
 
 public void start()
 {
  str=str+"start..";
 }
  
 public void paint(Graphics g)
 {
  str=str+"paint..";
  g.drawString(str,20,100);
 }
 
 public void stop()
 {
  str=str+"stop..";
 }
 
 public void destroy()
 {
  str=str+"destroy..";
 }
}