import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AppendFrame extends JFrame implements ActionListener
{
 int actno;
     
 JTextField tAct,tNam,tBal;
 JButton bIns,bCcl,bExt;

 PreparedStatement pst;

 AppendFrame()
 {
  setSize(500,270);
  setLocation(200,100);
  setTitle("RBS - Create Account");
  
  try
  {  
   Connection cn;
   cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","rajat_16");

   Statement st;
   st=cn.createStatement();
   ResultSet rs;
   rs=st.executeQuery("select max(actno) as ac from cust");
   rs.next();
   actno=rs.getInt("ac");
   if(actno==0)
    actno=101;
   else
    actno++;

   st.close();
 
   pst=cn.prepareStatement("insert into cust values(?,?,?)"); 

  }
  catch(SQLException e)
  {
   JOptionPane.showMessageDialog(this,"Connection - "+e.getMessage());
  }

  AppendPanel ap=new AppendPanel();
  add(ap);
  
  JLabel l1=new JLabel("Acct. No.");
  l1.setFont(new Font("lucida console",Font.PLAIN,18));
  JLabel l2=new JLabel("Cust Name");
  l2.setFont(new Font("lucida console",Font.PLAIN,18));
  JLabel l3=new JLabel("Open Amt");
  l3.setFont(new Font("lucida console",Font.PLAIN,18));

  tAct=new JTextField(actno+"");
  tAct.setFont(new Font("lucida console",Font.PLAIN,18));
  tAct.setBackground(new Color(0,0,255));
  tAct.setForeground(Color.white);
  tAct.setEditable(false);

  tNam=new JTextField();
  tNam.setFont(new Font("lucida console",Font.PLAIN,18));
  tBal=new JTextField();
  tBal.setFont(new Font("lucida console",Font.PLAIN,18));

  bIns=new JButton("Submit");
  bIns.setFont(new Font("lucida console",Font.PLAIN,18));

  bCcl=new JButton("Cancel");
  bCcl.setFont(new Font("lucida console",Font.PLAIN,18));

  bExt=new JButton("Exit");
  bExt.setFont(new Font("lucida console",Font.PLAIN,18));

  ap.setLayout(new GridLayout(5,1,10,10));
  
  JPanel p1=new JPanel();
  p1.setLayout(new BorderLayout(10,5));
  
   JPanel p11=new JPanel();
   p11.setLayout(new GridLayout(1,2,10,5));
   p11.add(tAct);
   p11.add(new JLabel());

  p1.add(l1,BorderLayout.WEST);
  p1.add(p11,BorderLayout.CENTER);

  JPanel p2=new JPanel();
  p2.setLayout(new BorderLayout(10,5));
  p2.add(l2,BorderLayout.WEST);
  p2.add(tNam,BorderLayout.CENTER);
  
  JPanel p3=new JPanel();
  p3.setLayout(new BorderLayout(20,5));
  
   JPanel p31=new JPanel();
   p31.setLayout(new GridLayout(1,2,10,5));
   p31.add(tBal);
   p31.add(new JLabel());

  p3.add(l3,BorderLayout.WEST);
  p3.add(p31,BorderLayout.CENTER);

  JPanel p4=new JPanel();
  p4.setLayout(new GridLayout(1,3,10,5));
  p4.add(bIns);
  p4.add(bCcl);
  p4.add(bExt);
    
  ap.add(p1);
  ap.add(p2);
  ap.add(p3);
  ap.add(new JLabel());
  ap.add(p4);

  bIns.addActionListener(this);
  bCcl.addActionListener(this);
  bExt.addActionListener(this);
  
 }

 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==bExt)
  {
   System.exit(0);
  }

  if(ae.getSource()==bIns)
  {
   try
   {
    pst.setInt(1,actno);
    pst.setString(2,tNam.getText());
    pst.setInt(3,Integer.parseInt(tBal.getText()));  
    pst.executeUpdate();
    actno++;
    tAct.setText(actno+"");
    tNam.setText("");
    tBal.setText("");
    JOptionPane.showMessageDialog(this,"Account created Successfully !");
    tNam.requestFocus();    
   }
   catch(SQLException e)
   {
    JOptionPane.showMessageDialog(this,"Update failed : "+e.getMessage());
   }
  }
  else
  if(ae.getSource()==bCcl)
  {
   tNam.setText("");
   tBal.setText("");
   tNam.requestFocus();
  }
 }
}

class AppendPanel extends JPanel 
{
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
 }

 public Insets getInsets()
 {
  return new Insets(20,15,15,15);
 }
}

class append
{
 public static void main(String arg [])
 {
  try
  {
   Class.forName("com.mysql.jdbc.Driver");
  }
  catch(ClassNotFoundException e)
  {
   JOptionPane.showMessageDialog(null,"Driver not found.. Aborting..");
   System.exit(1);
  }

  AppendFrame af=new AppendFrame();
  af.setVisible(true);
  af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}
