package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private final static String USERNAME = "week12_admin";
	private final static String PASSWORD = "promineo12";
	private final static String URL = "jdbc:mysql://week12schooldb.c6enpaa8xoep.us-west-1.rds.amazonaws.com:3306/school";
	private static Connection connection;
	private static DBConnection instance;
	
	@SuppressWarnings("static-access")
	private DBConnection(Connection connection) {
		this.connection = connection;
	}
			
	public static Connection getConnection() {
		if (instance == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
				System.out.println("Connection successful!");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return DBConnection.connection;
	}

}
