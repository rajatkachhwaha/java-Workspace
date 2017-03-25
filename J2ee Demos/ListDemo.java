import java.awt.*;
import java.awt.event.*;

class ListFrame extends Frame implements FocusListener,ActionListener
{
 List lst;
 TextField txt;
 Button bIns,bDel,bLoc,bPrn,bClr;

 ListFrame()
 {
  super("List Demo");
  setSize(500,350);
  setLocation(200,100);
  
  lst=new List();
  lst.setMultipleMode(true);
  lst.setFont(new Font("lucida console",Font.PLAIN,18));
  lst.setBackground(new Color(200,200,255));

  txt=new TextField();
  txt.setFont(new Font("lucida console",Font.PLAIN,25));
  txt.setBackground(new Color(200,255,200));
  
  bIns=new Button("Insert Item into List");
  bIns.setFont(new Font("lucida console",Font.PLAIN,18));
  bIns.setBackground(new Color(255,160,160));
  bIns.setForeground(Color.white);

  bLoc=new Button("Search Item in the List");
  bLoc.setFont(new Font("lucida console",Font.PLAIN,18));
  bLoc.setBackground(new Color(255,160,160));
  bLoc.setForeground(Color.white);

  bDel=new Button("Delete Selected Items");
  bDel.setFont(new Font("lucida console",Font.PLAIN,18));
  bDel.setBackground(new Color(255,160,160));
  bDel.setForeground(Color.white);
 
  bClr=new Button("Clear Selection(s)");
  bClr.setFont(new Font("lucida console",Font.PLAIN,18));
  bClr.setBackground(new Color(255,160,160));
  bClr.setForeground(Color.white);

  bPrn=new Button("Print Selected Items");
  bPrn.setFont(new Font("lucida console",Font.PLAIN,18));
  bPrn.setBackground(new Color(255,160,160));
  bPrn.setForeground(Color.white);

  Panel p=new Panel();
  p.setLayout(new GridLayout(7,1,5,5));
  p.add(txt);
  p.add(new Label());
  p.add(bIns);
  p.add(bLoc);
  p.add(bDel);
  p.add(bClr);
  p.add(bPrn);
  
  setLayout(new GridLayout(1,2,5,5));
  add(lst);
  add(p); 

  bIns.addActionListener(this);
  bLoc.addActionListener(this);
  bDel.addActionListener(this);
  bPrn.addActionListener(this);
  bClr.addActionListener(this);
  
  txt.addFocusListener(this);
  addWindowListener(new ListAdapter());    
 }

 public Insets getInsets()
 {
  return new Insets(40,20,20,20);
 }

 public void focusLost(FocusEvent fe){}

 public void focusGained(FocusEvent fe)
 {
  txt.select(0,txt.getText().length());
 }

 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==bIns)
  {
   lst.add(txt.getText());
  }
  else
  if(ae.getSource()==bLoc)
  {
   String s=txt.getText();
   for(int i=0;i<lst.getItemCount();i++)
   {
    lst.deselect(i);
    if(lst.getItem(i).equalsIgnoreCase(s))
     lst.select(i);   
   }
  }
  else
  if(ae.getSource()==bDel)
  {
   int arr[]=lst.getSelectedIndexes();
   for(int i=arr.length-1;i>=0;i--)
   {
    lst.remove(arr[i]);   
   }
  }
  else
  if(ae.getSource()==bClr)
  {
   int arr[]=lst.getSelectedIndexes();
   for(int i=0;i<arr.length;i++)
   {
    lst.deselect(arr[i]);   
   }
  }
  else
  if(ae.getSource()==bPrn)
  {
   String str[]=lst.getSelectedItems();
   for(String s : str)
    System.out.println(s);

  }
 }
}

class ListAdapter extends WindowAdapter
{
 public void windowClosing(WindowEvent we)
 {
  System.exit(0);
 }
}
 
class ListDemo
{
 public static void main(String arg[])
 {
  ListFrame lf=new ListFrame();
  lf.setVisible(true);
 }
}