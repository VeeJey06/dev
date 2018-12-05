package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

/**
 * Servlet implementation class Glass
 */
public class Glass extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con =null;
		Statement st =null;
		ResultSet rs = null;
		
		PrintWriter out = resp.getWriter();
		
		try 
		{
			Driver ref = new Driver();
			DriverManager.registerDriver(ref);
			
			String dburl = "jdbc:mysql://localhost:3306/veejey?user=root&password=root";
			con =DriverManager.getConnection(dburl);
			
			String query ="Select * from student";
			   st = con.createStatement();
			   rs = st.executeQuery(query);
			   
			   
			   
			   out.println( "<html>"
			   +"<body>"+"<div >"+"<h1>"+"<table border = 10px cellpadding =5px align = 'center' width = 30% bgcolor = orange>"
			   +"<tr><th>regno</th><th>1stname</th><th>laststname</th>"
			   + "<th>percent</th></tr>");
			   
			   while(rs.next())
			   {
				   int regdnum = rs.getInt("Id");
				   String fname = rs.getNString("firstname");
				   String lname = rs.getNString("lastname");
				   int percent = rs.getInt("aggregate");
				   
				   out.println( "<tr><th>"+regdnum+"</th><th>"+fname+"</th><th>"+lname+"</th>"
						   + "<th>"+percent+"</th></tr>");
			   }
			   out.print("</table>"+"</h>"+"</div>"+"</body"+"</html>");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			
			try
			{
				if(con!=null) {
			
				con.close();
			}
			if(st!=null) {
				st.close();
		}
			if(rs!=null) {
				rs.close();
			}
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

}
