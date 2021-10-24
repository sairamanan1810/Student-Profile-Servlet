package myCode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.sql.*;
import java.util.*;
import myCode.JDBC_connection;
/**
 * Servlet implementation class signup_servlet
 */
@WebServlet("/signup_servlet")
public class signup_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_servlet() {
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
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String roll_no=request.getParameter("roll_no");
		String pwd=request.getParameter("pwd");
		String sql="Insert Into logincredentials(username,password,role,roll_no) Values (?,?,?,?)";
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
        String opt="no";
        if(roll_no==null || roll_no=="") {
        	st.setString(3, "Faculty");
        	st.setString(4, null);
        	opt="yes";
        }
        else {
        st.setString(3, "Student");
        st.setString(4, roll_no);
        opt="no";
        }
        // Execute the insert command using executeUpdate()
        // to make changes in database
        st.executeUpdate();
        request.setAttribute("name", name);
        if(opt.equals("no")) {
        	
        	request.getRequestDispatcher("/dashBoardInitial.jsp").forward(request, response);
    	}
    	else {
    		request.getRequestDispatcher("/FacultyDashBoard.jsp").forward(request, response);
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
		doGet(request, response);
	}

}
