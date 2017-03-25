import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.Graphics.*;
import java.io.*;
import javax.imageio.*;

class PaintFrame extends Frame implements ActionListener,ItemListener,MouseListener,MouseMotionListener
{
 CheckboxMenuItem sLin,sElp,sRec,sFrh;
 MenuItem cBlk,cBlu,cGrn,cYlo,cRed;
 MenuItem mNew,mOpn,mSav,mSas;
 MenuItem mExit;
 
 Color drawColor=Color.black;
 String shape="";

 int ox,oy,px,py,wd,ht;

 BufferedImage bImg;
 Image img;
 Graphics2D g2d;

 String fname="";

 PaintFrame()
 {
  super("Paintbrush - Untitled");
  
  setSize(700,600);
  setLocation(200,100);

  sLin=new CheckboxMenuItem("Line");
  sRec=new CheckboxMenuItem("Rectangle");
  sElp=new CheckboxMenuItem("Ellipse");
  sFrh=new CheckboxMenuItem("Free Hand");

  mExit=new MenuItem("Exit");

  mNew=new MenuItem("New");
  mOpn=new MenuItem("Open");
  mSav=new MenuItem("Save");
  mSas=new MenuItem("Save As");
 
  cBlk=new MenuItem("Black");
  cBlk.setEnabled(false);

  cBlu=new MenuItem("Blue");
  cRed=new MenuItem("Red");
  cGrn=new MenuItem("Green");
  cYlo=new MenuItem("Yellow");

  Menu mShape,mColor,mFile;
  mFile=new Menu("File"); 
  mShape=new Menu("Shape");
  mColor=new Menu("Color");

  mShape.add(sLin);
  mShape.add(sRec);
  mShape.add(sElp);
  mShape.add(sFrh);

  mColor.add(cBlk);
  mColor.add(cRed);
  mColor.add(cBlu);
  mColor.add(cGrn);
  mColor.add(cYlo);
  
  mFile.add(mNew);
  mFile.add(mOpn);
  mFile.add(mSav);
  mFile.add(mSas);
  mFile.addSeparator();
  mFile.add(mExit);

  MenuBar mb=new MenuBar();
  mb.add(mFile);
  mb.add(mShape);
  mb.add(mColor);
  
  setMenuBar(mb);

  bImg=new BufferedImage(1500,1500,BufferedImage.TYPE_INT_RGB);
  g2d=bImg.createGraphics();
  g2d.setColor(Color.white);
  g2d.fillRect(0,0,1500,1500);

  sLin.addItemListener(this);
  sRec.addItemListener(this);
  sFrh.addItemListener(this);
  sElp.addItemListener(this);

  cBlk.addActionListener(this);
  cBlu.addActionListener(this);
  cRed.addActionListener(this);
  cGrn.addActionListener(this);
  cYlo.addActionListener(this);

  mNew.addActionListener(this);
  mOpn.addActionListener(this);
  mSav.addActionListener(this);
  mSas.addActionListener(this);

  mExit.addActionListener(this);

  addMouseListener(this);
  addMouseMotionListener(this);
  addWindowListener(new PaintAdapter(this));
 }

 public void paint(Graphics g)
 {
  if(img!=null)
   g.drawImage(img,0,0,this);
 }

 void saveAs()
 {
  FileDialog fd=new FileDialog(this,"Save Image As",FileDialog.SAVE);
  fd.setVisible(true);

  String dn,fn;
  dn=fd.getDirectory();
  fn=fd.getFile();

  if(dn==null)
   return;
  
  fname=dn+fn;
  setTitle("Paintbrush - "+fname);
  try
  {  
   ImageIO.write(bImg,"jpg",new File(fname));
  }
  catch(IOException e){}
 }

 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==mExit)
  {
   dispose(); 
   LoginFrame lf=new LoginFrame();
   lf.setVisible(true);
  }

  if(ae.getSource()==mNew)
  {
   fname="";
   setTitle("Paintbrush - Untitled");
   g2d.setColor(Color.white);
   g2d.fillRect(0,0,1000,1000);
   img=(Image)bImg;
   repaint();
  }
  else
  if(ae.getSource()==mOpn)
  {
   FileDialog fd=new FileDialog(this,"Select Image to Open",FileDialog.LOAD);
   fd.setVisible(true);
 
   String dn,fn;
   dn=fd.getDirectory();
   fn=fd.getFile();
  
   if(dn==null)
    return;
  
   fname=dn+fn;
   setTitle("Paintbrush - "+fname);

   img=Toolkit.getDefaultToolkit().getImage(fname);
   MediaTracker mt=new MediaTracker(this);
   mt.addImage(img,0);
   try
   {
    mt.waitForID(0);
   }
   catch(InterruptedException e){}
   
   g2d.setColor(Color.white);
   g2d.fillRect(0,0,1000,1000);
   g2d.drawImage(img,0,0,img.getWidth(this),img.getHeight(this),this);
   repaint();
  }
  else
  if(ae.getSource()==mSav)
  {
   if(fname=="")
    saveAs();
   else
   {
    File f=new File(fname);
    f.delete();
    try
    {
     ImageIO.write(bImg,"jpg",new File(fname));
    }
    catch(IOException e){}
   }   
  }
  else
  if(ae.getSource()==mSas)
  {
   saveAs();
  }
  else
  {
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

 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseClicked(MouseEvent me){}
 public void mouseMoved(MouseEvent me){}

 public void mousePressed(MouseEvent me)
 {
  ox=px=me.getX();
  oy=py=me.getY();
  setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
  wd=ht=0;
 }

 public void mouseReleased(MouseEvent me)
 {
  Graphics g=getGraphics();
  g.setColor(drawColor);
  g.setPaintMode();
  g2d.setColor(drawColor);
  
  switch(shape)
  {
   case "line"      : g.drawLine(ox,oy,px,py);
                      g2d.drawLine(ox,oy,px,py);
                      break;
   case "rectangle" : g.drawRect(px,py,wd,ht);
                      g2d.drawRect(px,py,wd,ht);
                      break;
   case "ellipse"   : g.drawOval(px,py,wd,ht);
                      g2d.drawOval(px,py,wd,ht);
                      break;
  }
  img=(Image)bImg;

  setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  wd=ht=0;
 }

 public void mouseDragged(MouseEvent me)
 {
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
   case "rectangle" : if(wd>0||ht>0)      
                       g.drawRect(px,py,wd,ht);
		      break;
   case "ellipse"   : if(wd>0||ht>0)   
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
                      g2d.setColor(drawColor);
                      g2d.drawLine(ox,oy,px,py);
                      ox=px;
                      oy=py;
  }
  img=(Image)bImg; 

 }

}

class PaintAdapter extends WindowAdapter
{
 PaintFrame pf;
 
 PaintAdapter(PaintFrame pf)
 {
  this.pf=pf;
 }

 public void windowClosing(WindowEvent we)
 {
  pf.dispose();
  LoginFrame lf=new LoginFrame();
  lf.setVisible(true);
 }
}

