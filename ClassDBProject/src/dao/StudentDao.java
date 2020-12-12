package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	
private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
private final String CREATE_NEW_STUDENT_QUERY = "INSERT INTO student(studentName, grade, classId) VALUES (?,?,?)";

	
	public StudentDao() {
		connection = DBConnection.getConnection();
	}
	
	public void createNewStudent(String studentName, int grade, int classId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_STUDENT_QUERY);
		ps.setString(1, studentName);
		ps.setInt(2, grade);
		ps.setInt(3, classId);
		ps.executeUpdate();
	}

	//finish coding and setting the prepared statements

}
