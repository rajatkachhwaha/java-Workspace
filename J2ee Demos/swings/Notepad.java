import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class ReplaceDlg extends JDialog implements ActionListener,KeyListener
{
 JTextField tSer,tRep;
 JButton bSer,bRep,bAll,bCls;
 
 NotepadFrame nf;

 StringBuffer sb; 
 int index;

 ReplaceDlg(NotepadFrame nf)
 {
  //super(nf,true);		//'true' for Modal Dialog Box

  super(nf);			//modeless dialog box
  this.nf=nf;
  sb=new StringBuffer(nf.txt.getText());

  setTitle("Find and Replace");
  setSize(550,175);
  
  JLabel l1,l2;

  l1=new JLabel("Search What ?");
  l1.setFont(new Font("lucida console",Font.PLAIN,14));
    
  l2=new JLabel("Replace With ?");
  l2.setFont(new Font("lucida console",Font.PLAIN,14));

  tSer=new JTextField();
  tSer.setFont(new Font("lucida console",Font.PLAIN,14));
    
  tRep=new JTextField();
  tRep.setFont(new Font("lucida console",Font.PLAIN,18));

  bSer=new JButton("Find");
  bSer.setFont(new Font("lucida console",Font.PLAIN,14));
  bSer.setEnabled(false);
  
  bRep=new JButton("Replace");
  bRep.setFont(new Font("lucida console",Font.PLAIN,14));
  bRep.setEnabled(false);

  bAll=new JButton("Replace All");
  bAll.setFont(new Font("lucida console",Font.PLAIN,14));
  bAll.setEnabled(false);

  bCls=new JButton("Cancel");
  bCls.setFont(new Font("lucida console",Font.PLAIN,14));

  DPanel dp=new DPanel(15,15,15,15);
  add(dp);

  dp.setLayout(new BorderLayout(5,10));

  DPanel p1=new DPanel(7,7,7,7);
  p1.setLayout(new GridLayout(2,1,5,5));
  p1.setBorder(BorderFactory.createLineBorder(new Color(150,150,255),2));

  JPanel p11=new JPanel();
  p11.setLayout(new BorderLayout(18,5));
  p11.add(l1,BorderLayout.WEST);
  p11.add(tSer,BorderLayout.CENTER);
  
  JPanel p12=new JPanel();
  p12.setLayout(new BorderLayout(10,5));
  p12.add(l2,BorderLayout.WEST);
  p12.add(tRep,BorderLayout.CENTER);

  p1.add(p11);
  p1.add(p12);

  JPanel p2=new JPanel();
  p2.setLayout(new GridLayout(1,4,4,5));
  p2.add(bSer);
  p2.add(bRep);
  p2.add(bAll);
  p2.add(bCls);
  
  dp.add(p1,BorderLayout.CENTER);
  dp.add(p2,BorderLayout.SOUTH);

  bSer.addActionListener(this);
  bRep.addActionListener(this);
  bAll.addActionListener(this);
  bCls.addActionListener(this);
  
  tSer.addKeyListener(this);  
 }

 public void keyTyped(KeyEvent ke){}
 public void keyPressed(KeyEvent ke){}

 public void keyReleased(KeyEvent ke)
 {
  if(tSer.getText().length()>0)
  {
   bSer.setEnabled(true);
  }
  else
  {
   bSer.setEnabled(false);
   bRep.setEnabled(false);
  }
 }

 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==bCls)
  {
   dispose();   
  }
  else
  if(ae.getSource()==bSer)
  {
   index=sb.indexOf(tSer.getText(),index);
   if(index==-1)
   {
    Toolkit.getDefaultToolkit().beep();
    JOptionPane.showMessageDialog(nf,"Search Complete...");
    index=0;
    bSer.setLabel("Find");
    bRep.setEnabled(false);
    bAll.setEnabled(false);
   }
   else
   {
    bRep.setEnabled(true);
    bSer.setLabel("Find Next");
    nf.txt.select(index,index+tSer.getText().length());
    nf.txt.requestFocus(); 
    index=index+tSer.getText().length();
    bAll.setEnabled(true);
   }  
  }
  else
  if(ae.getSource()==bRep)
  {
   int i=index-tSer.getText().length();
   sb.replace(i,index,tRep.getText());
   nf.txt.setText(sb.toString());
   index=i+tRep.getText().length();
  
   actionPerformed(new ActionEvent(bSer,1,bSer.getLabel()));
   
  }
  else
  if(ae.getSource()==bAll)
  {
   int cnt=0;
   index=index-tSer.getText().length();
   while(index!=-1)
   {
    cnt++;
    sb.replace(index,index+tSer.getText().length(),tRep.getText());
    index=sb.indexOf(tSer.getText(),index+tRep.getText().length());
   }
   nf.txt.setText(sb.toString());
   JOptionPane.showMessageDialog(nf,cnt+" replacements done");
   bSer.setLabel("Find");
   bRep.setEnabled(false);
   bAll.setEnabled(false);
  }
 }
}

class DPanel extends JPanel
{
 int top,left,bottom,right;

 DPanel(int top,int left,int bottom,int right)
 {
  this.top=top;
  this.left=left;
  this.bottom=bottom;
  this.right=right;  
 }

 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
 }

 public Insets getInsets()
 {
  return new Insets(top,left,bottom,right); 
 }
}



class NotepadFrame extends JFrame implements ActionListener 
{
 JMenuItem fNew,fOpn,fSav,fSas,mExit;
 JMenuItem eFnR;
 JMenuItem mFont,mColr;

 JTextArea txt;
 String str="";

 File fname;
 
