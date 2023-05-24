package com.gnit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	static final String URL = "jdbc:postgresql://localhost:5432/my_db";
	static final String USER = "postgres";
	static final String PASS = "postgres";

	public Connection getDbConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Connected to the database!");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error while making connection");
		}

	}
}