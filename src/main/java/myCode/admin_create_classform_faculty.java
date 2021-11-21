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
 * Servlet implementation class admin_create_classform_faculty
 */
@WebServlet("/admin_create_classform_faculty")
public class admin_create_classform_faculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_create_classform_faculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String sql="Select name from facultydetails";
		ArrayList<ArrayList<String> > faculty_names= new ArrayList<ArrayList<String> >();
		try {
			Connection con = JDBC_connection.initializedatabase();
			
			PreparedStatement st_next = con.prepareStatement(sql);
    		ResultSet rs_next = st_next.executeQuery();
    		while(rs_next.next()) {
        		faculty_names.add(new ArrayList<String>(Arrays.asList(rs_next.getString(1))));
    		}
    		String sql_one="Select * from class_room";
            PreparedStatement st_one = con.prepareStatement(sql_one);
            ResultSet rs=st_one.executeQuery();
            ArrayList<ArrayList<String> > classes= new ArrayList<ArrayList<String> >();
            while(rs.next()) {
            	classes.add(new ArrayList<String>(Arrays.asList(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6))));
            }
            request.setAttribute("classes", classes);
    		st_next.close();
    		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(faculty_names);
		request.setAttribute("fac_name", faculty_names);
		request.getRequestDispatcher("/admin_create_classes.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
