package myCode;

import java.io.IOException;
import java.lang.reflect.Array;
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

/**
 * Servlet implementation class profile_search
 */
@WebServlet("/profile_search")
public class profile_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile_search() {
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
			Connection con = JDBC_connection.initializedatabase();
			ArrayList<Map<String, String>> student_array = new ArrayList<Map<String, String>>();
			System.out.println("Hello");
			String search=request.getParameter("search");
			String sql_next = "Select name,roll_no,bio,photo,skill_set,location from studentdetails where name like '%"+search+"%'";
			PreparedStatement st_next = con.prepareStatement(sql_next);
			ResultSet rs = st_next.executeQuery();
			while (rs.next()) {
				Map<String, String> student = new HashMap<String, String>(){
					{
						put("name",rs.getString(1));
						put("rollno",rs.getString(2));
						put("bio",rs.getString(3));
						put("photo",rs.getString(4));
						put("skill",rs.getString(5));
						put("location",rs.getString(6));
						
					}};
				student_array.add(student);
			}
			request.setAttribute("st_list", student_array);
			request.getRequestDispatcher("/profilesearch.jsp").forward(request, response);

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
