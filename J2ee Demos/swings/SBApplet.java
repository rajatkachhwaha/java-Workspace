import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="SBApplet" height=300 width=500>
</applet>
*/

public class SBApplet extends JApplet implements AdjustmentListener
{ 
 JScrollBar sbr,sbg,sbb;
 JPanel colorPanel; 
 
 public void init()
 {
  
  MainPanel mp=new MainPanel(20,20,20,20);
  add(mp);
  
  sbr=new JScrollBar(JScrollBar.VERTICAL,255,10,0,265);
  sbg=new JScrollBar(JScrollBar.VERTICAL,255,10,0,265);
  sbb=new JScrollBar(JScrollBar.VERTICAL,255,10,0,265);
    
  colorPanel=new JPanel();
  colorPanel.setBackground(Color.black);

  mp.setLayout(new GridLayout(1,2,10,5));
  
  MainPanel p=new MainPanel(0,40,0,40);
  p.setBackground(new Color(100,110,120));
  p.setLayout(new GridLayout(1,3,25,5));
  p.add(sbr);
  p.add(sbg);
  p.add(sbb);

  mp.add(p);
  mp.add(colorPanel);
   
  sbr.addAdjustmentListener(this);
  sbg.addAdjustmentListener(this);
  sbb.addAdjustmentListener(this);
 }

 public void adjustmentValueChanged(AdjustmentEvent ae)
 {
  int r=255-sbr.getValue();
  int g=255-sbg.getValue();
  int b=255-sbb.getValue();

  colorPanel.setBackground(new Color(r,g,b));
  showStatus("Red : "+r+"    Green: "+g+"    Blue :"+b); 
 }
}

class MainPanel extends JPanel 
{
 int top,left,bottom,right;

 MainPanel (int top,int left,int bottom,int right)
 {
  this.top=top;
  this.left=left;
  this.bottom=bottom;
  this.right=right;
 }

 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  setBackground(new Color(100,110,120));
 }

 public Insets getInsets()
 {
  return new Insets(top,left,bottom,right);
 }

} 