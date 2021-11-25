package myCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class list_of_requests
 */
@WebServlet("/list_of_requests")
public class list_of_requests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public list_of_requests() {
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
		HttpSession session=request.getSession();
		try {
			Connection con=JDBC_connection.initializedatabase();
			String name=String.valueOf(session.getAttribute("name"));
			String sql="Select course,section,year_of_joining from class_room where mentor1=? or mentor2=? order by course,section";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, name);
			ResultSet rs=st.executeQuery();
			ArrayList<ArrayList<String> > intern= new ArrayList<ArrayList<String> >();
			ArrayList<ArrayList<String> > journal= new ArrayList<ArrayList<String> >();
			ArrayList<ArrayList<String> > project= new ArrayList<ArrayList<String> >();
			while(rs.next()) {
				String sql_intern="Select s.roll_no,i.company_name,i.duration,i.project_title,i.project_description from internship i,studentdetails s where i.student_id=s.roll_no and i.status=? and s.course=? and s.section=? and s.joining_year=?";
				PreparedStatement st_one=con.prepareStatement(sql_intern);
				st_one.setString(1,"Wait");
				st_one.setString(2,rs.getString(1));
				st_one.setString(3,rs.getString(2));
				st_one.setString(4,rs.getString(3));
				ResultSet rs_one=st_one.executeQuery();
				while(rs_one.next()) {
					intern.add(new ArrayList<String>(Arrays.asList(rs_one.getString(1),rs_one.getString(2)+rs_one.getString(3)+rs_one.getString(4)+rs_one.getString(5))));
				}
			}
			request.setAttribute("request_intern_add",intern);
			request.getRequestDispatcher("/Faculty_DashBoard.jsp");
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
