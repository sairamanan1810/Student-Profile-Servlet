package myCode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class initial_student_details_servlet
 */
@WebServlet("/initial_student_details_servlet")
public class initial_student_details_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initial_student_details_servlet() {
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
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String roll_no=request.getParameter("roll_no");
		String photo=request.getParameter("photo");
		String skills=request.getParameter("skills");
		String github=request.getParameter("github");
		String linkedin=request.getParameter("linkedin");
		String email=request.getParameter("email");
		
		String course=request.getParameter("course");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String bio=request.getParameter("bio");
		String sql="Insert Into (username,password,role,roll_no) Values (?,?,?,?)";
		try {
		Connection con = JDBC_connection.initializedatabase();
		
        // Create a SQL query to insert data into demo table
        // demo table consists of two columns, so two '?' is used
        PreparedStatement st = con.prepareStatement(sql);

        // For the first parameter,
        // get the data using request object
        // sets the data to st pointer
        st.setString(1, name);

        // Same for second parameter
        st.setString(2, pwd);
        if(roll_no==null || roll_no=="") {
        	st.setString(3, "Faculty");
        	st.setString(4, null);
        }
        else {
        st.setString(3, "Student");
        st.setString(4, roll_no);
        }
        // Execute the insert command using executeUpdate()
        // to make changes in database
        st.executeUpdate();

        // Close all the connections
        st.close();
        con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
