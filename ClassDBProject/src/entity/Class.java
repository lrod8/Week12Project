package entity;

import java.util.List;

public class Class {
	
	private int classId;
	private String className;
	private List<Student> students;
	private List<Class> classes;
	private Teacher teachers;
	
	public Class(int classId, String className, List<Student> students, Teacher teachers) {
		this.setClassId(classId);
		this.setClassName(className);
		this.setStudents(students);
		this.setTeachers(teachers);
	}
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public List<Class> getclasses() {
		return classes;
	}
	
	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public Teacher getTeachers() {
		return teachers;
	}

	public void setTeachers(Teacher teachers) {
		this.teachers = teachers;
	}

}
