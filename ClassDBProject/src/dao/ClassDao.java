package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassDao {
	
	private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	private final String CREATE_NEW_CLASS_QUERY = "INSERT INTO class(className) VALUES (?)";
	
	public ClassDao() {
		connection = DBConnection.getConnection();
	}

	//finish coding and setting the prepared statements
	
	public void createNewClass(String className) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CLASS_QUERY);
		ps.setString(1, className);
		ps.executeUpdate();
	}

}
