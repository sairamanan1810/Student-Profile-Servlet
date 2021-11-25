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
 * Servlet implementation class list_students_ofA_faculty
 */
@WebServlet("/list_students_ofA_faculty")
public class list_students_ofA_faculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public list_students_ofA_faculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		Connection con=JDBC_connection.initializedatabase();
		HttpSession session=request.getSession();
		String name=String.valueOf(session.getAttribute("id"));
		String sql="Select course,section,year_of_joining from class_room where mentor1=? or mentor2=? order by course,section";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, name);
		st.setString(2, name);
		ResultSet rs=st.executeQuery();
		ArrayList<ArrayList<String> > student_list= new ArrayList<ArrayList<String> >();
		while(rs.next()) {
		String sql_next="Select name,roll_no,course,section,joining_year from studentdetails where course=? and section=? and joining_year=?";
		PreparedStatement st_next=con.prepareStatement(sql_next);
		st_next.setString(1, rs.getString(1).toLowerCase());
		st_next.setString(2, rs.getString(2));
		st_next.setString(3, rs.getString(3));
		ResultSet rs_next=st_next.executeQuery();
		while(rs_next.next()) {
			student_list.add(new ArrayList<String>(Arrays.asList(rs_next.getString(1),rs_next.getString(2),rs_next.getString(3).toUpperCase(),rs_next.getString(4),String.valueOf(rs_next.getString(5)))));
		}
		}
		request.setAttribute("student_list", student_list);
		request.getRequestDispatcher("/student_list.jsp").forward(request,response);
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
