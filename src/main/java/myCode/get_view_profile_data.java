package myCode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class get_view_profile_data
 */
@WebServlet("/get_view_profile_data")
public class get_view_profile_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_view_profile_data() {
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
		String var=String.valueOf(session.getAttribute("roll_no"));
		System.out.print(var);
		ArrayList<String> skill_set= new ArrayList<String>();
		try {
		Connection con = JDBC_connection.initializedatabase();
		String sql="Select * from studentdetails where roll_no=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, var);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			session.setAttribute("profile_name",rs.getString(2));
			session.setAttribute("profile_location",rs.getString(3));
			String[] skills = String.valueOf(rs.getString(4)).split(",");
			session.setAttribute("profile_skillset",skills);
			session.setAttribute("profile_linkedin",rs.getString(5));
			session.setAttribute("profile_github",rs.getString(6));
			session.setAttribute("profile_gmail",String.valueOf("mailto"+rs.getString(7)));
			session.setAttribute("profile_bio",rs.getString(9));
			session.setAttribute("profile_dept",rs.getString(12).toUpperCase()+"-"+rs.getString(13));
			session.setAttribute("profile_duration",rs.getString(10)+" - "+rs.getString(11));
		}
		String sql_one="Select * from journals where student_id=? and status=?";
		String sql_two="Select * from internship where student_id=? and status=?";
		String sql_three="Select * from project where student_id=? and status=?";
		PreparedStatement st_one=con.prepareStatement(sql_one);
		PreparedStatement st_two=con.prepareStatement(sql_two);
		PreparedStatement st_three=con.prepareStatement(sql_three);
		st_one.setString(1, var);
		st_two.setString(1, var);
		st_three.setString(1, var);
		st_one.setString(2, "Approved");
		st_two.setString(2, "Approved");
		st_three.setString(2, "Approved");
		ResultSet rs_one=st_one.executeQuery();
		ResultSet rs_two=st_two.executeQuery();
		ResultSet rs_three=st_three.executeQuery();
		ArrayList<ArrayList<String> > interns= new ArrayList<ArrayList<String> >();
		ArrayList<ArrayList<String> > projects= new ArrayList<ArrayList<String> >();
		ArrayList<ArrayList<String> > journals= new ArrayList<ArrayList<String> >();
		while(rs_one.next()) {
			journals.add(new ArrayList<String>(Arrays.asList(rs_one.getString(2).toUpperCase(),rs_one.getString(3).toUpperCase(),rs_one.getString(4).toUpperCase(),rs_one.getString(5))));
		}
		request.setAttribute("journals", journals);
		System.out.println(request.getAttribute("journals"));
		while(rs_two.next()) {
			interns.add(new ArrayList<String>(Arrays.asList(rs_two.getString(3).toUpperCase(),rs_two.getString(4).toUpperCase(),rs_two.getString(5).toUpperCase(),rs_two.getString(6))));
		}
		request.setAttribute("interns", interns);
		while(rs_three.next()) {
			projects.add(new ArrayList<String>(Arrays.asList(rs_three.getString(3).toUpperCase(),rs_three.getString(4).toUpperCase(),rs_three.getString(5).toUpperCase(),rs_three.getString(6))));
		}
		request.setAttribute("projects", projects);
		System.out.println(projects);
		System.out.println(journals);
		System.out.println(interns);
		con.close();
		st_one.close();
		st_two.close();
		st.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/view_profile.jsp").forward(request,response);	
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
