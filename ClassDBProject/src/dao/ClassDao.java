package dao;

import java.sql.Connection;

public class ClassDao {
	
	private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	
	
	public ClassDao() {
		connection = DBConnection.getConnection();
	}

	//finish coding and setting the prepared statements

}
