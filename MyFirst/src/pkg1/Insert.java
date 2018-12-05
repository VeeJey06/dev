package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;

public class Insert extends HttpServlet {
	

	protected void doget(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con =null;
		PreparedStatement pst =null;
		
		
		PrintWriter out = resp.getWriter();
		
		try 
		{
			Driver ref = new Driver();
			DriverManager.registerDriver(ref);
			
			String dburl = "jdbc:mysql://localhost:3306/veejey?user=root&password=root";
			con =DriverManager.getConnection(dburl);
			
			String fname =req.getParameter("firstname");
			String lname =req.getParameter("lastname");
			String email =req.getParameter("email");
			String password =req.getParameter("password");
			//String[] gender = req.getParameterValues("gender");
			String mobile = req.getParameter("mobile");
			String DOB = req.getParameter("DOB");
		
			//String query = "insert into signup values("+fname+"," +lname+","+ mobile+","+email+","+password+")";
			String query = "delete from student where ID in 25";
			
		   /*pst = con.prepareStatement(query);
		   pst.setString(1, "fstname");
		   pst.setString(2, "lstname");
		   pst.setString(3, "mob");
		   pst.setString(4, "r");
		   pst.setString(5, "rr");
		   pst.setString(6, "ee");
		   pst.setString(7, "e");*/
		   
			   int rs = pst.executeUpdate(query);
			   
			   String Res="";
			   if(rs==1)
			   {
				   Res="Data saved to Database";
			   }
			   else
			   {
				   Res="Duplicate data/unknown error";
			   }
			    out.println( "<html>"
			   +"<body>"+"<div>"+"<h1>"+"jbjbjjj"+"</h>"+"</div>"+"</body"+"</html>");
			   
			    
			   
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			
			try
			{
				if(con!=null) {
			
				con.close();
			}
			if(pst!=null) {
				pst.close();
		}
			/*if(rs!=null) {
				rs.close();
			}*/
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
