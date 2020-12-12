package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ClassDao;
import dao.DBConnection;
import dao.StudentDao;
import dao.TeacherDao;

public class Menu {
	
	private Connection connection;
	
	public Menu() {
		connection = DBConnection.getConnection();
	}
	
	ClassDao classDao = new ClassDao();
	TeacherDao teacherDao = new TeacherDao();
	StudentDao studentDao = new StudentDao();
	private Scanner scanner = new Scanner(System.in);
	
	private List<String> options = Arrays.asList(
													"Add Class",
													"Show Class",
													"Show Classes",
													"Update Class",
													"Delete Class",
													
													"Add Teacher",
													"Show Teacher",
													"Show Teachers",
													"Update Teacher",
													"Delete Teacher",
													
													"Add Student",
													"Show Student",
													"Show Students",
													"Update Student",
													"Delete Student");
	public void start() {
		String selection ="";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			try {
				if (selection.equals("1")) {
					createClass();
				} else if (selection.equals("2")) {
					showClass();
				} else if (selection.equals("3")) {
					showClasses();
				} else if (selection.equals("4")) {
					updateClass();
				} else if (selection.equals("5")) {
					deleteClass();
				} else if (selection.equals("6")) {
					createTeacher();
				} else if (selection.equals("7")) {
					showTeacher();
				} else if (selection.equals("8")) {
					showTeachers();
				} else if (selection.equals("9")) {
					updateTeacher();
				} else if (selection.equals("10")) {
					deleteTeacher();
				} else if (selection.equals("11")) {
					createStudent();
				} else if (selection.equals("12")) {
					showStudent();
				} else if (selection.equals("13")) {
					showStudents();
				} else if (selection.equals("14")) {
					updateStudent();
				} else if (selection.equals("15")) 
					deleteStudent();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n--------------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}	
	}

	private void createClass() throws SQLException {
		
	}
	private void showClass() throws SQLException {
		
	}
	private void showClasses() throws SQLException {
		
	}
	private void updateClass() throws SQLException {
		
	}
	private void deleteClass() throws SQLException {
		
	}
	private void createTeacher() throws SQLException {
		
	}
	private void showTeacher() throws SQLException {
		
	}
	private void showTeachers() throws SQLException {
		
	}
	private void updateTeacher() throws SQLException {
		
	}
	private void deleteTeacher() throws SQLException {
		
	}
	private void createStudent() throws SQLException {
		
	}
	private void showStudent() throws SQLException {
		
	}
	private void showStudents() throws SQLException {
		
	}
	private void updateStudent() throws SQLException {
		
	}
	private void deleteStudent() throws SQLException {
		
	}

}
