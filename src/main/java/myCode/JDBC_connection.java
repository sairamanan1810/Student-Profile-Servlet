package myCode;
import java.sql.*;
import java.util.*;

import com.mysql.cj.xdevapi.Result;
public class JDBC_connection {
	
	
	public static Connection initializedatabase() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner (System.in);
		String url = "jdbc:mysql://localhost:3306/student_profile";
		String un="root";
		String pass="password";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,un,pass);
		return con;
		
	}

}
