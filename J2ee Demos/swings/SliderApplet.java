import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

/*
<applet code="SliderApplet" height=300 width=500>
</applet>
*/

public class SliderApplet extends JApplet implements ChangeListener
{ 
 JSlider sbr,sbg,sbb;
 JPanel colorPanel; 
 
 public void init()
 {
  
  MainPanel mp=new MainPanel(20,20,20,20);
  add(mp);
  
  sbr=new JSlider(SwingConstants.VERTICAL,0,255,0);
  sbr.setMajorTickSpacing(50);
  sbr.setMinorTickSpacing(5);
  sbr.setPaintTicks(true);
  sbr.setPaintLabels(true);

  sbg=new JSlider(SwingConstants.VERTICAL,0,255,0);
  sbg.setMajorTickSpacing(50);
  sbg.setMinorTickSpacing(5);
  sbg.setPaintTicks(true);
  sbg.setPaintLabels(true);

  sbb=new JSlider(SwingConstants.VERTICAL,0,255,0);
  sbb.setMajorTickSpacing(50);
  sbb.setMinorTickSpacing(5);
  sbb.setPaintTicks(true);    
  sbb.setPaintLabels(true);

  colorPanel=new JPanel();
  colorPanel.setBackground(Color.black);

  mp.setLayout(new GridLayout(1,2,10,5));
  
  MainPanel p=new MainPanel(0,40,0,40);
  p.setBackground(new Color(100,110,120));
  p.setLayout(new GridLayout(1,3,5,5));
  p.add(sbr);
  p.add(sbg);
  p.add(sbb);


  mp.add(p);
  mp.add(colorPanel);
   
  sbr.addChangeListener(this);
  sbg.addChangeListener(this);
  sbb.addChangeListener(this);
 }

 public void stateChanged(ChangeEvent ae)
 {
  int r=sbr.getValue();
  int g=sbg.getValue();
  int b=sbb.getValue();

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