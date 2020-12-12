package entity;

public class Teacher {
	
	private int teacherId;
	private int classId;
	private int hireDate;
	private String teacherName;
	private String email;
	
	public Teacher(int teacherId, int classId, int hireDate, String teacherName, String email) {
		this.setTeacherId(teacherId);
		this.setClassId(classId);
		this.setHireDate(hireDate);
		this.setTeacherName(teacherName);
		this.setEmail(email);
	}
	
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	
	public int getHireDate() {
		return hireDate;
	}
	public void setHireDate(int hireDate) {
		this.hireDate = hireDate;
	}
	
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}

