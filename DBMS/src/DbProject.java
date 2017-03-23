import java.sql.*;




public class DbProject {

	static final String userName = "root";


	static final String password = "rajat_16";



	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/university";


	public static void main(String[] args)
	{
		Connection conn=null;
		Statement stmt=null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to db");
			conn=DriverManager.getConnection(DB_URL,userName,password);
			System.out.println("Connected");

			stmt=conn.createStatement();

			System.out.println("Fetching records");

			String query1 = "SELECT s.time_slot_id ,c.building,  c.room_number, c.capacity FROM classroom c, section s, time_slot t WHERE c.capacity>30 and t.day = 'M' and t.time_slot_id in ('A','B','C') and s.semester='Fall' and year=2009";
			String query2 = "SELECT a.name FROM student a JOIN takes b ON  a.ID = b.ID WHERE a.dept_name =\"Comp. Sci.\" GROUP BY b.grade ORDER BY avg(b.grade) desc LIMIT 10";
			String query3 =	"SELECT a.name FROM instructor a JOIN teaches b 	ON a.ID = b.ID JOIN takes c ON b.course_id = c.course_id GROUP BY c.ID ORDER BY count(c.ID) LIMIT 10";
			String query4 = "SELECT a.dept_name as department_name , b.course_id as course_ID, c.time_slot_id as session_ID, d.start_hr as start_time,d.end_hr as end_time FROM department a JOIN course b 	ON a.dept_name = b.dept_name JOIN section c	ON b.course_id =c.course_id JOIN time_slot d ON c.time_slot_id = d.time_slot_id WHERE c.semester = \"fall\" AND c.year = 2009";
			String query5 = "SELECT a.name as Name, b.title as Course, c.year as Year, c.semester as Semester, b.credits as Credits,d.grade as Grade FROM student a JOIN course b 	ON a.dept_name = b.dept_name JOIN section c	ON b.course_id = c.course_id JOIN takes d ON c.course_id = d.course_id WHERE a.dept_name =\"Statistics\" GROUP BY a.name ORDER BY c.year desc, c.semester desc LIMIT 50";
			String query6 = "SELECT a.s_ID, a.i_ID FROM advisor a JOIN student b ON a.s_id = b.ID WHERE b.dept_name = 'Comp. Sci.' GROUP BY a.i_ID ORDER BY count(b.ID) LIMIT 10";
			String query7 = "SELECT a.ID as student_ID, a.name as Name, b.course_ID as course_Id FROM student a JOIN takes b ON a.ID = b.ID JOIN prereq c ON b.course_id =c.course_id WHERE c.prereq_id NOT IN ( SELECT b.course_id FROM student a JOIN takes b ON a.ID = b.ID)";
			String query8 = "SELECT b.name as Name, b.salary as Salary FROM department a JOIN instructor b ON a.dept_name = b.dept_name WHERE a.dept_name =  (SELECT a.dept_name FROM department a JOIN instructor b ON a.dept_name = b.dept_name GROUP BY b.salary ORDER BY avg(b.salary) desc LIMIT 1)GROUP BY b.salary ORDER BY b.salary desc LIMIT 2";
			String query9_1 = "SET SQL_SAFE_UPDATES = 0";
			String query9_2 = "create temporary table if not exists table1 as( SELECT a.name as Name, count(b.course_id) as number_Courses FROM instructor a JOIN teaches b ON a.ID = b.ID GROUP BY a.name)";
			String query9_3 = "UPDATE instructor a SET a.salary = (100000 * (select 2 from table1 b where a.name =b.name) / 100)";
			String query9_4 = "SELECT a.ID as instructor_ID, a.salary as Salary FROM instructor a ORDER BY a.salary desc LIMIT 3";
			String query10 = "SELECT d.building FROM student a JOIN takes b	ON a.ID = b.ID JOIN course c ON b.course_id = c.course_id JOIN department d	ON c.dept_name = d.dept_name GROUP  BY d.building ORDER BY count(a.ID) LIMIT 3";  

			ResultSet rs;
			System.out.println("Query 1");
			rs=stmt.executeQuery(query1);

			while(rs.next())
			{
				//Retrieve by column name
				String sid  = rs.getString("s.time_slot_id");
				String building = rs.getString("c.building");
				String room_number = rs.getString("c.building");
				String capacity = rs.getString("c.capacity");

				//Display values
				System.out.print("\t Time Slot ID: " + sid + "\t");
				System.out.print("\t Building: " + building + "\t");
				System.out.print("\t Room: " + room_number + "\t");
				System.out.print("Capacity: " + capacity +"\n");
			}		



			System.out.println("\nQuery 2");

			rs=stmt.executeQuery(query2);

			while(rs.next())
			{
				//Retrieve by column name
				String name  = rs.getString("a.name");

				//Display values
				System.out.print("\t Name: " + name + "\n");
			}	

			System.out.println("Query 3");

			rs=stmt.executeQuery(query3);

			while(rs.next())
			{
				//Retrieve by column name
				String name  = rs.getString("a.name");

				//Display values
				System.out.print("\t Name: " + name + "\n");
			}	


			System.out.println("\nQuery 4");
			rs=stmt.executeQuery(query4);
			while(rs.next())
			{
				//Retrieve by column name
				String a  = rs.getString("department_name");
				String b = rs.getString("course_ID");
				String c = rs.getString("session_ID");
				String d = rs.getString("start_time");
				String e = rs.getString("end_time");
				//Display values
				System.out.print("\t department_name: " + a + "\t");
				System.out.print("\t course_ID: " + b + "\t");
				System.out.print("\t Session_ID: " + c + "\t");
				System.out.print("\t Start_time: " + d + "\t");
				System.out.print("End Time: " + e +"\n");
			}		


			System.out.println("\nQuery 5");

			rs=stmt.executeQuery(query5);
			while(rs.next())
			{
				//Retrieve by column name
				String a  = rs.getString("Name");
				String b = rs.getString("Course");
				String c = rs.getString("Year");
				String d = rs.getString("Semester");
				String e = rs.getString("Credits");
				String f = rs.getString("Grade");
				//Display values
				System.out.print("\t Name: " + a + "\t");
				System.out.print("\t Course: " + b + "\t");
				System.out.print("\t Year: " + c + "\t");
				System.out.print("\t Semester: " + d + "\t");
				System.out.print("\t Credits: " + e + "\t");
				System.out.print("\t Grade: " + f + "\n");
			}		
			
			System.out.println("\nQuery 6");
			rs=stmt.executeQuery(query6);

			while(rs.next())
			{
				//Retrieve by column name
				String a  = rs.getString("a.s_ID");
				String b = rs.getString("a.i_ID");
				
				//Display values
				System.out.print("\t Advisor S ID: " + a + "\t");
				System.out.print("\t Advisor I ID: " + b + "\n");
			}		
			
			System.out.println("\nQuery 7");
			rs=stmt.executeQuery(query7);

			while(rs.next())
			{
				//Retrieve by column name
				String a  = rs.getString("student_ID");
				String b = rs.getString("Name");
				String c = rs.getString("course_Id");
				
				//Display values
				System.out.print("\t student_ID " + a + "\t");
				System.out.print("\t Name: " + b + "\t");
				System.out.print("\t course_Id " + c + "\n");
			}		
			
			System.out.println("\nQuery 8");
			rs=stmt.executeQuery(query8);

			while(rs.next())
			{
				//Retrieve by column name
				String a  = rs.getString("Name");
				String b = rs.getString("Salary");
				
				//Display values
				System.out.print("\t Name: " + a + "\t");
				System.out.print("\t Salary: " + b + "\n");
			}	
			
			System.out.println("\nQuery 9");
			
			
			rs=stmt.executeQuery(query9_1);
			int z =stmt.executeUpdate(query9_2);
			int x=stmt.executeUpdate(query9_3);
			rs=stmt.executeQuery(query9_4);
			while(rs.next())
			{
				//Retrieve by column name
				String a  = rs.getString("instructor_ID");
				String b  = rs.getString("Salary");

				//Display values
				System.out.print("\t instructor_ID: " + a + "\t");
				System.out.print("\t Salary: " + b + "\n");
			}	

			System.out.println("\nQuery 10");
			rs=stmt.executeQuery(query10);

			while(rs.next())
			{
				String a  = rs.getString("d.building");
				System.out.print("\t Building: " + a + "\n");
			}	
			
			rs.close();

		}
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
				if(stmt!=null)
					conn.close();
			}
			catch(SQLException se)
			{
			}// do nothing
			/*  try
		      {
		          if(conn!=null)
		             conn.close();
		       }
		      catch(SQLException se)
		      {
		          se.printStackTrace();
		       }*/

		}


	}
}
