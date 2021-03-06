package banksystem;

import java.io.*;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankSystem
 */
@WebServlet("/BankSystem")
public class BankSystem extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	ResultSet rs;
	PreparedStatement pst1,pst2;
    /**
     * @see HttpServlet#HttpServlet()
     */

	public void init()
	{
    	try
        {
      	Class.forName("com.mysql.jdbc.Driver");
      	Connection cn;
      	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","rajat_16");
      	
      	pst1=cn.prepareStatement("select * from cust where actno=?");
      	pst2=cn.prepareStatement("select * from trans where actno=?");
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
	
	public BankSystem() 
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
		  int n;
		  try
		  {
		   n=Integer.parseInt(request.getParameter("act"));
		  }
		  catch(NumberFormatException e)
		  {
		   n=0;
		  }

		  String s="<html><head>";
		  pst1.setInt(1,n);
		  rs=pst1.executeQuery();
		  if(rs.next())
		  {
		   s=s+"<title>Customer Details</title></head>"+
			   "<body bgcolor=yellow><br><br><center><font color=blue><h1>Royal Bank of Jodhpur</h1></font>"+
			   "<br><br><br><font color=red><h2>"+
			   "<table>"+
			   " <tr>"+
			   "  <td>Acc. No. </td>"+
			   "  <td>"+n+"</td>"+
			   " </tr>"+
			   " <tr>"+
			   "  <td>Name </td>"+
			   "  <td>"+rs.getString("name")+"</td>"+
			   " </tr>"+
			   " <tr>"+
			   "  <td>Balance</td>"+
			   "  <td>"+rs.getInt("balance")+"</td>"+
			   " </tr>"+
			   "</table></h2></font><br><br><br>";
			   
			   
			   pst2.setInt(1,n);
			   rs=pst2.executeQuery();
			   s=s+"<table border=1>"+
			       "<tr>"+
				   "<th>Trans-Id</th>"+
			       "<th>Date of Trans</th>"+
				   "<th>Amount</th>"+
			       "<th>Type</th>"+
				   "<th>Status</th>"+
			       "</tr>";
			   while(rs.next())
			   {
			    s=s+"<tr>"+
			         "<td>"+rs.getInt("transid")+"</td>";

			         Date dt=rs.getDate("dot");
			         int d,m,y;
			         d=dt.getDate();
			         m=dt.getMonth()+1;
			         
			         y=dt.getYear()+1900;
			         String str=String.format("%02d/%02d/%d",d,m,y);
			         
				     s=s+"<td>"+str+"</td>"+
			         "<td>"+rs.getInt("amt")+"</td>"+
					 "<td>"+rs.getString("ttype")+"</td>"+
				     "<td>"+rs.getString("status")+
				     "</td></tr>";
			   }
			   s=s+"</table>";
		  }
		  else
		  {  
		   s=s+"<title>Invalid Customer</title></head>"+
					   "<body bgcolor=yellow><br><br><center><font color=blue><h1>Royal Bank of Jodhpur</h1></font>"+
					   "<br><br><br><font color=red><h2>"+
					   "Invalid Account Number"+
					   "</h2></font>";
		  }
		  
		  s=s+"</center></body></html>";
		  pw.println(s);
		 }
		 catch(SQLException e)
		 {
		  System.err.println(e);	 
		 }
	}
		 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

}
