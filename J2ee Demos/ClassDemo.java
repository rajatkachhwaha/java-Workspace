class Complex
{
 private float real,imag;

 void set(double real,double imag)
 {
  this.real=(float)real;
  this.imag=(float)imag;
 }

 void print()
 {
  System.out.print("\n("+real+","+imag+"i)");
 }
}

class ClassDemo
{
 public static void main(String arg[])
 {
  Complex c=new Complex();

  c.set(1.5,2.9);

  c.print();  
 }
}