package com.gnit.pojo;

public class StudentDO {
	public StudentDO(int studentId, String firstName, String middleName, String lastName, String dob, String rollNo,
			String course, String address, String email, String mobile) {
		super();
		StudentId = studentId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.rollNo = rollNo;
		this.course = course;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		
	}
	public StudentDO() {
		
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	private int StudentId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String rollNo;
	private String course;
	private String address;
	private String email;
	private String mobile;
	

}
