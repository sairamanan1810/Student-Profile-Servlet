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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		System.out.println("In Post");
		HttpSession session=request.getSession();
		String roll_no = (String) session.getAttribute("roll_no");
		
		String sql="Select * from StudentDetails where roll_no = ?";
		try {
		Connection con = JDBC_connection.initializedatabase();
		
        // Create a SQL query to insert data into demo table
        // demo table consists of two columns, so two '?' is used
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        String roll_no;
        
        while(rs.next()) {
	        roll_no=rs.getString(5);
	        if(rs.getString(2).equals(name) && rs.getString(3).equals(password)) {
	        	session.setAttribute("id",name);
	        	request.setAttribute("name", name);
	        	if(rs.getString(4).equals("Student")) {
					session.setAttribute("roll_no",roll_no);
					
					String sql2 = "Select * from StudentDetails where roll_no=?";
					PreparedStatement st2 = con.prepareStatement(sql2);
					st2.setString(1, roll_no);
					ResultSet rs2 = st2.executeQuery();
					while(rs2.next()) {
						request.setAttribute("course", rs2.getString(12));
						request.setAttribute("jyear", rs2.getString(10));
						request.setAttribute("eyear", rs2.getString(11));
					}
					
	        		request.getRequestDispatcher("/DashBoard2.jsp").forward(request, response);
	        		
	        	}
	        	else if(rs.getString(4).equals("Faculty")){
	        		request.getRequestDispatcher("/FacultyDashBoard.jsp").forward(request, response);
	        	}
	        	else {
	        		
	        		request.getRequestDispatcher("/admin_student_table").forward(request, response);	
	        	}
	        	
	        }	
	        }
	        request.getRequestDispatcher("/login.html").include(request, response);
	        // Close all the connections
	        st.close();
            con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
