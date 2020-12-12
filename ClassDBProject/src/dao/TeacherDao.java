package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDao {
	
	private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	private final String CREATE_NEW_TEACHER_QUERY = "INSERT INTO teacher(teacherName, hireDate, email, classId) VALUES (?,?,?,?)";

	
	public TeacherDao() {
		connection = DBConnection.getConnection();
	}
		
	//finish coding and setting the prepared statements
	
	public void createNewTeacher(String teacherName, String hireDate, String email, int classId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TEACHER_QUERY);
		ps.setString(1, teacherName);
		ps.setString(2, hireDate);
		ps.setString(3, email);
		ps.setInt(4, classId);
		ps.executeUpdate();
	}

}
