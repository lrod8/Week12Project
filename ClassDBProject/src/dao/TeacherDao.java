package dao;

import java.sql.Connection;

public class TeacherDao {
	
	private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	
	public TeacherDao() {
		connection = DBConnection.getConnection();
	}
		
	//finish coding and setting the prepared statements

}
