package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	
private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
private final String CREATE_NEW_STUDENT_QUERY = "INSERT INTO student(studentName, grade, classId) VALUES (?,?,?)";
private final String SHOW_STUDENT_BY_ID_QUERY = "SELECT * FROM student WHERE id = ?";
private final String SHOW_ALL_STUDENTS_QUERY = "SELECT * FROM student";	
		

	
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
	
	public void showAllStudents() throws SQLException {	
		PreparedStatement ps = connection.prepareStatement(SHOW_ALL_STUDENTS_QUERY);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Id: " + rs.getInt(1) + "\tStudent Name: " + rs.getString(2));
		}

	}
	public void showStudentById(int studentId) throws SQLException { 	
		PreparedStatement ps = connection.prepareStatement(SHOW_STUDENT_BY_ID_QUERY);
		ps.setInt(1, studentId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {	
			System.out.println("Id: " + rs.getInt(1) + "\tStudent Name: " + rs.getString(4) + "\tGrade: " + rs.getString(3) + "\tClass Id: " + rs.getString(2));		

	//finish coding and setting the prepared statements
		}
	}
}
