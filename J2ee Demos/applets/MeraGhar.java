import java.awt.*;
import java.applet.*;

/*
 <applet code="MeraGhar" width=700 height=500>
 </applet>
*/


public class MeraGhar extends Applet
{

 public void init()
 {
  setBackground(new Color(200,200,255));
 }

 public void paint(Graphics g)
 {
  int x1[]={250,200,200,300,300};
  int y1[]={150,225,350,350,225};
  int x2[]={250,300,500,450};
  int y2[]={150,225,225,150};

  g.setColor(new Color(180,255,180));
  g.fillOval(-150,270,1300,400);
  
  g.setColor(new Color(255,255,180));
  g.fillPolygon(x1,y1,5);

  g.setColor(new Color(255,100,100));
  g.fillPolygon(x2,y2,4);

  g.setColor(new Color(150,150,255));
  g.fillRect(300,225,200,125);  

  g.setColor(new Color(255,210,80));
  g.fillOval(70,70,50,50);

  g.setColor(Color.white);
  g.drawPolygon(x1,y1,5);
  g.drawPolygon(x2,y2,4);
  g.drawRect(300,225,200,125);


 }

}