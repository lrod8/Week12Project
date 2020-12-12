package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Student;

public class StudentDao {
	
private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
private final String CREATE_NEW_STUDENT_QUERY = "INSERT INTO student(studentName, grade, classId) VALUES (?,?,?)";
private final String GET_STUDENT_BY_CLASS_ID_QUERY = "SELECT * FROM student WHERE class_id = ?";	
private final String UPDATE_STUDENT_BY_ID = "UPDATE student SET  classId = ?, grade = ?, studentName = ? WHERE id = ?";
	
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
	
//	public List<Student> getStudentByClassId(int classId) throws SQLException {	
//		PreparedStatement ps = connection.prepareStatement(GET_STUDENT_BY_CLASS_ID_QUERY); 
//		ps.setInt(1, classId);
//		ResultSet rs = ps.executeQuery();
//		List<Student> students = new ArrayList<Student>();
//		
//		while (rs.next()) {	
//			students.add(new Student(rs.getInt(3), rs.getString(1));
//		}
//		return students;
//	}

	public void updateStudentById (int classId, int grade, String studentName, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
		ps.setInt(1, classId);
		ps.setInt(2, grade);
		ps.setString(3, studentName);
		ps.setInt(4, id);
		ps.executeUpdate();
	}	
	
	
	//finish coding and setting the prepared statements

}
