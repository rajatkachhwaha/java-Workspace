package serverclient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
    int number,dble;
    Socket cs=new Socket("127.0.0.1",1342);
    Scanner sc= new Scanner(System.in);
    Scanner sc1=new Scanner(cs.getInputStream());
    System.out.println("please enter the value");
    number=sc.nextInt();
    
    
    PrintStream p= new PrintStream(cs.getOutputStream());
    p.println(number);
    
    dble=sc1.nextInt();
    System.out.println("the double is"+dble);
    
	}

}
