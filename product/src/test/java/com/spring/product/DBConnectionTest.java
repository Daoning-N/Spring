package com.spring.product;

import java.sql.DriverManager;
import java.sql.Connection;
import org.junit.Test;



public class DBConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/spring";
	private static final String USER = "sample";
	private static final String PW = "1234";

	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
