package Register_or_Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Food_Orders_Register3Servlet")
public class Food_Orders_Register3Servlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		 resp.getWriter().println("<!DOCTYPE html>");
	        resp.getWriter().println("<html>");
	        resp.getWriter().println("<head>");
	        resp.getWriter().println("<title>Background Image</title>");
	        resp.getWriter().println("<style>");
	        resp.getWriter().println("body {");
	        resp.getWriter().println("    background-image:url('https://wallpapercave.com/wp/wp9549965.jpg');");
	        resp.getWriter().println("    background-size: cover;");
	        resp.getWriter().println("}");
	        resp.getWriter().println("form {");
	        resp.getWriter().println("background-color: green");
	        resp.getWriter().println("text-align: center;");
	        resp.getWriter().println("}");
	        resp.getWriter().println("</style>");
	        resp.getWriter().println("</head>");
	        resp.getWriter().println("<body>");
	        resp.getWriter().println("</body>");
	        resp.getWriter().println("</html>");
		String name = req.getParameter("firstname");
	    String email = req.getParameter("email");
	    String password = req.getParameter("password");
	    String address = req.getParameter("address");
	    String contact=req.getParameter("contact");
	    String country=req.getParameter("country");
	    PrintWriter out=resp.getWriter();
	    try
	    {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_order_system", "root", "darshan3009");
			Statement st = conn.createStatement();
			String query="insert into register(name,email,password,address,contact,country)values (?,?,?,?,?,?)";
			PreparedStatement p = conn.prepareStatement(query);
			//PreparedStatement p1 = conn.prepareStatement(query1);
			p.setString(1, name);
			p.setString(2, email);
			p.setString(3, password);
			p.setString(4, address);
			p.setString(5, contact);
			p.setString(6, country);		
			int i = p.executeUpdate();
	    	if(i>0)
	    	{
	    		out.print("Register Data added susscessFully");
	    	}
	    	
	    	else
	    	{
	    		out.print("Register Data Not  added susscessFully");
	    	}
		} catch (ClassNotFoundException | SQLException e) 
	    {
			e.printStackTrace();
		}
	}		
}