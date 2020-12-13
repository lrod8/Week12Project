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
		System.out.print("Enter the name of the new class:");
		String className = scanner.nextLine();
		classDao.createNewClass(className);
	}

	private void showClass() throws SQLException {
		System.out.print("Enter class id: ");
		int classId = Integer.parseInt(scanner.nextLine());
		classDao.showClassById(classId);
			
		}
		
	private void showClasses() throws SQLException {
		classDao.showAllClasses();
	
	}

	private void updateClass() throws SQLException {
		System.out.println("Enter ID Of The Class You'd Like To Update:  ");
		int classId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Updated Class Name: ");
		String className = scanner.nextLine();
		classDao.updateClassById(classId ,className);
	}
	private void deleteClass() throws SQLException {
		System.out.print("Enter a class ID to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		classDao.deleteClassById(id);
		System.out.println("Class ID:" + id + " has been deleted!");
	}
	private void createTeacher() throws SQLException {
		System.out.print("Enter the name of the new teacher:");
		String teacherName = scanner.nextLine();
		System.out.print("Enter the hire date YYYY-MM-DD of the new teacher:");
		String hireDate = scanner.nextLine();
		System.out.println("Enter the email of the new teacher:");
		String email = scanner.nextLine();
		System.out.print("Enter the class id of the new teacher:");
		int classId = Integer.parseInt(scanner.nextLine());
		teacherDao.createNewTeacher(teacherName, hireDate, email, classId);
	}
	
	private void showTeacher() throws SQLException {
		System.out.print("Enter teacher id: ");
		int teacherId = Integer.parseInt(scanner.nextLine());
		teacherDao.showTeacherById(teacherId);
			
		}
	private void showTeachers() throws SQLException {
		teacherDao.showAllTeachers();
	}

	private void updateTeacher() throws SQLException {
		System.out.println("Enter ID Of The Teacher You'd Like To Update:  ");
		int teacherId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Updated The Teacher's Class ID:  ");
		int classId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Updated Teacher Hire Date (YYYY-MM-DD) : ");
		String hireDate = scanner.nextLine();
		System.out.println("Enter Updated Teacher Name:  ");
		String teacherName = scanner.nextLine();
		System.out.println("Enter Updated Teacher Email: ");
		String email = scanner.nextLine();
		teacherDao.updateTeacherById(classId, hireDate, teacherName, email, teacherId);
		
	}
	private void deleteTeacher() throws SQLException {
		System.out.print("Enter a teacher ID to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		teacherDao.deleteTeacherById(id);
		System.out.println("Teacher ID:" + id + " has been deleted!");
	}
	private void createStudent() throws SQLException {
		System.out.print("Enter the name of the new student:");
		String studentName = scanner.nextLine();
		System.out.print("Enter the numeric grade of the new student:");
		int grade = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the class id of the new student:");
		int classId = Integer.parseInt(scanner.nextLine());
		studentDao.createNewStudent(studentName, grade, classId);
	}

	private void showStudent() throws SQLException {
		System.out.print("Enter student id: ");
		int studentId = Integer.parseInt(scanner.nextLine());
		studentDao.showStudentById(studentId);
			
	}
	private void showStudents() throws SQLException {
		studentDao.showAllStudents();
	}


	private void updateStudent() throws SQLException {
		System.out.println("Enter ID Of The Student You'd Like To Update:  ");
		int studentId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Updated The Student's Class ID:  ");
		int classId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Updated Student's Grade (01-12): ");
		int grade = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Updated Student Name:  ");
		String studentName = scanner.nextLine();
		studentDao.updateStudentById(classId, grade, studentName, studentId);
		
	}
	private void deleteStudent() throws SQLException {
		System.out.print("Enter a student ID to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		studentDao.deleteStudentById(id);
		System.out.println("Student ID:" + id + " has been deleted!");
	}

}
