package myCode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class faculty_details
 */
@WebServlet("/faculty_details")
public class faculty_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public faculty_details() {
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
		HttpSession session=request.getSession();
		doGet(request, response);
		String name=request.getParameter("name");
		String department=request.getParameter("Department");
		String email=request.getParameter("email");
		
		try {
		Connection con = JDBC_connection.initializedatabase();
		String sql_one="Select login_id from logincredentials where email=?";
		PreparedStatement st_one = con.prepareStatement(sql_one);
		st_one.setString(1,email);
		System.out.println(email);
		ResultSet rs_one=st_one.executeQuery();
		String sql_two="Insert Into Facultydetails(login_id,name,Department) Values (?,?,?)";
		PreparedStatement st_two = con.prepareStatement(sql_two);
		while(rs_one.next()) {
			st_two.setString(1,rs_one.getString(1));
			st_two.setString(2, name);
			st_two.setString(3, department);
			break;
		}
		st_two.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("id",name);
		request.getRequestDispatcher("/FacultyDashBoard.jsp").forward(request, response);
	}

}
