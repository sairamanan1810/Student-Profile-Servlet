package myCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class add_education
 */
@WebServlet("/add_education")
public class add_education extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_education() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Scanner sc=new Scanner (System.in);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		String roll_no = (String) session.getAttribute("roll_no");
		
		String sql="Select * from StudentDetails where roll_no = ?";
		
		try {
		Connection con = JDBC_connection.initializedatabase();
		
        // Create a SQL query to insert data into demo table
        // demo table consists of two columns, so two '?' is used
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, roll_no);
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
	        String course = rs.getString(12);
	        String section = rs.getString(13);
	        String jyear = rs.getString(10);
	        String eyear = rs.getString(11);
	        request.setAttribute("course", course);
	        request.setAttribute("section", section);
	        request.setAttribute("jyear", jyear);
	        request.setAttribute("eyear", eyear);
	        request.getRequestDispatcher("/add-education.jsp").forward(request, response);
	        	
	        }
	        // Close all the connections
	        st.close();
            con.close();
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
		

	}

}
