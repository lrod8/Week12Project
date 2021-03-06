package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TeacherDao {
	
	private Connection connection;
	
	//Insert The MYSQL private Final Strings in here
	private final String CREATE_NEW_TEACHER_QUERY = "INSERT INTO teacher(teacherName, hireDate, email, classId) VALUES (?,?,?,?)";

	private final String GET_TEACHER_BY_CLASS_ID_QUERY = "SELECT * FROM teacher WHERE class_id = ?";
	private final String UPDATE_TEACHER_BY_ID = "UPDATE teacher SET  classId = ?, hireDate = ?, teacherName = ?, email = ? WHERE id = ?";

	private final String SHOW_TEACHER_BY_ID_QUERY = "SELECT * FROM teacher WHERE id = ?";
	private final String SHOW_ALL_TEACHERS_QUERY = "SELECT * FROM teacher";	
	private final String DELETE_TEACHER_BY_ID_QUERY = "DELETE FROM teacher WHERE id = ?";
	private final String DELETE_TEACHER_BY_CLASS_ID_QUERY = "DELETE FROM teacher WHERE classid = ?";



	
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

	public void showAllTeachers() throws SQLException {	
		PreparedStatement ps = connection.prepareStatement(SHOW_ALL_TEACHERS_QUERY);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Id: " + rs.getInt(1) + "\tTeacher Name: " + rs.getString(4) + "\tHire Date: " + rs.getDate(3) + "\tEmail: " + rs.getString(5) + "\tClass Id: " + rs.getInt(2));
		}

	}
	public void showTeacherById(int teacherId) throws SQLException { 	
		PreparedStatement ps = connection.prepareStatement(SHOW_TEACHER_BY_ID_QUERY);
		ps.setInt(1, teacherId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {	
			System.out.println("Id: " + rs.getInt(1) + "\tTeacher Name: " + rs.getString(4) + "\tHire Date: " + rs.getDate(3) + "\tEmail: " + rs.getString(5) + "\tClass Id: " + rs.getInt(2));		
		}
	}
	
	public void deleteTeacherById (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TEACHER_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void deleteTeacherByClassId (int classId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TEACHER_BY_CLASS_ID_QUERY);
		ps.setInt(1, classId);
		ps.executeUpdate();
	}


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

