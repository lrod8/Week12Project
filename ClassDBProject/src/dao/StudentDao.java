package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	
private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
private final String CREATE_NEW_STUDENT_QUERY = "INSERT INTO student(studentName, grade, classId) VALUES (?,?,?)";

private final String GET_STUDENT_BY_CLASS_ID_QUERY = "SELECT * FROM student WHERE class_id = ?";	
private final String UPDATE_STUDENT_BY_ID = "UPDATE student SET  classId = ?, grade = ?, studentName = ? WHERE id = ?";

private final String SHOW_STUDENT_BY_ID_QUERY = "SELECT * FROM student WHERE id = ?";
private final String SHOW_ALL_STUDENTS_QUERY = "SELECT * FROM student";
private final String DELETE_STUDENT_BY_ID_QUERY = "DELETE FROM student WHERE id = ?";
private final String DELETE_STUDENT_BY_CLASS_ID_QUERY = "DELETE FROM student WHERE classid = ?";
		


	
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
			System.out.println("Id: " + rs.getInt(1) + "\tStudent Name: " + rs.getString(4) + "\tGrade: " + rs.getString(3) + "\tClass Id: " + rs.getString(2));
		}

	}
	public void updateStudentById (int classId, int grade, String studentName, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
		ps.setInt(1, classId);
		ps.setInt(2, grade);
		ps.setString(3, studentName);
		ps.setInt(4, id);
		ps.executeUpdate();
	}	
	
	
	//finish coding and setting the prepared statements

	
	public void showStudentById(int studentId) throws SQLException { 	
		PreparedStatement ps = connection.prepareStatement(SHOW_STUDENT_BY_ID_QUERY);
		ps.setInt(1, studentId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {	
			System.out.println("Id: " + rs.getInt(1) + "\tStudent Name: " + rs.getString(4) + "\tGrade: " + rs.getString(3) + "\tClass Id: " + rs.getString(2));		


	//finish coding and setting the prepared statements
		}
	}
	
	public void deleteStudentById (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void deleteStudentByClassId (int classId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT_BY_CLASS_ID_QUERY);
		ps.setInt(1, classId);
		ps.executeUpdate();
	}
}
