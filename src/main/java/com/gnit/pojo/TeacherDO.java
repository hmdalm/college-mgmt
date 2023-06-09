package com.gnit.pojo;

public class TeacherDO {

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	private int teacherId;

	public TeacherDO(int teacherId, String firstName, String middleName, String lastName, String dob, String department,
			String qualification, String address, String email, String mobile) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.department = department;
		this.qualification = qualification;
		this.address = address;
		this.email = email;
		this.mobile = mobile;

	}

	public TeacherDO() {
		// TODO Auto-generated constructor stub
	}

	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String department;
	private String qualification;
	private String address;
	private String email;
	private String mobile;

}
