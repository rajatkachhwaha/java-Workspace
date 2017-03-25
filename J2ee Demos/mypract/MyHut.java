import java.applet.*;
import java.awt.*;

/*
 <applet code="MyHut" width=700 height=500>
 </applet>
*/

public class MyHut extends Applet
{

 public void init()
 {
  
   setBackground(Color.blue);
 }
  
  public void paint(Graphics g)
  {
   int x1[]={200,300,300,100,100};
   int x2[]={200,500,600,300};
   int y1[]={100,150,250,250,150};
   int y2[]={100,100,150,150};
   
   g.setColor(new Color(200,200,0));
   g.fillPolygon(x1,y1,5);
  }
}   
   
   
  
 