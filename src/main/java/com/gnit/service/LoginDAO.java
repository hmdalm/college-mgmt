package com.gnit.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gnit.database.DataBase;
import com.gnit.pojo.LoginDO;

public class LoginDAO {
	public boolean createLogin(LoginDO ldo) {
		DataBase db = new DataBase();
		Connection conn = db.getDbConnection();
		String qry = "insert into Login (email ,pass ,conf_pass,user_type) values('" + ldo.getEmail() + "','"
				+ ldo.getPassword() + "','" + ldo.getConfPassword() + "','" + ldo.getUserType() + "')";
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

	public LoginDO getUser(String email, String pass) {
		DataBase db = new DataBase();
		Connection connect = db.getDbConnection();
		LoginDO ldo = null;
		try {
			Statement statement = connect.createStatement();
			String query = "select * from login where email='" + email + "' and pass ='" + pass + "'";

			ResultSet result = statement.executeQuery(query);
			System.out.println(query);
			while (result.next()) {
				ldo = new LoginDO();
				ldo.setEmail(result.getString("email"));
				ldo.setPassword(result.getString("pass"));
				ldo.setUserType(result.getString("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ldo;
	}
}
