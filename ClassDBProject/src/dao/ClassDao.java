package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDao {
	
	private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	private final String CREATE_NEW_CLASS_QUERY = "INSERT INTO class(className) VALUES (?)";
	private final String GET_CLASS_QUERY = "SELECT * FROM class";
	private final String GET_CLASS_BY_ID_QUERY = "SELECT * FROM classes WHERE id = ?";	
	
	public ClassDao() {
		connection = DBConnection.getConnection();
	}

	//finish coding and setting the prepared statements
	
	public void createNewClass(String className) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CLASS_QUERY);
		ps.setString(1, className);
		ps.executeUpdate();
	}
	
	public List<Class> getClasses() throws SQLException {	
		ResultSet rs = connection.prepareStatement(GET_CLASS_QUERY).executeQuery();
		List<Class> classes = new ArrayList<Class> ();
		
		while (rs.next()) {	
			classes.add(populateClass(rs.getInt(1), rs.getString(2)));
	}
	
		return classes;
}
	
	public Class getClassById(int id) throws SQLException { 	
		PreparedStatement ps = connection.prepareStatement(GET_CLASS_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();	
		return populateClass(rs.getInt(1), rs.getString(2));	
	}

	private Class populateClass(int id, String name) throws SQLException {	
		return new Class(id, name, studentDao.getstudentByClassId(id) + teacherDao.getteacherByClassId(id));
	}

}
