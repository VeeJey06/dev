package serv.retriv;

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
import com.mysql.jdbc.PreparedStatement;

public class Coll extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Connection con =null;
		java.sql.PreparedStatement st =null;
		ResultSet rs = null;
		
		PrintWriter out = resp.getWriter();
		
		String fname = req.getParameter("firstname");
		String lname = req.getParameter("lastname");
		
		try 
		{
			Driver ref = new Driver();
			DriverManager.registerDriver(ref);
			
			String dburl = "jdbc:mysql://localhost:3306/veejey?user=root&password=root";
			con =DriverManager.getConnection(dburl);
			
			String query ="insert into veejey values (25"+fname+","+lname+",26)";
			   st = con.prepareStatement(query);
			  // rs = st.executeQuery(query);
			   
			  /* while(rs.next())
			   {
				   int regdnum = rs.getInt("Id");
				   String fname = rs.getNString("firstname");
				   String lname = rs.getNString("lastname");
				   int percent = rs.getInt("aggregate");
				   
				  
			   }*/
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
