package dmatics;

public class Complex
{
 private float real,imag;

 public Complex(){}

 public Complex(double real,double imag)
 {
  this.real=(float)real;
  this.imag=(float)imag;
 }

 public Complex(Complex c)
 {
  real=c.real;
  imag=c.imag;
 }

 public void get()
 {
  java.util.Scanner sc=new java.util.Scanner(System.in);
  System.out.print("Enter Real part : ");
  real=sc.nextFloat();
  System.out.print("Enter Imag part : ");
  imag=sc.nextFloat();  
 }

 public void print()
 {
  System.out.printf("\n(%.2f,%.2fi)\n",real,imag);
 }

 public String toString()
 {
  return "("+real+","+imag+"i)";
 }
}