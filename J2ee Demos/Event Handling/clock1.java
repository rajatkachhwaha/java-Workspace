import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


/*<applet code="Try.java" width=700 height=600>
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
    g.drawLine(q,w,q+10,w);
    g.drawLine(q+10,w,q+10,w+10);
    g.drawLine(q+10,w+10,q+10,w+20);
    g.drawLine(q+10,w+20,q,w+20);
    g.drawLine(q,w+20,q,w+10);
    g.drawLine(q,w+10,q,w);
   }
   else if(t==1)
   {
    g.drawLine(q+10,w,q+10,w+10);
    g.drawLine(q+10,w+10,q+10,w+20);
   }
   else if(t==2)
   {
    g.drawLine(q,w,q+10,w);
    g.drawLine(q+10,w,q+10,w+10);
    g.drawLine(q+10,w+10,q,w+10);
    g.drawLine(q,w+10,q,w+20);
    g.drawLine(q,w+20,q+10,w+20);
   }
   else if(t==3)
   {
    g.drawLine(q,w,q+10,w);
    g.drawLine(q+10,w,q+10,w+10);
    g.drawLine(q+10,w+10,q,w+10);
    g.drawLine(q+10,w+10,q+10,w+20);
    g.drawLine(q+10,w+20,q,w+20);
   }
   else if(t==4)
   {
    g.drawLine(q,w+10,q,w);
    g.drawLine(q+10,w+10,q,w+10);
    g.drawLine(q+10,w,q+10,w+10);
    g.drawLine(q+10,w+10,q+10,w+20);
   }
   else if(t==5)
   {
    g.drawLine(q,w,q+10,w);
    g.drawLine(q+10,w+10,q+10,w+20);
    g.drawLine(q+10,w+20,q,w+20);
    g.drawLine(q,w+10,q,w);
    g.drawLine(q+10,w+10,q,w+10);
   }
   else if(t==6)
   {
    g.drawLine(q,w,q+10,w);
    g.drawLine(q+10,w+10,q,w+10);
    g.drawLine(q+10,w+10,q+10,w+20);
    g.drawLine(q+10,w+20,q,w+20);
    g.drawLine(q,w+20,q,w+10);
    g.drawLine(q,w+10,q,w);
   }
   else if(t==7)
   {
    g.drawLine(q,w,q+10,w);
    g.drawLine(q+10,w,q+10,w+10);
    g.drawLine(q+10,w+10,q+10,w+20);
   }
   else if(t==8)
   {
    g.drawLine(q,w,q+10,w);
    g.drawLine(q+10,w,q+10,w+10);
    g.drawLine(q+10,w+10,q+10,w+20);
    g.drawLine(q+10,w+20,q,w+20);
    g.drawLine(q,w+20,q,w+10);
    g.drawLine(q,w+10,q,w);    
    g.drawLine(q+10,w+10,q,w+10);
   }
   else if(t==9)
   {
    g.drawLine(q,w,q+10,w);
    g.drawLine(q+10,w,q+10,w+10);
    g.drawLine(q+10,w+10,q+10,w+20);
    g.drawLine(q+10,w+10,q,w+10);
    g.drawLine(q,w+10,q,w);
   }
   q=q+20;
   w=w;
  }
 }
}







