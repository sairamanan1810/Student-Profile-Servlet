package myCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Internship_details
 */
@WebServlet("/Internship_details")
public class Internship_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Internship_details() {
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
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = request.getParameter("intern_title");
		String duration = request.getParameter("intern_duration");
		String company = request.getParameter("intern_company");
		//String role = request.getParameter("intern_role");
		String description = request.getParameter("intern_description");
		//out.println(title+','+duration+','+company+','+description);
		//out.println((String)request.getSession().getAttribute("roll_no"));
		String sql="Insert Into internship(student_id,company_name,duration,project_title,project_description) Values (?,?,?,?,?)";
		try {
			Connection con = JDBC_connection.initializedatabase();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, (String)request.getSession().getAttribute("roll_no"));
	        st.setString(2, company);
	        st.setString(3, duration);
	        st.setString(4, title);
	        st.setString(5, description);
	        st.executeUpdate();
	        
	        request.getRequestDispatcher("/add-experience.html").include(request, response);
	        st.close();
            con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		out.close();
	}

}
