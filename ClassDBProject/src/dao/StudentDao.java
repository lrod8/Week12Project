package dao;

import java.sql.Connection;

public class StudentDao {
	
private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	
	public StudentDao() {
		connection = DBConnection.getConnection();
	}

	//finish coding and setting the prepared statements

}
