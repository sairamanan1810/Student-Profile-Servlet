package myCode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class dashboard_details
 */
@WebServlet("/dashboard_details")
public class dashboard_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboard_details() {
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
		String roll_no=String.valueOf(session.getAttribute("roll_no"));
		try {
			Connection con = JDBC_connection.initializedatabase();
			String sql2 = "Select * from StudentDetails where roll_no=?";
			PreparedStatement st2 = con.prepareStatement(sql2);
			st2.setString(1, roll_no);
			ResultSet rs2 = st2.executeQuery();
			while(rs2.next()) {
				request.setAttribute("course", rs2.getString(12));
				request.setAttribute("jyear", rs2.getString(10));
				request.setAttribute("eyear", rs2.getString(11));
			}
			
			//
			ArrayList<Map<String, String>> accompishments = new ArrayList<Map<String, String>>();
			String sql_next = "Select * from internship where student_id='"+roll_no+"'";
			PreparedStatement st_next = con.prepareStatement(sql_next);
			ResultSet rs3 = st_next.executeQuery();
			while (rs3.next()) {
				Map<String, String> intern = new HashMap<String, String>(){
					{
						put("title",rs3.getString(3));
						put("description",rs3.getString(6));
						put("type","Internship");
						put("duration",rs3.getString(4));
						put("status",rs3.getString(7));
						
					}};
					accompishments.add(intern);
			}
			String sql_next1 = "Select * from project where student_id='"+roll_no+"'";
			PreparedStatement st_next1 = con.prepareStatement(sql_next1);
			ResultSet rs4 = st_next1.executeQuery();
			while (rs4.next()) {
				Map<String, String> project = new HashMap<String, String>(){
					{
						put("title",rs4.getString(3));
						put("description",rs4.getString(6));
						put("type","Project");
						put("duration",rs4.getString(5));
						put("status",rs4.getString(7));
						
					}};
					accompishments.add(project);
			}
			String sql_next2 = "Select * from journals where student_id='"+roll_no+"'";
			PreparedStatement st_next2 = con.prepareStatement(sql_next2);
			ResultSet rs5 = st_next2.executeQuery();
			while (rs5.next()) {
				Map<String, String> journal = new HashMap<String, String>(){
					{
						put("title",rs5.getString(2));
						put("description",rs5.getString(5));
						put("type","Journal");
						put("duration",rs5.getString(3));
						put("status",rs5.getString(7));
						
					}};
					accompishments.add(journal);
			}
			request.setAttribute("accomplishments", accompishments);
			
    		request.getRequestDispatcher("/DashBoard2.jsp").forward(request, response);

			st_next.close();
			con.close();
		} catch (Exception e) {
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
