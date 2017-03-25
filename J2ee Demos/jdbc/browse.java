import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BrowseFrame extends JFrame implements ActionListener
{
 JTextField tRno,tBrn,tNam,tDob,tMrx;
 JButton bFst,bLst,bNxt,bPrv;
 ResultSet rs; 
 int curRec=1,totRecs;

 BrowseFrame()
 {
  setSize(400,250);
  setLocation(200,100);
  setTitle("dmatics.studs : ");

  try
  {
   Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dmatics","root","dmatics");
   Statement st=cn.createStatement();
   rs=st.executeQuery("select count(*) as cnt from studs");
   rs.next();
   totRecs=rs.getInt("cnt");
   st.close();

   st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);   
   rs=st.executeQuery("select * from studs");
   rs.next();
  }
  catch(SQLException e)
  {
   JOptionPane.showMessageDialog(this,"SQL Error : "+e.getMessage());
  }

  MainPanel mp=new MainPanel();
  add(mp);

  JLabel l1=new JLabel("Roll #");
  l1.setFont(new Font("lucida console",Font.PLAIN,18));
  tRno=new JTextField();
  tRno.setFont(new Font("lucida console",Font.PLAIN,16));
  tRno.setEditable(false);
  
  JLabel l2=new JLabel("Branch");
  l2.setFont(new Font("lucida console",Font.PLAIN,18));
  tBrn=new JTextField();
  tBrn.setFont(new Font("lucida console",Font.PLAIN,16));
  tBrn.setEditable(false);

  JLabel l3=new JLabel("Name");
  l3.setFont(new Font("lucida console",Font.PLAIN,18));
  tNam=new JTextField();
  tNam.setFont(new Font("lucida console",Font.PLAIN,16));
  tNam.setEditable(false);

  JLabel l4=new JLabel("DOB");
  l4.setFont(new Font("lucida console",Font.PLAIN,18));
  tDob=new JTextField();
  tDob.setFont(new Font("lucida console",Font.PLAIN,16));
  tDob.setEditable(false);

  JLabel l5=new JLabel("Marks");
  l5.setFont(new Font("lucida console",Font.PLAIN,18));
  tMrx=new JTextField();
  tMrx.setFont(new Font("lucida console",Font.PLAIN,16));
  tMrx.setEditable(false);

  bFst=new JButton("|<<");
  bFst.setFont(new Font("lucida console",Font.PLAIN,18));

  bPrv=new JButton("<<");
  bPrv.setFont(new Font("lucida console",Font.PLAIN,18));

  bNxt=new JButton(">>");
  bNxt.setFont(new Font("lucida console",Font.PLAIN,18));
  bLst=new JButton(">>|");
  bLst.setFont(new Font("lucida console",Font.PLAIN,18));

  mp.setLayout(new GridLayout(6,1,10,10));

  JPanel p1=new JPanel();
  p1.setLayout(new GridLayout(1,2,35,5));
  p1.setBackground(new Color(190,190,255));

   JPanel p11=new JPanel();
   p11.setBackground(new Color(190,190,255));
   p11.setLayout(new GridLayout(1,2,5,5));
   p11.add(l1);
   p11.add(tRno);

   JPanel p12=new JPanel();
   p12.setBackground(new Color(190,190,255));
   p12.setLayout(new GridLayout(1,2,5,5));
   p12.add(l2);
   p12.add(tBrn);

  p1.add(p11);
  p1.add(p12);

  JPanel p2=new JPanel();
  p2.setBackground(new Color(190,190,255));
  p2.setLayout(new BorderLayout(39,5));
  p2.add(l3,BorderLayout.WEST);
  p2.add(tNam,BorderLayout.CENTER);

  JPanel p3=new JPanel();
  p3.setLayout(new BorderLayout(51,5));
  p3.setBackground(new Color(190,190,255));

   JPanel p31=new JPanel();
   p31.setBackground(new Color(190,190,255));
   p31.setLayout(new GridLayout(1,2,20,5));
   p31.add(tDob);
   p31.add(new JLabel());
   
  p3.add(l4,BorderLayout.WEST);
  p3.add(p31,BorderLayout.CENTER);

  JPanel p4=new JPanel();
  p4.setBackground(new Color(190,190,255));
  p4.setLayout(new BorderLayout(27,5));

   JPanel p41=new JPanel();
   p41.setBackground(new Color(190,190,255));
   p41.setLayout(new GridLayout(1,3,20,5));
   p41.add(tMrx);
   p41.add(new JLabel());
   p41.add(new JLabel());

  p4.add(l5,BorderLayout.WEST);
  p4.add(p41,BorderLayout.CENTER);

  JPanel p5=new JPanel();
  p5.setBackground(new Color(190,190,255));
  p5.setLayout(new GridLayout(1,4,10,10));
  p5.add(bFst);
  p5.add(bPrv);
  p5.add(bNxt);
  p5.add(bLst);
   
  mp.add(p1);
  mp.add(p2);
  mp.add(p3);
  mp.add(p4);
  mp.add(new JLabel());
  mp.add(p5);

  printRec();

  bFst.addActionListener(this);
  bPrv.addActionListener(this);
  bNxt.addActionListener(this);
  bLst.addActionListener(this);

 }

 public void actionPerformed(ActionEvent ae)
 {
  try
  {
   if(ae.getSource()==bFst)
   {
    curRec=1;
    rs.first();
    printRec();
   }
   else
   if(ae.getSource()==bPrv)
   {
    if(!rs.isFirst())
    {
     curRec--;
     rs.previous();
     printRec();
    }
    else
     Toolkit.getDefaultToolkit().beep();
   }
   else
   if(ae.getSource()==bNxt)
   {
    if(!rs.isLast())
    {
     curRec++;
     rs.next();
     printRec();
    }
    else
     Toolkit.getDefaultToolkit().beep();
   }
   else
   if(ae.getSource()==bLst)
   {
    curRec=totRecs;
    rs.last();
    printRec();
   }
  }
  catch(SQLException e)
  {
   JOptionPane.showMessageDialog(this,"Move Error : "+e.getMessage());
  }
 }

 void printRec()
 {
  setTitle("dmatics.studs : "+curRec+"/"+totRecs);
  try
  {
   int rn,d,m,y,tot;
   String fn,ln,brn;

   rn=rs.getInt(1);

   Date dt=rs.getDate("dob");
   d=dt.getDate();
   m=dt.getMonth()+1;
   y=dt.getYear()+1900;

   tot=rs.getInt("marks");

   fn=rs.getString("fname");
   ln=rs.getString("lname");

   brn=rs.getString("branch");
    
   tRno.setText(rn+"");
   tBrn.setText(brn);
   tNam.setText(fn+" "+ln);
   tDob.setText(d+"/"+m+"/"+y);
   tMrx.setText(tot+"");
  }
  catch(SQLException e)
  {
   JOptionPane.showMessageDialog(this,"print : "+e.getMessage());
  }
 }

}

class MainPanel extends JPanel
{
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  setBackground(new Color(190,190,255));
 }
 
 public Insets getInsets()
 {
  return new Insets(20,15,15,15);
 }
}

class Browse
{
 public static void main(String arg[])
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
 
  BrowseFrame bf=new BrowseFrame();
  bf.setVisible(true);
  bf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
} 
  