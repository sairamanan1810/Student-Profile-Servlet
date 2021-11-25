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
	        		
	        	}
	        	else if(rs.getString(4).equals("Faculty")){
	        		session.setAttribute("loginId",rs.getString(1));
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

		System.out.println(name);
		System.out.println(password);

	}

}
