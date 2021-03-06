package myCode;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.util.*;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;
/**
 * Servlet implementation class login_servlet
 */
@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Scanner sc=new Scanner (System.in);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String password=request.getParameter("pwd");
		System.out.println("In Post");
		HttpSession session=request.getSession();
		
		String sql="Select * from logincredentials where username=? and password=?";
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
        st.setString(2, password);
        // Execute the insert command using executeUpdate()
        // to make changes in database
        ResultSet rs = st.executeQuery();
        String roll_no;
        
        while(rs.next()) {
	        roll_no=rs.getString(5);
	        if(rs.getString(2).equals(name) && rs.getString(3).equals(password)) {
	        	session.setAttribute("id",name);
	        	request.setAttribute("name", name);
	        	if(rs.getString(4).equals("Student")) {
					session.setAttribute("roll_no",roll_no);
					
	        		request.getRequestDispatcher("/dashboard_details").forward(request, response);
	        		
	        	}
	        	else if(rs.getString(4).equals("Faculty")){
	        		System.out.println("Hello");
	        		session.setAttribute("loginId",rs.getString(1));
	        		request.getRequestDispatcher("/list_of_requests").forward(request, response);
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

		System.out.println(name);
		System.out.println(password);

	}

}
