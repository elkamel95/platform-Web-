package test;

import java.sql.*;

public class SingleConnection {
	private static Connection connection ;



public static Connection getConnection() {
		return connection;
	}



	



static {
	try {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetfin","root","");
	}catch (Exception e){
		e.printStackTrace();;
		
	}
}
}
