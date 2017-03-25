package loginpage;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	ResultSet rs;
	PreparedStatement pst1;
	
	public void init()
	{
    	try
        {
      	Class.forName("com.mysql.jdbc.Driver");
      	Connection cn;
      	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","rajat_16");
      	
      	pst1=cn.prepareStatement("select * from details where user=?");
      	
        }
        catch(ClassNotFoundException e)
        {
         System.err.println("Driver Not Found..");
         System.exit(1);
        }
        catch(SQLException e)
        {
         System.err.println("SQL failed..");
         System.exit(1);
        }  	
	}
	
	
	public LoginPage()
    {
	 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw=response.getWriter();
		 
		 try
		 {
		  String usern=request.getParameter("usern");
		  String pass=request.getParameter("pass");
		  pst1.setString(1,usern);
		  ResultSet rs=pst1.executeQuery();
		  
		  String login,password;
		  
		//   login=rs.getString("login");
		  if(rs.next())
			  password=rs.getString("password");
		  else 
			  password=null;
		 
		  String s="<html><head><title>Query Branch</title></head>"+
				   "<body bgcolor=yellow><br><br><center><font color=blue><h1>Servlets Practise</h1></font>";
				   
		 if(pass.equals(password))
		 {
		  	 
		s=s+"<br><br><br><font color=red><h2>WELCOME</h2></font>"+
					   "<br><font color=red><h1>"+usern+"</h1><br><br></font>";
					        
		  s=s+"</center></body></html>";
		  
		  pw.println(s);
		  }
		 else
		 {
			 s=s+"<br><br><br><font color=red><h2>WELCOME</h2></font>"+
					   "<br><font color=red><h1>sorry incorrect credentials </h1><br><br></font>";
					        
		  s=s+"</center></body></html>";
		  
		  pw.println(s); 
			 
		  }
		 }
		 catch(SQLException e)
		 {
		  System.err.println(e);
		 }
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
