package entity;

public class Student {
	
	private int studentId;
	private int classId;
	private int grade;
	private String studentName;
	
	public Student(int studentId, int classId, int grade, String studentName) {
		this.setStudentId(studentId);
		this.setClassId(classId);
		this.setGrade(grade);
		this.setStudentName(studentName);
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
