import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


/*<applet code="Try.java" width=1200 height=600>
</applet>*/


public class Try extends Applet implements MouseListener
{
 public void init()
 {
  setBackground(new Color(255,255,255));
  addMouseListener(this);
 }

 public void mouseEntered(MouseEvent me) {}
 public void mouseExited(MouseEvent me)  {}
 public void mouseClicked(MouseEvent me) {}
 public void mouseReleased(MouseEvent me){}



 public void mousePressed(MouseEvent me)
 {
  int q,w,m;
  q=me.getX();
  w=me.getY();
  Date dt=new Date();
  int time[]=new int[10];
  time[0]=dt.getHours();
  time[1]=dt.getMinutes();
  time[2]=dt.getSeconds();
  //System.out.println(time[0]+"\n"+time[1]+"\n"+time[2]);
  if(time[0]>12)
   time[0]=time[0]-12;
  int counter=0;
  int arr[]=new int[10];
  for(m=0;m<3;m++)
  {
   int x=time[m];
   int i=1,j;
   j=x;
   if(x<10)
   {
    arr[counter++]=0;
    arr[counter++]=x;
   }
   else
   {
    while(x>=10)
    {
     x=x/10;
     i=i*10;
    }
    while(i>=1)
    {
     x=j/i;
     j=j%i;
     arr[counter++]=x;
     i=i/10; 
    }
   }
  }
  for(int i=0;i<6;i++)
  {
   System.out.println(arr[i]);
  }
  for(int i=0;i<6;i++)
  {
   Graphics g=getGraphics();
   int t=arr[i];
   if(t==0)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;
    int xc1[]={x,x+20,x+15,x-5,x-20,x-15};
    int yc1[]={y,y+25,y+85,y+105,y+90,y+15};
    g.setColor(Color.black);
    g.fillPolygon(xc1,yc1,6);

  x=x1;
  y=y1;
  x=x+5;
  int xc2[]={x,x+20,x+85,x+105,x+90,x+15};
  int yc2[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc2,yc2,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  int xc3[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc3[]={y,y+25,y+85,y+105,y+82,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc3,yc3,6);
  
  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  y=y+1;
  int xc5[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc5[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc5,yc5,6);

  x=x-5;
  y=y+105;
  y=y+5;
  int xc6[]={x,x+25,x+85,x+100,x+90,x+15};
  int yc6[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc6,yc6,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   else if(t==1)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;



  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  int xc3[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc3[]={y,y+25,y+85,y+105,y+82,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc3,yc3,6);
  

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   else if(t==2)
   {    
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;

  x=x1;
  y=y1;
  x=x+5;
  int xc2[]={x,x+20,x+85,x+105,x+90,x+15};
  int yc2[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc2,yc2,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  int xc3[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc3[]={y,y+25,y+85,y+105,y+82,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc3,yc3,6);

  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  x=x+5;
  int xc4[]={x,x+22,x+85,x+100,x+90,x+15};
  int yc4[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc4,yc4,6);
  
  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  y=y+1;
  int xc5[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc5[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc5,yc5,6);

  x=x-5;
  y=y+105;
  y=y+5;
  int xc6[]={x,x+25,x+85,x+100,x+90,x+15};
  int yc6[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc6,yc6,6);

   }
   else if(t==3)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;


  x=x1;
  y=y1;
  x=x+5;
  int xc2[]={x,x+20,x+85,x+105,x+90,x+15};
  int yc2[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc2,yc2,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  int xc3[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc3[]={y,y+25,y+85,y+105,y+82,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc3,yc3,6);
  
  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  x=x+5;
  int xc4[]={x,x+22,x+85,x+100,x+90,x+15};
  int yc4[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc4,yc4,6);


  x=x-5;
  y=y+105;
  y=y+5;
  int xc6[]={x,x+25,x+85,x+100,x+90,x+15};
  int yc6[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc6,yc6,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   else if(t==4)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;
    int xc1[]={x,x+20,x+15,x-5,x-20,x-15};
    int yc1[]={y,y+25,y+85,y+105,y+90,y+15};
    g.setColor(Color.black);
    g.fillPolygon(xc1,yc1,6);


  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  int xc3[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc3[]={y,y+25,y+85,y+105,y+82,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc3,yc3,6);

  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  x=x+5;
  int xc4[]={x,x+22,x+85,x+100,x+90,x+15};
  int yc4[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc4,yc4,6);
  

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   else if(t==5)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;
    int xc1[]={x,x+20,x+15,x-5,x-20,x-15};
    int yc1[]={y,y+25,y+85,y+105,y+90,y+15};
    g.setColor(Color.black);
    g.fillPolygon(xc1,yc1,6);

  x=x1;
  y=y1;
  x=x+5;
  int xc2[]={x,x+20,x+85,x+105,x+90,x+15};
  int yc2[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc2,yc2,6);

  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  x=x+5;
  int xc4[]={x,x+22,x+85,x+100,x+90,x+15};
  int yc4[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc4,yc4,6);
  

  x=x-5;
  y=y+105;
  y=y+5;
  int xc6[]={x,x+25,x+85,x+100,x+90,x+15};
  int yc6[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc6,yc6,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   else if(t==6)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;
    int xc1[]={x,x+20,x+15,x-5,x-20,x-15};
    int yc1[]={y,y+25,y+85,y+105,y+90,y+15};
    g.setColor(Color.black);
    g.fillPolygon(xc1,yc1,6);

  x=x1;
  y=y1;
  x=x+5;
  int xc2[]={x,x+20,x+85,x+105,x+90,x+15};
  int yc2[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc2,yc2,6);

  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  x=x+5;
  int xc4[]={x,x+22,x+85,x+100,x+90,x+15};
  int yc4[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc4,yc4,6);
  
  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  y=y+1;
  int xc5[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc5[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc5,yc5,6);

  x=x-5;
  y=y+105;
  y=y+5;
  int xc6[]={x,x+25,x+85,x+100,x+90,x+15};
  int yc6[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc6,yc6,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   else if(t==7)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;

  x=x1;
  y=y1;
  x=x+5;
  int xc2[]={x,x+20,x+85,x+105,x+90,x+15};
  int yc2[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc2,yc2,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  int xc3[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc3[]={y,y+25,y+85,y+105,y+82,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc3,yc3,6);

  



  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   else if(t==8)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;
    int xc1[]={x,x+20,x+15,x-5,x-20,x-15};
    int yc1[]={y,y+25,y+85,y+105,y+90,y+15};
    g.setColor(Color.black);
    g.fillPolygon(xc1,yc1,6);

  x=x1;
  y=y1;
  x=x+5;
  int xc2[]={x,x+20,x+85,x+105,x+90,x+15};
  int yc2[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc2,yc2,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  int xc3[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc3[]={y,y+25,y+85,y+105,y+82,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc3,yc3,6);

  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  x=x+5;
  int xc4[]={x,x+22,x+85,x+100,x+90,x+15};
  int yc4[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc4,yc4,6);
  
  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  y=y+1;
  int xc5[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc5[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc5,yc5,6);

  x=x-5;
  y=y+105;
  y=y+5;
  int xc6[]={x,x+25,x+85,x+100,x+90,x+15};
  int yc6[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc6,yc6,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   else if(t==9)
   {
    int x,y,x1,y1;
    x=q;
    y=w;
    x1=x;
    y1=y;
    int xc1[]={x,x+20,x+15,x-5,x-20,x-15};
    int yc1[]={y,y+25,y+85,y+105,y+90,y+15};
    g.setColor(Color.black);
    g.fillPolygon(xc1,yc1,6);

  x=x1;
  y=y1;
  x=x+5;
  int xc2[]={x,x+20,x+85,x+105,x+90,x+15};
  int yc2[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc2,yc2,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  int xc3[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc3[]={y,y+25,y+85,y+105,y+82,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc3,yc3,6);

  x=x1;
  y=y1;
  x=x-5;
  y=y+105;
  x=x+5;
  int xc4[]={x,x+22,x+85,x+100,x+90,x+15};
  int yc4[]={y,y-25,y-15,y+5,y+20,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc4,yc4,6);

  x=x1;
  y=y1;
  x=x+5;
  x=x+105;
  y=y+5;
  y=y+5;
  x=x-5;
  y=y+105;
  int xc7[]={x,x+20,x+15,x-5,x-20,x-15};
  int yc7[]={y,y+25,y+85,y+105,y+90,y+15};
  g.setColor(Color.black);
  g.fillPolygon(xc7,yc7,6);
   }
   q=q+180;
   w=w;
  }
 }
}







