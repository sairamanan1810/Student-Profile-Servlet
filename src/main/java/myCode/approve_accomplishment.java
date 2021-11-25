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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class approve_accomplishment
 */
@WebServlet("/approve_accomplishment")
public class approve_accomplishment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public approve_accomplishment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String type=String.valueOf(request.getParameter("type"));
		String status=request.getParameter("status");
		Scanner sc=new Scanner (System.in);
		HttpSession session=request.getSession();
		System.out.println(id+","+type.getClass().getSimpleName()+","+status.getClass().getSimpleName());
		
		try {
		Connection con = JDBC_connection.initializedatabase();
		
        // Create a SQL query to insert data into demo table
        // demo table consists of two columns, so two '?' is used
        
        if(type.equals("intern")) {
        	System.out.println("Sai");
        	String sql="Update internship set status=? where intern_id=?";
        	PreparedStatement st = con.prepareStatement(sql);
        	st.setString(1,status);
        	st.setInt(2,id);
        	int rowAffected =st.executeUpdate();
        	System.out.println(rowAffected);
        }
        else if(type.equals("journal")) {
        	String sql="Update journals set status=? where journal_id=?";
        	PreparedStatement st = con.prepareStatement(sql);
        	st.setString(1,status);
        	st.setInt(2,id);
        	int rowAffected =st.executeUpdate();
        	System.out.println(rowAffected);
        }
        else if(type.equals("project")) {
        	String sql="Update project set status=? where project_id=?";
        	PreparedStatement st=con.prepareStatement(sql);
        	st.setString(1,status);
        	st.setInt(2,id);
        	int rowAffected =st.executeUpdate();
        	System.out.println(rowAffected);
        }
        request.getRequestDispatcher("/list_of_requests").forward(request,response);
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
