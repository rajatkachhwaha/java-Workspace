package querybranch;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryBranch
 */
@WebServlet("/QueryBranch")
public class QueryBranch extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	PreparedStatement pst1,pst2;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryBranch()
    {
      try
      {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection cn;
    	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dmatics","root","rajat_16");
    	
    	pst1=cn.prepareStatement("select * from studs where branch=?");
    	pst2=cn.prepareStatement("select * from marks where rollno=?");
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 PrintWriter pw=response.getWriter();
	 
	 try
	 {
	  String brn=request.getParameter("brn");
	  pst1.setString(1,brn);
	  ResultSet rs=pst1.executeQuery();
	 
	  String s="<html><head><title>Query Branch</title></head>"+
			   "<body bgcolor=yellow><br><br><center><font color=blue><h1>DETROIT COLLEGE OF ENGINEERING STUDIES</h1></font>"+
			   "<br><br><br><font color=red><h2>Branch : "+brn+"</h2></font><br><br>"+
			   "<table colspan=4 border=1><font color=blue>"+
			   "<tr>"+
			    "<th>Roll No.</th>"+
			    "<th>Name</th>"+
			    "<th>Sub 1</th>"+
			    "<th>Sub 2</th>"+
			    "<th>Sub 3</th>"+
			    "<th>Total</th>"+
	           "</tr>";
	  while(rs.next())
	  {
		s=s+"<tr>"+
		    "<td>"+rs.getInt("rollno")+"</td>"+
		    "<td>"+rs.getString("fname")+" "+rs.getString("lname")+"</td>";

		pst2.setInt(1,rs.getInt("rollno"));
		ResultSet rm=pst2.executeQuery();
		
		if(rm.next())
		{
			s=s+"<td>"+rm.getInt("sub1")+"</td>"+
		        "<td>"+rm.getInt("sub2")+"</td>"+
				"<td>"+rm.getInt("sub3")+"</td>"+
		        "<td>"+rs.getInt("marks")+"</td>";
		}
		else
		{
			s=s+"<td>0</td>"+
			    "<td>0</td>"+
				"<td>0</td>"+
			    "<td>0</td>";
		}
	  }
	         
	  s=s+"</center></body></html>";
	  
	  pw.println(s);
	 }
	 catch(SQLException e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
