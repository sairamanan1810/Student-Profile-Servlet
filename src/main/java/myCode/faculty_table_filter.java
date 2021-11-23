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
 * Servlet implementation class faculty_table_filter
 */
@WebServlet("/faculty_table_filter")
public class faculty_table_filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public faculty_table_filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
		
		String dept=request.getParameter("dept");
		try {
		Connection con = JDBC_connection.initializedatabase();
		
        ArrayList<ArrayList<String> > faculty_array= new ArrayList<ArrayList<String> >();
	    System.out.println("Hello");
	        		String sql_next="Select * from facultydetails where department like ?";
	        		PreparedStatement st_next = con.prepareStatement(sql_next);
	        		st_next.setString(1, dept);
	        		ResultSet rs_next = st_next.executeQuery();
	        		
	        		while(rs_next.next()) {
	        			String sql_two="Select email from logincredentials where login_id=?";
		        		PreparedStatement st_two = con.prepareStatement(sql_two);
		        		st_two.setString(1,rs_next.getString(2));
		        		ResultSet rs_two = st_two.executeQuery();
		        		rs_two.next();
		        		faculty_array.add(new ArrayList<String>(Arrays.asList(rs_next.getString(3),rs_next.getString(4),rs_two.getString(1))));
	        		}
	        		
	        		request.setAttribute("list_table", faculty_array);
	        		
	        		request.getRequestDispatcher("/admin_page_facultyTable.jsp").forward(request, response);	
	       
	        	
	        
	        
	        // Close all the connections
	        st_next.close();
            con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
