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
 * Servlet implementation class edit_education
 */
@WebServlet("/edit_profile")
public class edit_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String roll_no=String.valueOf(session.getAttribute("roll_no"));
		request.setAttribute("roll_no",roll_no);
		try {
			Connection con = JDBC_connection.initializedatabase();
			String sql="Select * from studentdetails where roll_no=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, roll_no);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				request.setAttribute("profile_name",rs.getString(2));
				request.setAttribute("profile_location",rs.getString(3));
				request.setAttribute("profile_skillset",rs.getString(4));
				request.setAttribute("profile_photo",rs.getString(8));
				request.setAttribute("profile_bio",rs.getString(9));
				System.out.println(rs.getString(4));
			}
			request.getRequestDispatcher("/edit_profile.jsp").forward(request,response);
		} catch(Exception e) {
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
