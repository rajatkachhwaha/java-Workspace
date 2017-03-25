class Shape
{
 protected int left,top,right,bottom;

 Shape(int left,int top,int right,int bottom)
 {
  this.left=left;
  this.top=top;
  this.right=right;
  this.bottom=bottom;
  System.out.println("Shape - argumented");
 }


}

class Circle extends Shape
{
 private int cx,cy,radius;

 Circle()
 {
  super(0,0,0,0);
  System.out.println("Circle - default");
 }

 Circle(int cx,int cy,int radius)
 {
  super(cx-radius,cy-radius,cx+radius,cy+radius);
  this.cx=cx;
  this.cy=cy;
  this.radius=radius;
  System.out.println("Circle - argumented");
 }

}

class Main
{
 public static void main(String arg[])
 {
  new Circle();
  System.out.println();
  new Circle(100,100,25);
 }
}