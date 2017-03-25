class Sample
{
 private int a=1;
 private static int x=2;

 int b=10;
 static int y=20;
}

class Main
{
 public static void main(String arg[])
 {
  //Sample.a=11;		//invalid.. (1) non-static members cannot be accessed using classname
				//	    (2) private members are not accessible outside the class

  //Sample.x=22;		//invalid.. (2)

  //Sample.b=101;		//invalid.. (1)

  Sample.y=202;			//ok

  Sample s=new Sample();

  //System.out.println(s.a);	//invalid.. (2)

  //System.out.println(s.x);	//invalid.. (2)     

  System.out.println(s.b);	//ok.. prints 10

  System.out.println(s.y);	//ok.. prints 202

 }

}