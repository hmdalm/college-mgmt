package com.gnit.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gnit.database.DataBase;
import com.gnit.pojo.TeacherDO;

public class TeacherDAO {
	public boolean createTeacher(TeacherDO tdo) {
		DataBase db = new DataBase();
		Connection connect = db.getDbConnection();
		String insert = "insert into Teacher (teacher_id ,first_name,middle_name,last_name,dob,department,qualification,address ,email ,mobile  ) values ("
				+ tdo.getTeacherId() + ",'" + tdo.getFirstName() + "','" + tdo.getMiddleName() + "','"
				+ tdo.getLastName() + "','" + tdo.getDob() + "','" + tdo.getDepartment() + "','"
				+ tdo.getQualification() + "','" + tdo.getAddress() + "','" + tdo.getEmail() + "','" + tdo.getMobile()
				+ "')";
		System.out.println(insert);

		try {
			Statement st = connect.createStatement();
			int query = st.executeUpdate(insert);
			System.out.println(query);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getTeacherlogin(String email) {
		DataBase db = new DataBase();
		Connection conn = db.getDbConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Teacher where email='" + email + "'");
			if (rs.next()) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

	public TeacherDO getTeacher(String email) {
		DataBase db = new DataBase();
		Connection connect = db.getDbConnection();
		TeacherDO tdo = null;
		try {
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery("select * from Teacher where email ='" + email + "'");
			while (result.next()) {
				tdo = new TeacherDO();
				tdo.setTeacherId(result.getInt("teacher_id"));
				tdo.setFirstName(result.getString("first_name"));
				tdo.setMiddleName(result.getString("middle_name"));
				tdo.setLastName(result.getString("last_name"));
				tdo.setDob(result.getString("dob"));
				tdo.setDepartment(result.getString("department"));
				tdo.setQualification(result.getString("qualification"));
				tdo.setAddress(result.getString("address"));

				tdo.setEmail(result.getString("email"));
				tdo.setMobile(result.getString("mobile"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return tdo;

	}

	public TeacherDO updateTeacher(TeacherDO tdo) {

		DataBase db = new DataBase();
		Connection connect = db.getDbConnection();
		String update = "update Teacher set first_name='" + tdo.getFirstName() + "'," + "middle_name='"
				+ tdo.getMiddleName() + "'," + "last_name='" + tdo.getLastName() + "'," + "dob='" + tdo.getDob()
				+ "'," + "department='" + tdo.getDepartment() + "'," + "qualification='" + tdo.getQualification()
				+ "'," + "address='" + tdo.getAddress() + "'," + "email='" + tdo.getEmail() + "'," + "mobile='"
				+ tdo.getMobile() + "'" + " where email='" + tdo.getEmail() +"'" ;
		System.out.println(update);

		try {
			Statement st = connect.createStatement();
			int query = st.executeUpdate(update);
			System.out.println(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tdo;

	}

}
