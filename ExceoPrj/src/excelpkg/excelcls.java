package excelpkg;

import java.io.*;

import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class excelcls
 */
@WebServlet("/excelcls")
public class excelcls extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    Connection cn;
    PreparedStatement psc,pst;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public excelcls()
    {
       
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
	 try
	 {
	  Class.forName("com.mysql.jdbc.Driver");
	  
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","rajat_16");
	  
	  psc=cn.prepareStatement("select * from cust where actno=?");
      pst=cn.prepareStatement("select * from trans where actno=?");
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
	 * @see Servlet#destroy()
	 */
	public void destroy()
	{
	 try
	 {
      psc.close();
      pst.close();
      cn.close();
	 }
	 catch(SQLException e)
	 {
	  System.err.println(e);	 
	 }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 PrintWriter pw=response.getWriter();
		 pw.println("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	 PrintWriter pw=response.getWriter();
	 pw.println("post");
	 response.setContentType("application/vnd.ms-excel");
	 try
	 {
	  int acn=Integer.parseInt(request.getParameter("acn"));
	  psc.setInt(1, acn);
	  ResultSet rs=psc.executeQuery();
	  
	  if(rs.next())
	  {
	   pw.println("\n\n");
	   pw.println("\t\tAccount No.\t"+acn);
	   pw.println("\t\tName\t"+rs.getString("name"));
	   pw.println("\n\t\tTrans-ID\tTrans Date\tAmount\tType\tStatus\n");
	   
	   pst.setInt(1, acn);
	   rs=pst.executeQuery();
	   while(rs.next())
	   {
		Date dt=rs.getDate("dot");
		String s=String.format("%02d/%02d/%d",dt.getDate(),dt.getMonth()+1,dt.getYear()+1900);
		pw.println("\t\t"+rs.getInt("transid")+"\t"+s+"\t"+rs.getInt("amt")+"\t"+rs.getString("ttype")+"\t"+rs.getString("status"));		   
	   }
	  }
		  
	 }
	 catch(SQLException e)
	 {
	  e.printStackTrace();
	  System.err.println(e);
	 }
	}

}
