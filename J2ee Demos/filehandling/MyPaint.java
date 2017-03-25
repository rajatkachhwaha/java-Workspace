import java.awt.*;
import java.awt.event.*;

class PaintFrame extends Frame implements ActionListener,ItemListener,MouseListener,MouseMotionListener
{
 CheckboxMenuItem sLin,sRec,sElp,sFrh;
 //MenuItem mExit;
 MenuItem cBlk,cRed,cGrn,cYlo,cBlu;
 MenuItem mNew,mOpen,mSas,mExit;
 int ox,oy,px,py,wd,ht;

 String shape="";
 Color drawColor=Color.black;

 PaintFrame()
 {
  super("My Paint");
  setSize(700,600);
  setLocation(250,50);

  Menu mShape,mColor,mFile;   

  mShape=new Menu("Shape");
   sLin=new CheckboxMenuItem("Line");
   sRec=new CheckboxMenuItem("Rectangle");
   sElp=new CheckboxMenuItem("Circle");
   sFrh=new CheckboxMenuItem("Free Hand");
   //mExit=new MenuItem("Exit");

  mShape.add(sLin);
  mShape.add(sRec);
  mShape.add(sElp);
  mShape.add(sFrh);
  mShape.addSeparator();
  mShape.add(mExit);
 

 
 mColor=new Menu("Color");
  cBlk=new MenuItem("Black");
  cBlk.setEnabled(false);

  cRed=new MenuItem("Red");
  cGrn=new MenuItem("Green");
  cYlo=new MenuItem("Yellow");
  cBlu=new MenuItem("Blue");
 
 mColor.add(cBlk);
 mColor.add(cRed);
 mColor.add(cGrn);
 mColor.add(cYlo);
 mColor.add(cBlu);

 mFile=new Menu("File");
  mNew=new CheckboxMenuItem("New");
  mOpen=new CheckboxMenuItem("Open");
  mSas=new CheckboxMenuItem("Save As");
  mExit=new CheckboxMenuItem("Exit");
 
 mFile.add(mNew);
 mFile.add(mOpen);
 mFile.add(mSas);
 mFile.add(mExit);

  MenuBar mb=new MenuBar();
  mb.add(mShape);
  mb.add(mColor);
  setMenuBar(mb);
  sLin.addItemListener(this);
  sRec.addItemListener(this);
  sElp.addItemListener(this);
  sFrh.addItemListener(this);

  cBlk.addActionListener(this);
  cBlu.addActionListener(this);
  cRed.addActionListener(this);
  cGrn.addActionListener(this);
  cYlo.addActionListener(this);

  mExit.addActionListener(this); 
  addWindowListener(new MyWndAdapter(this));  
  addMouseListener(this);
  addMouseMotionListener(this);
 }

 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseClicked(MouseEvent me){}
 public void mouseMoved(MouseEvent me) {}

 public void mouseReleased(MouseEvent me)
 { 
  Graphics g=getGraphics();
  g.setColor(drawColor);
  g.setPaintMode();

  switch(shape)
  {
   case "line"      : g.drawLine(ox,oy,px,py);
                      break;
   case "rectangle" : if(wd!=0||ht!=0)
                       g.drawRect(px,py,wd,ht);
                      break;
   case "ellipse"   : if(wd!=0||ht!=0)
                       g.drawOval(px,py,wd,ht);
                      break;
  }
  setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
 }

 public void mousePressed(MouseEvent me)
 {
  ox=px=me.getX();
  oy=py=me.getY();
  wd=ht=0;

  setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
 }
 
 public void mouseDragged(MouseEvent me)
 {
  if(shape=="")
   return;

  Graphics g=getGraphics();
  g.setColor(drawColor);
  if(shape=="freehand")
   g.setPaintMode();
  else
   g.setXORMode(Color.white);

  switch(shape)
  {
   case "line"      : g.drawLine(ox,oy,px,py);
                      break;
   case "rectangle" : if(wd!=0||ht!=0)
                       g.drawRect(px,py,wd,ht);
                      break;
   case "ellipse"   : if(wd!=0||ht!=0)
                       g.drawOval(px,py,wd,ht);
                      break;
   }

   px=me.getX();
   py=me.getY();
  
  switch(shape)
  {
   case "line"      : g.drawLine(ox,oy,px,py);
                      break;
   case "rectangle" : wd=px-ox;
                      ht=py-oy;
                      if(wd<0)
                       wd=-wd;
                      else
                       px=ox;


                      if(ht<0)
                       ht=-ht;
                      else
                       py=oy;

                      g.drawRect(px,py,wd,ht);  
                      break;
   case "ellipse"   : wd=px-ox;
                      ht=py-oy;
                      if(wd<0)
                       wd=-wd;
                      else
                       px=ox;


                      if(ht<0)
                       ht=-ht;
                      else
                       py=oy;

                      g.drawOval(px,py,wd,ht);  
                      break;
    
   case "freehand"  : g.drawLine(ox,oy,px,py);
                      ox=px;
                      oy=py;
  }
 }
           
 public void itemStateChanged(ItemEvent ie)
 {
  sLin.setState(false);
  sRec.setState(false);
  sElp.setState(false);
  sFrh.setState(false);

  if(ie.getSource()==sLin)
  {
   sLin.setState(true);
   shape="line";
  }
  else
  if(ie.getSource()==sRec)
  {
   sRec.setState(true);
   shape="rectangle";
  }
  else
  if(ie.getSource()==sElp)
  {
   sElp.setState(true);
   shape="ellipse";
  }
  else
  if(ie.getSource()==sFrh)
  {
   sFrh.setState(true);
   shape="freehand";
  }
 }

 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==mExit)
  {
   dispose();
   System.exit(0); 
  }

  cBlk.setEnabled(true);
  cBlu.setEnabled(true);
  cRed.setEnabled(true);
  cGrn.setEnabled(true);
  cYlo.setEnabled(true);

  if(ae.getSource()==cBlk)
  {
   cBlk.setEnabled(false);
   drawColor=Color.black;
  }
  else
  if(ae.getSource()==cBlu)
  {
   cBlu.setEnabled(false);
   drawColor=Color.blue;
  }
  else
  if(ae.getSource()==cRed)
  {
   cRed.setEnabled(false);
   drawColor=Color.red;
  }
  else
  if(ae.getSource()==cGrn)
  {
   cGrn.setEnabled(false);
   drawColor=Color.green;
  }
  else
  if(ae.getSource()==cYlo)
  {
   cYlo.setEnabled(false);
   drawColor=Color.yellow;
  }
 
 }
}

class MyWndAdapter extends WindowAdapter
{
 PaintFrame pf;

 MyWndAdapter(PaintFrame pf)
 {
  this.pf=pf;
 }
 
 public void windowClosing(WindowEvent we)
 {
  pf.dispose();
  System.exit(0);
 }
}

class MyPaint
{
 public static void main(String arg[])
 {
  PaintFrame pf=new PaintFrame();
  pf.setVisible(true);
 }
}