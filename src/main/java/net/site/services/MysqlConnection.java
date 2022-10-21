package net.site.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {

	public static Connection getConnection() throws Exception {
		
		String dbUrl = "jdbc:mysql://localhost:3306/bddsite";
		String usrn = "root";
		String pswd = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(dbUrl, usrn, pswd);
		
		return con;
		
	}
}
