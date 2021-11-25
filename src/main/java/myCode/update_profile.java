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
 * Servlet implementation class update_profile
 */
@WebServlet("/update_profile")
public class update_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("hellooooooo");
		HttpSession session=request.getSession();
		String roll_no=String.valueOf(session.getAttribute("roll_no"));
		request.setAttribute("roll_no",roll_no);
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String skill_set = request.getParameter("skills");
		String photo = request.getParameter("photo");
		String bio = request.getParameter("bio");
		try {
			Connection con = JDBC_connection.initializedatabase();
			String sql="Update studentdetails set name=?, location = ?, skill_set = ?,photo = ?, bio = ? where roll_no=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, location);
			st.setString(3, skill_set);
			st.setString(4, photo);
			st.setString(5, bio);
			st.setString(6, roll_no);
			int rs=st.executeUpdate();
			
			
			request.getRequestDispatcher("/get_view_profile_data?func=dashboard").forward(request,response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
