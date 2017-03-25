import java.sql.*;
import java.util.Scanner;


class Type4
{
 public static void main(String arg [])
 {
  Scanner sc=new Scanner(System.in);
  String brn; 
  System.out.print("\nEnter the Branch : ");
  brn=sc.next();

  try
  {
   Class.forName("com.mysql.jdbc.Driver");

   Connection cn;
   cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dmatics","root","rajat_16");

   /*
   Statement st;
   st=cn.createStatement();

   ResultSet rs;
   rs=st.executeQuery("select * from studs where branch='"+brn+"'");
   */
   
   PreparedStatement pst=cn.prepareStatement("select * from studs where branch=?");
   pst.setString(1,brn);
   
   ResultSet rs=pst.executeQuery();   

   while(rs.next())
   {
    int rn,d,m,y,marks;
    String fn,ln;
    rn=rs.getInt(1);
 
    Date dt=rs.getDate("dob");
    d=dt.getDate();
    m=dt.getMonth()+1;
    y=dt.getYear()+1900;
    
    fn=rs.getString("fname");
    ln=rs.getString("lname");
    marks=rs.getInt("marks");
    brn=rs.getString("branch");
    
    System.out.printf("\n%d  %-10s  %-10s  %02d/%02d/%d  %-3s  %03d",rn,fn,ln,d,m,y,brn,marks);
   } 
   pst.close();
   cn.close();
  }
  
  
  catch(ClassNotFoundException e)
  {
   System.err.println("Driver not found.. Aborting..\n"); 
  }  
  catch(SQLException e)
  {
   System.err.println("Sql Error : "+e.getMessage()+"\n");
  }  
  
 } 
}  