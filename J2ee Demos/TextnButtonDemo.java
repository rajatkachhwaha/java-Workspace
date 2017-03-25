import java.awt.*;
import java.awt.event.*;

class TextDemoFrame extends Frame implements ActionListener,KeyListener
{
 TextField tSrc,tDst;
 Button bCpy,bMov,bSel,bClr;

 TextDemoFrame()
 {
  super("Text n Button Demo");
  setSize(700,250);
  setResizable(false);
  setLocation(200,100);

  tSrc=new TextField();
  tSrc.setFont(new Font("lucida console",Font.PLAIN,18));

  tDst=new TextField();
  tDst.setFont(new Font("lucida console",Font.PLAIN,18));
  tDst.setEditable(false);

  bCpy=new Button("Copy");
  bCpy.setFont(new Font("lucida console",Font.PLAIN,18));
  bCpy.setBackground(new Color(160,160,255));
  bCpy.setForeground(Color.white);
  bCpy.setEnabled(false);

  bMov=new Button("Move");
  bMov.setFont(new Font("lucida console",Font.PLAIN,18));
  bMov.setBackground(new Color(255,160,160));
  bMov.setForeground(Color.white);
  bMov.setEnabled(false);

  bSel=new Button("Copy Sel");
  bSel.setFont(new Font("lucida console",Font.PLAIN,18));
  bSel.setBackground(new Color(160,255,160));
  bSel.setForeground(Color.white);
  bSel.setEnabled(false);

  bClr=new Button("Clear");
  bClr.setFont(new Font("lucida console",Font.PLAIN,18));
  bClr.setBackground(new Color(255,255,100));
  bClr.setForeground(Color.white);

  Panel p=new Panel();
  p.setLayout(new GridLayout(1,4,10,5));
  p.add(bCpy);
  p.add(bMov);
  p.add(bSel);
  p.add(bClr);

  setLayout(new GridLayout(4,1,5,15));
  
  add(tSrc);
  add(tDst);
  add(new Label());
  add(p);

  bCpy.addActionListener(this);
  bMov.addActionListener(this);
  bSel.addActionListener(this);
  bClr.addActionListener(this);

  tSrc.addKeyListener(this);

  addWindowListener(new TextDemoAdapter());
 }

 public Insets getInsets()
 {
  return new Insets(40,15,15,15);
 }

 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==bCpy)
  {
   tDst.setText(tSrc.getText());
  }
  else
  if(ae.getSource()==bMov)
  {
   tDst.setText(tSrc.getText());
   tSrc.setText("");
   bCpy.setEnabled(false);
   bMov.setEnabled(false);
   bSel.setEnabled(false);   
  }
  else
  if(ae.getSource()==bSel)
  {
   tDst.setText(tSrc.getSelectedText());
  }
  else
  if(ae.getSource()==bClr)
  {
   bCpy.setEnabled(false);
   bMov.setEnabled(false);
   bSel.setEnabled(false);
   tSrc.setText("");
   tDst.setText("");
  }
 }

 public void keyTyped(KeyEvent ke){}
 public void keyPressed(KeyEvent ke){}

 public void keyReleased(KeyEvent ke)
 {
  if(tSrc.getText().length()==0)
  {
   bCpy.setEnabled(false);
   bMov.setEnabled(false);
   bSel.setEnabled(false);
  }
  else
  {
   bCpy.setEnabled(true);
   bMov.setEnabled(true);
   if(tSrc.getSelectedText().length()==0)
    bSel.setEnabled(false);
   else
    bSel.setEnabled(true);
  }
 }
}

class TextDemoAdapter extends WindowAdapter
{
 public void windowClosing(WindowEvent we)
 {
  System.exit(0);
 }
}

class TextDemoFrm
{
 public static void main(String arg[])
 {
  TextDemoFrame tdf=new TextDemoFrame();
  tdf.setVisible(true);
 }
}