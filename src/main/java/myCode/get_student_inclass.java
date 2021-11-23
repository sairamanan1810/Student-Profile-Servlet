package myCode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class get_student_inclass
 */
@WebServlet("/get_student_inclass")
public class get_student_inclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_student_inclass() {
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
		String year=request.getParameter("year");
		System.out.println(dept+" "+sec+" "+" "+year);
		HttpSession session=request.getSession();
		try {
		Connection con = JDBC_connection.initializedatabase();
		
        // Create a SQL query to insert data into demo table
        // demo table consists of two columns, so two '?' is used
        
        
        
	        	
	        		ArrayList<ArrayList<String> > classes= new ArrayList<ArrayList<String> >();
	        		System.out.println("Hello");
	        		String sql_next="Select name,roll_no,course,section,joining_year from studentdetails where joining_year=? and course=? and section=?";
	        		PreparedStatement st_next = con.prepareStatement(sql_next);
	        		st_next.setString(1,year);
	        		st_next.setString(2,dept.toLowerCase());
	        		st_next.setString(3,sec);
	        		ResultSet rs_next = st_next.executeQuery();
	        		
	        		while(rs_next.next()) {
	        			classes.add(new ArrayList<String>(Arrays.asList(rs_next.getString(1),rs_next.getString(2),rs_next.getString(3),rs_next.getString(4),String.valueOf(rs_next.getString(5)))));
	        		}
	        		request.setAttribute("list_table", classes);
	        		
	        		request.getRequestDispatcher("/class_students_table.jsp").forward(request, response);	
	       
	        	
	        
	        
	        // Close all the connections
	        st_next.close();
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
