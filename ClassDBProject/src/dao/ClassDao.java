package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassDao {
	
	private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	private final String CREATE_NEW_CLASS_QUERY = "INSERT INTO class(className) VALUES (?)";
	private final String SHOW_CLASS_BY_ID_QUERY = "SELECT * FROM class WHERE id = ?";
	private final String SHOW_ALL_CLASSES_QUERY = "SELECT * FROM class";	
	
	public ClassDao() {
		connection = DBConnection.getConnection();
	}

//	finish coding and setting the prepared statements
	
	public void createNewClass(String className) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CLASS_QUERY);
		ps.setString(1, className);
		ps.executeUpdate();
	}
	public void showAllClasses() throws SQLException {	
		PreparedStatement ps = connection.prepareStatement(SHOW_ALL_CLASSES_QUERY);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Id: " + rs.getInt(1) + "\tClass Name: " + rs.getString(2));
		}

}
	
	public void showClassById(int classId) throws SQLException { 	
		PreparedStatement ps = connection.prepareStatement(SHOW_CLASS_BY_ID_QUERY);
		ps.setInt(1, classId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {	
		System.out.println("Id: " + rs.getInt(1) + "\tClass Name: " + rs.getString(2));	
		}
	}

}

