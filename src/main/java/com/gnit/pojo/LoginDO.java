package com.gnit.pojo;

public class LoginDO {
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String password) {
		this.pass = pass;
	}
	public String getConfPassword() {
		return confpass;
	}
	public void setConfPassword(String confPassword) {
		this.confpass = confPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public LoginDO(String email, String pass, String confpass, String userType) {
		super();
		this.email = email;
		this.pass = pass;
		this.confpass = confpass;
		this.userType = userType;
	}
	public LoginDO() {
		// TODO Auto-generated constructor stub
	}
	private String email;
	private String pass;
	private String confpass;
	private String userType;
}
