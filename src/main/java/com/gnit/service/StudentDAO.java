package com.gnit.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gnit.database.DataBase;
import com.gnit.pojo.StudentDO;

public class StudentDAO {

	public boolean createStudent(StudentDO sdo) {
		DataBase db = new DataBase();
		Connection conn = db.getDbConnection();
		String qry = "insert into Student (student_id ,first_name,middle_name,last_name,dob,roll_no,\r\n"
				+ "course ,address ,email ,mobile  ) values(" + sdo.getStudentId() + ",'" + sdo.getFirstName() + "','"
				+ sdo.getMiddleName() + "','" + sdo.getLastName() + "','" + sdo.getDob() + "','" + sdo.getRollNo()
				+ "','" + sdo.getCourse() + "','" + sdo.getAddress() + "','" + sdo.getEmail() + "','" + sdo.getMobile()
				+ "')";
		System.out.println(qry);
		try {
			Statement statement = conn.createStatement();
			int exeqry = statement.executeUpdate(qry);
			System.out.println(exeqry);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean getSignupDetail(String email) {
		DataBase db = new DataBase();
		Connection con = db.getDbConnection();
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Student where email='" + email + "'");

			if (result.next()) {

				return true;

			} else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public StudentDO getStudent(String email) {
		DataBase db = new DataBase();
		Connection connect = db.getDbConnection();
		StudentDO std = null;
		try {
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery("select * from Student where email ='" + email + "'");
			while (result.next()) {
				std = new StudentDO();
				std.setStudentId(result.getInt("student_id"));
				std.setFirstName(result.getString("first_name"));
				std.setMiddleName(result.getString("middle_name"));
				std.setLastName(result.getString("last_name"));
				std.setDob(result.getString("dob"));
				std.setRollNo(result.getString("roll_no"));
				std.setCourse(result.getString("course"));
				std.setAddress(result.getString("address"));
				std.setEmail(result.getString("email"));
				std.setMobile(result.getString("mobile"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return std;

	}

	public StudentDO getStudent(String email, String pass) {
		DataBase db = new DataBase();
		Connection connect = db.getDbConnection();
		StudentDO std = null;
		try {
			Statement statement = connect.createStatement();
			String s = "select * from login where email='" + email + "' and pass ='" + pass + "'";

			ResultSet result = statement.executeQuery(s);
			System.out.println(s);
			while (result.next()) {
				std = new StudentDO();
				std.setStudentId(result.getInt("student_id"));
				std.setFirstName(result.getString("first_name"));
				std.setMiddleName(result.getString("middle_name"));
				std.setLastName(result.getString("last_name"));
				std.setDob(result.getString("dob"));
				std.setRollNo(result.getString("roll_no"));
				std.setCourse(result.getString("course"));
				std.setAddress(result.getString("address"));
				std.setEmail(result.getString("email"));
				std.setMobile(result.getString("mobile"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return std;

	}

	public StudentDO getStudent(int studentId, String firstName, String middleName, String lastName, String dob,
			String rollNo, String course, String address, String email, String mobile, String password,
			String conPassword) {
		DataBase db = new DataBase();
		Connection connect = db.getDbConnection();
		StudentDO std = null;
		try {
			Statement statement = connect.createStatement();
			String s = "select * from Student";

			ResultSet result = statement.executeQuery(s);
			System.out.println(s);
			while (result.next()) {
				std = new StudentDO();
				std.setStudentId(result.getInt("student_id"));
				std.setFirstName(result.getString("first_name"));
				std.setMiddleName(result.getString("middle_name"));
				std.setLastName(result.getString("last_name"));
				std.setDob(result.getString("dob"));
				std.setRollNo(result.getString("roll_no"));
				std.setCourse(result.getString("course"));
				std.setAddress(result.getString("address"));
				std.setEmail(result.getString("email"));
				std.setMobile(result.getString("mobile"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return std;

	}
	public StudentDO updateStudent(StudentDO stdo) {

		DataBase db = new DataBase();
		Connection connect = db.getDbConnection();
		String update = "update Student set first_name='" + stdo.getFirstName() + "'," + "middle_name='"
				+ stdo.getMiddleName() + "'," + "last_name='" + stdo.getLastName() + "'," + "dob='" + stdo.getDob()
				+ "'," + "roll_no='" + stdo.getRollNo()+ "'," + "course='" + stdo.getCourse() 
				+ "'," + "address='" + stdo.getAddress() + "'," + "email='" + stdo.getEmail() + "'," + "mobile='"
				+ stdo.getMobile() + "'" + " where email='" + stdo.getEmail() + "'";
		System.out.println(update);

		try {
			Statement st = connect.createStatement();
			int query = st.executeUpdate(update);
			System.out.println(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stdo;

	}
}
