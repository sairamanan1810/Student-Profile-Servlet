package myCode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class delete_class_room
 */
@WebServlet("/delete_class_room")
public class delete_class_room extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_class_room() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String dept=request.getParameter("dept");
		String sec=request.getParameter("section");
		
		System.out.println(dept+" "+sec+" ");
		HttpSession session=request.getSession();
		try {
		Connection con = JDBC_connection.initializedatabase();
		
        // Create a SQL query to insert data into demo table
        // demo table consists of two columns, so two '?' is used
        
        
        
	        	
	        		
	        		String sql_one="Delete from class_room where course=? and section=?";
	        		PreparedStatement st_one = con.prepareStatement(sql_one);
	        		st_one.setString(1, dept.toUpperCase());
	        		st_one.setString(2, sec);
	                st_one.executeUpdate(); 
	          
	        		
	        		String sql_two="Select * from class_room";
	                PreparedStatement st_two = con.prepareStatement(sql_two);
	                ResultSet rs=st_two.executeQuery();
	                ArrayList<ArrayList<String> > classes= new ArrayList<ArrayList<String> >();
	                while(rs.next()) {
	                	classes.add(new ArrayList<String>(Arrays.asList(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6))));
	                }
	                request.setAttribute("classes", classes);
	        		
	        		request.getRequestDispatcher("/admin_create_classes.jsp").forward(request, response);	
	       
	        	
	        
	        
	        // Close all the connections
	        st_one.close();
	        st_two.close();
            con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
