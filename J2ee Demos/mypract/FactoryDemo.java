class Complex
{
 private float real,imag;

 private Complex()
 {
  real=imag=1;
 }

 static Complex getObject()	//FACTORY METHOD
 {
  return new Complex();
 }

 void print()
 {
  System.out.println("("+real+","+imag+"i)");
 }

}


class Main
{
 public static void main(String arg[])
 {
  Complex c;

  c=Complex.getObject();

  c.print();  
 }
}