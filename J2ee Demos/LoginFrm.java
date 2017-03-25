import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class LoginFrame extends Frame implements ActionListener
{
 TextField tLog,tPas;
 Button bSubmit,bCancel,bHelp;

 LoginFrame()
 {
  super("Login");
  setSize(500,250);
  //setResizable(false);
  setLocation(200,100);

  Label l1=new Label("Login");
  l1.setFont(new Font("lucida console",Font.PLAIN,18));
  
  Label l2=new Label("Password");
  l2.setFont(new Font("lucida console",Font.PLAIN,18));

  tLog=new TextField();
  tLog.setFont(new Font("lucida console",Font.PLAIN,18));

  tPas=new TextField();
  tPas.setFont(new Font("lucida console",Font.PLAIN,18));
  tPas.setEchoChar('#');

  bSubmit=new Button("Submit");
  bSubmit.setFont(new Font("lucida console",Font.PLAIN,18));
  bSubmit.setBackground(new Color(180,180,255));
  bSubmit.setForeground(Color.white);

  bCancel=new Button("Cancel");
  bCancel.setFont(new Font("lucida console",Font.PLAIN,18));
  bCancel.setBackground(new Color(255,180,180));
  bCancel.setForeground(Color.white);

  bHelp=new Button("Help");
  bHelp.setFont(new Font("lucida console",Font.PLAIN,18));
  bHelp.setBackground(new Color(180,255,180));
  bHelp.setForeground(Color.white);

  Panel p1=new Panel();
  p1.setLayout(new BorderLayout(40,5));
  p1.add(l1,BorderLayout.WEST);
  p1.add(tLog,BorderLayout.CENTER);

  Panel p2=new Panel();
  p2.setLayout(new BorderLayout(5,5));
  p2.add(l2,BorderLayout.WEST);
  p2.add(tPas,BorderLayout.CENTER);

  Panel p3=new Panel();
  p3.setLayout(new GridLayout(1,3,10,5));
  p3.add(bSubmit);
  p3.add(bCancel);
  p3.add(bHelp);

  setLayout(new GridLayout(4,1,5,15));
  
  add(p1);
  add(p2);
  add(new Label());
  add(p3);

  bCancel.addActionListener(this);
  bSubmit.addActionListener(this);

  addWindowListener(new LoginFrmAdapter());
 }

 public Insets getInsets()
 {
  return new Insets(40,15,15,15);
 }

 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==bCancel)
  {
   System.exit(0);
  }
  else
  if(ae.getSource()==bSubmit)
  {
   String sLog,sPas;
   sLog=tLog.getText();
   sPas=tPas.getText();

   if(sLog.equals("rajat")&&sPas.equals("kachhawa"))
   {
    dispose();
    PaintFrame pf=new PaintFrame();
    pf.setVisible(true);
   }
   else
   {
    Toolkit.getDefaultToolkit().beep();
    JOptionPane.showMessageDialog(null,"invalid login name or password..");
   }
  }
 }
}

class LoginFrmAdapter extends WindowAdapter
{
 public void windowClosing(WindowEvent we)
 {
  System.exit(0);
 }
}

class LoginFrm
{
 public static void main(String arg[])
 {
  LoginFrame lf=new LoginFrame();
  lf.setVisible(true);
 }
}