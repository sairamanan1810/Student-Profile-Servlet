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
 * Servlet implementation class Journal_details
 */
@WebServlet("/Journal_details")
public class Journal_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Journal_details() {
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
		String title = request.getParameter("journal_title");
		String duration = request.getParameter("journal_duration");
		String publication = request.getParameter("journal_publication");
		String description = request.getParameter("journal_description");
		//out.println(title+','+duration+','+publication+','+description);
		String sql="Insert Into journals(title,duration,publication,description,student_id,status) Values (?,?,?,?,?,?)";
		try {
			Connection con = JDBC_connection.initializedatabase();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
	        st.setString(2, duration);
	        st.setString(3, publication);
	        st.setString(4, description);
	        st.setString(5, (String)request.getSession().getAttribute("roll_no"));
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
