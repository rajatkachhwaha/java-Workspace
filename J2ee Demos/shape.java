abstract class Shape
{
 private int drawColor,fillColor;
 protected int left,top,right,bottom;
 
 Shape(int left,int top,int right,int bottom)
 {
  this.left=left;
  this.top=top;
  this.right=right;
  this.bottom=bottom;
 }
 
 void setBounds(int left,int top,int right,int bottom)
 {
  this.left=left;
  this.top=top;
  this.right=right;
  this.bottom=bottom;
 }
 
 void setDrawColor(int drawColor)
 {
  this.drawColor=drawColor;
 }

 void setFillColor(int fillColor)
 {
  this.fillColor=fillColor;
 }

 abstract void create();
 abstract void show();
}

class Rectangle extends Shape
{
 private int width,height;

 Rectangle()
 {
  super(0,0,0,0);
 }

 Rectangle(int x,int y,int width,int height)
 {
  super(x,y,x+width,y+height);
  this.width=width;
  this.height=height;
 }

 void create()
 {
  System.out.println("\ncreating Rectangle...");
 }

 void show()
 {
  System.out.println("\nshowing Rectangle...");
 }
 
}

class Circle extends Shape
{
 private int cx,cy,radius;;

 Circle()
 {
  super(0,0,0,0);
 }

 Circle(int cx,int cy,int radius)
 {
  super(cx-radius,cy-radius,cx+radius,cy+radius);
  this.cx=cx;
  this.cy=cy;
  this.radius=radius;
 }

 void create()
 {
  System.out.println("\ncreating Circle...");
 }

 void show()
 {
  System.out.println("\nshowing Circle...");
 }
}

class Main
{
 public static void main(String arg[])
 {
  java.util.Scanner sc=new java.util.Scanner(System.in);
 
  String shp;
  System.out.print("\nEnter Shape to draw [(R)ectangle/(C)ircle] : ");
  shp=sc.next(); 

  Shape s=null;
  switch(shp)
  {
   case "R" : 
   case "r" : s=new Rectangle();
              break;
   case "C" : 
   case "c" : s=new Circle();
              break;
   default  : System.err.println("\ninvalid shape - "+shp+"\n");
              System.exit(1);
  }

  s.setBounds(100,100,200,300);
  s.setDrawColor(4);
  s.setFillColor(10);
  s.create();
  s.show();
 }
}

