package myCode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class create_class_room
 */
@WebServlet("/create_class_room")
public class create_class_room extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create_class_room() {
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
		doGet(request, response);
		HttpSession session=request.getSession();
		String mentor1=request.getParameter("Mentor1");
		String mentor2=request.getParameter("Mentor2");
		String course=request.getParameter("dept");
		String sec=request.getParameter("section");
		String year=request.getParameter("year_joined");
		String sql="Insert Into class_room(course,section,year_of_joining,mentor1,mentor2) Values (?,?,?,?,?)";
		try {
		Connection con = JDBC_connection.initializedatabase();
		
        // Create a SQL query to insert data into demo table
        // demo table consists of two columns, so two '?' is used
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,course);
        st.setString(2,sec);
        st.setString(3,year);
        st.setString(4,mentor1);
        st.setString(5,mentor2);
        st.executeUpdate();
        st.close();
        String sql_one="Select * from class_room";
        PreparedStatement st_one = con.prepareStatement(sql_one);
        ResultSet rs=st_one.executeQuery();
        ArrayList<ArrayList<String> > classes= new ArrayList<ArrayList<String> >();
        while(rs.next()) {
        	classes.add(new ArrayList<String>(Arrays.asList(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6))));
        }
        request.setAttribute("classes", classes);
        st.close();
        con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin_create_classes.jsp").forward(request, response);
		
	}

}
