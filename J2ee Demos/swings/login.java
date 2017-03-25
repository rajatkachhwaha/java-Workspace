import java.awt.*;
import javax.swing.*;

class LoginFrame extends JFrame
{
 JTextField tLog;
 JPasswordField tPas;
 JButton bSubmit,bCancel,bHelp;
 LoginFrame()
 {
  super("Login");
  setSize(400,240);
  setLocation(200,100);
 
  MainPanel mp=new MainPanel(20,20,20,20);
  add(mp);

  JLabel l1=new JLabel("Login");
  l1.setFont(new Font("lucida console",Font.PLAIN,18));

  JLabel l2=new JLabel("Password");
  l2.setFont(new Font("lucida console",Font.PLAIN,18));
  
  tLog=new JTextField();
  tLog.setFont(new Font("lucida console",Font.PLAIN,18));
  
  tPas=new JPasswordField();
  tPas.setFont(new Font("lucida console",Font.PLAIN,18));

  bSubmit=new JButton("Submit");
  bSubmit.setFont(new Font("lucida console",Font.PLAIN,18));
  
  bCancel=new JButton("Cancel");
  bCancel.setFont(new Font("lucida console",Font.PLAIN,18));

  bHelp=new JButton("Help");
  bHelp.setFont(new Font("lucida console",Font.PLAIN,18));
  
  mp.setLayout(new BorderLayout(5,25));
  
  JPanel p1=new JPanel();
  p1.setBackground(new Color(200,200,255));
  p1.setLayout(new BorderLayout(43,5));
  p1.add(l1,BorderLayout.WEST);
  p1.add(tLog,BorderLayout.CENTER);

  JPanel p2=new JPanel();
  p2.setBackground(new Color(200,200,255));
  p2.setLayout(new BorderLayout(10,5));
  p2.add(l2,BorderLayout.WEST);
  p2.add(tPas,BorderLayout.CENTER);

  MainPanel p12=new MainPanel(8,8,8,8);
  p12.setBackground(new Color(200,200,255));
  p12.setLayout(new GridLayout(2,1,5,5));
  p12.setBorder(BorderFactory.createLineBorder(new Color(100,100,255),2));

  p12.add(p1);
  p12.add(p2);

  MainPanel p3=new MainPanel(8,8,8,8);
  p3.setBackground(new Color(200,200,255));
  p3.setLayout(new GridLayout(1,3,10,0));
  p3.add(bSubmit);
  p3.add(bCancel);
  p3.add(bHelp);

  p3.setBorder(BorderFactory.createLineBorder(new Color(100,100,255),2));

  mp.add(p12,BorderLayout.CENTER);
  mp.add(p3,BorderLayout.SOUTH);
 }
}

class MainPanel extends JPanel
{
 int top,left,bottom,right;

 MainPanel(int top,int left,int bottom,int right)
 {
  this.left=left;
  this.top=top;
  this.right=right;
  this.bottom=bottom;
 }

 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  
  setBackground(new Color(200,200,255));
 }
 
 public Insets getInsets()
 {
  return new Insets(top,left,bottom,right);
 }
}

class Login
{
 public static void main(String arg[])
 {
  LoginFrame lf=new LoginFrame();
  lf.setVisible(true);
  lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}