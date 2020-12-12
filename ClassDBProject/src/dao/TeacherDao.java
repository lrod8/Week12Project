package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Teacher;

public class TeacherDao {
	
	private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	private final String CREATE_NEW_TEACHER_QUERY = "INSERT INTO teacher(teacherName, hireDate, email, classId) VALUES (?,?,?,?)";
	private final String GET_TEACHER_BY_CLASS_ID_QUERY = "SELECT * FROM teacher WHERE class_id = ?";
	private final String UPDATE_TEACHER_BY_ID = "UPDATE teacher SET  classId = ?, hireDate = ?, teacherName = ?, email = ? WHERE id = ?";
	
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

//	public List<Teacher> getTeacherByClassId(int classId) throws SQLException {
//		PreparedStatement ps = connection.prepareStatement(GET_TEACHER_BY_CLASS_ID_QUERY); 
//		ps.setInt(1, classId);
//		ResultSet rs = ps.executeQuery();
//		List<Teacher> teachers = new ArrayList<Teacher>();
//		
//		while (rs.next()) {	
//			teachers.add(new Teacher(rs.getInt(4), rs.getString(1));
//		}
//		return teachers;
//	}

	public void updateTeacherById (int classId, String hireDate, String teacherName, String email, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_TEACHER_BY_ID);
		ps.setInt(1, classId);
		ps.setString(2, hireDate);
		ps.setString(3, teacherName);
		ps.setString(4, email);
		ps.setInt(5, id);
		ps.executeUpdate();
	}	
	
	
}

