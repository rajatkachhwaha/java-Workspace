package cookiepkg;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class cookiecls
 */
@WebServlet("/cookiecls")
public class cookiecls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookiecls() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			 PrintWriter pw=response.getWriter();
			 String str="<html><head><title>cookie demo</title></head>"+
			            "<body bgcolor=blue><br><br><br>";
			 
			 Cookie cArr[]=request.getCookies();
			 if(cArr==null)
			 {
			  str=str+"<form action=setcookie><font color=white><h1>Welcome to World of Cookies</h1></font>"+
			          "<br><br><br><font color=yellow><h3>Enter your Name</h3></font>"+
					  "<input type=\"text\" name=\"username\"/><br>"+
			          "&nbsp;<input type=\"submit\" value=\"Submit\"/>"+
					  "</form>";
			 }
			 else
			 {
			  str=str+"<font color=white><h1>Hi ! Welcome Back to Cookie World !</h1></font>"+
			          "<br><br><br><font color=yellow><h3><table border=2>";
			  int n=0;			 
			  for(Cookie c : cArr)
			  {
			   String s=c.getName();
			   str=str+"<tr><td>"+s+"</td>";
			   if(s.equals("username"))
			   {
				str=str+"<td>"+c.getValue();   
			   }
			   else
			   if(s.equals("visitcnt"))
			   {
				n=Integer.parseInt(c.getValue());
				str=str+"<td>"+n;
			   }
			   str=str+"</td></tr>";
			  }
			  str=str+"</table></h3></font>";
			  str=str+"<br><br><br><font color=white><h2>This is your Visit No. "+n+"</h2></font>";
		      n++;
		      Cookie ck=new Cookie("visitcnt",String.valueOf(n));
		      ck.setMaxAge(60*60);
			  response.addCookie(ck);
			 }
			 str=str+"</body></html>";
			 pw.println(str);
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

}
