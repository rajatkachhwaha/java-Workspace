package myluckynumber;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyLuckyNumber
 */
@WebServlet("/MyLuckyNumber")
public class MyLuckyNumber extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    private static String months[]={
    		                 "January",
    		                 "February",
    		                 "March",
    		                 "April",
    		                 "May",
    		                 "June",
    		                 "July",
    		                 "August",
    		                 "September",
    		                 "October",
    		                 "November",
    		                 "December"
    		                };
    private static String days[]={
                             "Sunday",
                             "Monday",
                             "Tuesday",
                             "Wednesday",
                             "Thursday",
                             "Friday",
                             "Saturday"
                            };
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLuckyNumber()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		
		Date dt=new Date();
		int n=(int)(Math.random()*1000);
		
		String s="<HTML><HEAD><TITLE>MyLuckyNumber</TITLE></HEAD>\n"+
				 "<BODY BGCOLOR=TEAL><CENTER>\n"+
				 "<BR><BR><BR><H1><FONT COLOR=YELLOW>Welcome to My Lucky Number</FONT></H1>"+
				 "<BR><BR><BR><FONT COLOR=WHITE><H3>Today is "+days[dt.getDay()]+", "+
				 months[dt.getMonth()]+" "+dt.getDate()+" "+(dt.getYear()+1900)+
				 "</H3></FONT>"+
				 "<BR><BR><BR><Font COLOR=RED><H3>Your Lucky Number is "+n+"</H3></FONT>"+
				 "</CENTER></BODY></HTML>";
				
		pw.println(s);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
