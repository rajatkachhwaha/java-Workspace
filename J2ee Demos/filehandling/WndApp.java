import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame
{
 MyFrame()
 {
  super("WndApp");
  setSize(700,600);
  setLocation(250,50);

  //setTitle("DMatics");


  addWindowListener(new MyWndAdapter(this));  
 }
}

class MyWndAdapter extends WindowAdapter
{
 MyFrame mf;

 MyWndAdapter(MyFrame mf)
 {
  this.mf=mf;
 }
 
 public void windowClosing(WindowEvent we)
 {
  mf.dispose();		//closes frame
  System.exit(0);	//closes application
 }
}

class WndApp
{
 public static void main(String arg[])
 {
  MyFrame mf=new MyFrame();
  mf.setVisible(true);
 }
}