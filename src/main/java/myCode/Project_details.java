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
 * Servlet implementation class Project_details
 */
@WebServlet("/Project_details")
public class Project_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Project_details() {
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
		String title = request.getParameter("project_title");
		String duration = request.getParameter("project_duration");
		String tools = request.getParameter("project_tools");
		String description = request.getParameter("project_description");
		//out.println(title+','+duration+','+tools+','+description);
		String sql="Insert Into project(student_id,title,duration,tools,description,status) Values (?,?,?,?,?,?)";
		try {
			Connection con = JDBC_connection.initializedatabase();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, (String)request.getSession().getAttribute("roll_no"));
			st.setString(2, title);
			st.setString(3, duration);
	        st.setString(4, tools);
	        st.setString(5, description);
	        st.setString(6, "Wait");
	        st.executeUpdate();

	        // Close all the connections
	        
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
