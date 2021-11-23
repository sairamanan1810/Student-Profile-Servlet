package myCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Servlet implementation class student_table_filter
 */
@WebServlet("/student_table_filter")
public class student_table_filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_table_filter() {
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
		String joined_on=request.getParameter("joined_on");
		String dept=request.getParameter("dept");
		if(dept!="%") {
			dept=dept.toLowerCase();
		}
		System.out.println(dept);
		System.out.println(joined_on);
		try {
			Connection con = JDBC_connection.initializedatabase();
			ArrayList<ArrayList<String> > filter_array= new ArrayList<ArrayList<String> >();
		    System.out.println("Hello");
		    String sql_next="Select name,roll_no,course,section,joining_year from studentdetails where joining_year like ? and course like ?";
		    PreparedStatement st_next = con.prepareStatement(sql_next);
		    st_next.setString(1,joined_on);
		    st_next.setString(2,dept);
		    ResultSet rs_next = st_next.executeQuery();
		    while(rs_next.next()) {
		    	filter_array.add(new ArrayList<String>(Arrays.asList(rs_next.getString(1),rs_next.getString(2),rs_next.getString(3),rs_next.getString(4),String.valueOf(rs_next.getString(5)))));
    		}
    		request.setAttribute("list_table", filter_array);
    		
    		request.getRequestDispatcher("/admin_page.jsp").forward(request, response);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
