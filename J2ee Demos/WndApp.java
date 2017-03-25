import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame 
{
 MyFrame()
 {
  super("Window Application");
  setSize(700,500);
  setLocation(200,100);


  //setTitle("Window Application");

  addWindowListener(new MyWndAdapter());
 }
}

class MyWndAdapter extends WindowAdapter
{

 public void windowClosing(WindowEvent we)
 {
  System.exit(0);
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