 NotepadFrame()
 {
  super("NotePad - Untitled");
  setSize(700,500);
  setLocation(200,100);

  fNew=new JMenuItem("New");
   fNew.setToolTipText("starts a new file");
   fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK));

  fOpn=new JMenuItem("Open");
   fOpn.setToolTipText("opens a new file");
   fOpn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));

  fSav=new JMenuItem("Save"); 
   fSav.setToolTipText("save file");
   fSav.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));

  fSas=new JMenuItem("Save As");
   fSas.setToolTipText("save file as");

  mExit=new JMenuItem("Exit");
  KeyStroke ks=KeyStroke.getKeyStroke(KeyEvent.VK_E,Event.CTRL_MASK);
  mExit.setAccelerator(ks);

  eFnR=new JMenuItem("Find and Replace");
   eFnR.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,Event.CTRL_MASK));

  mFont=new JMenuItem("Font");

  mColr=new JMenuItem("Color");
   mColr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,Event.CTRL_MASK));

  JMenu mFile,mEdit,mFrmt;
 
  mFile=new JMenu("File");
   mFile.setMnemonic(KeyEvent.VK_F);
  mEdit=new JMenu("Edit");
   mEdit.setMnemonic(KeyEvent.VK_E);
  mFrmt=new JMenu("Format");
   mFrmt.setMnemonic(KeyEvent.VK_O);

  mFile.add(fNew);
  mFile.add(fOpn);
  mFile.add(fSav);
  mFile.add(fSas);
  mFile.addSeparator();
  mFile.add(mExit);

  mEdit.add(eFnR);
  mFrmt.add(mFont);
  mFrmt.add(mColr);

  JMenuBar mb=new JMenuBar();

  mb.add(mFile);
  mb.add(mEdit);
  mb.add(mFrmt);

  setJMenuBar(mb);

  txt=new JTextArea();
  txt.setFont(new Font("lucida console",Font.PLAIN,12));
  JScrollPane jsp=new JScrollPane(txt);

  add(jsp);

  fOpn.addActionListener(this);
  fNew.addActionListener(this);  
  fSav.addActionListener(this);
  fSas.addActionListener(this);

  mExit.addActionListener(this);

  eFnR.addActionListener(this);

  addWindowListener(new MyWndAdapter(this));
 }

 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==mExit)
  {
   System.exit(0);
  }

  if(ae.getSource()==eFnR)
  {
   ReplaceDlg rd=new ReplaceDlg(this);
   rd.setVisible(true);
   Point pt=getLocation();
   rd.setLocation(pt.x+100,pt.y+100);
  }
  else
  if(ae.getSource()==fOpn)
  {
   JFileChooser jfc=new JFileChooser();
   int opt=jfc.showOpenDialog(this);
   if(opt==JFileChooser.CANCEL_OPTION)
    return;
   
   fname=jfc.getSelectedFile();
   setTitle("Notepad - "+fname.getName());

   try
   {
    str="";
    FileReader fr=new FileReader(fname);    
    BufferedReader br=new BufferedReader(fr);
    String s=br.readLine();
    while(s!=null)
    {
     str=str+s+"\n";
     s=br.readLine();
    }

    fr.close();
    txt.setText(str);
   }
   catch(IOException e){}
  }
  else
  if(ae.getSource()==fNew)
  {
   setTitle("Notepad - Untitled");
   str="";
   fname=null;
   txt.setText("");
  
  }
  else
  if(ae.getSource()==fSav)
  {
   if(fname==null)
   {
    saveAs();
    return;
   }

   str=txt.getText();
   try
   {
    FileWriter fw=new FileWriter(fname);
    BufferedWriter bw=new BufferedWriter(fw);
    bw.write(str.replace("\n","\r\n"));
    bw.flush();
    fw.close();
   }
   catch(IOException e){}    
  }
  else
  if(ae.getSource()==fSas)
  {
   saveAs();
  }
   
 } 

 void saveAs()
 {
  JFileChooser jfc=new JFileChooser();
  int opt=jfc.showSaveDialog(this);
  if(opt==JFileChooser.CANCEL_OPTION)
   return;

  fname=jfc.getSelectedFile();  
  setTitle("Notepad - "+fname.getName());   
  str=txt.getText();
  try
  {
   FileWriter fw=new FileWriter(fname);
   BufferedWriter bw=new BufferedWriter(fw);
   bw.write(str.replace("\n","\r\n"));
   bw.flush();
   fw.close();
  }
  catch(IOException e){}    
 }
}

class MyWndAdapter extends WindowAdapter
{
 NotepadFrame npf;

 MyWndAdapter(NotepadFrame npf)
 {
  this.npf=npf;
 }

 public void windowClosing(WindowEvent we)
 {
  if(npf.str.equals(npf.txt.getText()))
  {
   System.exit(0); 
  }
  
  String msg="Do you want to Save Changes";
  int opt=JOptionPane.showConfirmDialog(npf,msg,"Notepad",JOptionPane.YES_NO_CANCEL_OPTION);

  if(opt==JOptionPane.CANCEL_OPTION)
   return;
    
  if(opt==JOptionPane.NO_OPTION)
   System.exit(0);

  if(npf.fname==null)
   npf.saveAs();
  else
  {
   npf.str=npf.txt.getText();
   try
   {
    FileWriter fw=new FileWriter(npf.fname);
    BufferedWriter bw=new BufferedWriter(fw);
    bw.write(npf.str.replace("\n","\r\n"));
    bw.flush();
    fw.close();
   }
   catch(IOException e){}    
  }  
 }
}

class notepad
{
 public static void main(String arg[])
 {
  NotepadFrame nf=new NotepadFrame();
  nf.setVisible(true);
  nf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 }
} 
 