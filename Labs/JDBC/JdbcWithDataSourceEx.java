package com.examples.java.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JdbcWithDataSourceEx {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setDatabaseName("jdbctraining");
			dataSource.setUser("training");
			dataSource.setPassword("training");
			dataSource.setServerName("localhost");			

			
			System.out.println("Connecting to database...");			
			conn = dataSource.getConnection();

			
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql1, sql2;
			sql1 = "SELECT id, name, age, designation FROM employee";
                 //	sql1 = "SELECT id, name, age FROM employee WHERE age >= 35 AND department='Admin' ORDER BY name";
			sql2 = "UPDATE employee SET designation=? WHERE id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, "Manager");
			pstmt.setInt(2, 1);

                 //	boolean status = stmt.execute(sql2);
			boolean status = pstmt.execute();
			System.out.println("Update status: " + status);
			ResultSet rs = stmt.executeQuery(sql1);

			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");

				
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", Name: " + name);
				System.out.print(", Designation: " + designation);

				System.out.println();
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			
			se.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} 
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 
		System.out.println("Goodbye!");
	}
}