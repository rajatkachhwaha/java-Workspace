package serverclient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     int temp,dbl;
     ServerSocket ss= new ServerSocket(1342);
     Socket s=ss.accept();
     Scanner sc=new Scanner(s.getInputStream());
      temp=sc.nextInt();
      dbl=2*temp;
     PrintStream p= new PrintStream(s.getOutputStream());
     p.println(dbl);
     
	}

}
