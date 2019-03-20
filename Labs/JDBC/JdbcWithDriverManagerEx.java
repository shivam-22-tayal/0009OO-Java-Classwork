package com.examples.java.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcWithDriverManagerEx {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	
	static final String USER = "root"; 
	static final String PASS = "pass@word1"; 

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connection estabilished: " + conn);

			
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

	
           //			String insertQuery = "INSERT INTO employee (name, age, designation, department, country) VALUES ('Anil', 30, 'Developer', 'Admin', 'India')";
             //			boolean status = stmt.execute(insertQuery);
           //			int insertCount = stmt.executeUpdate(insertQuery);
             //			System.out.println("Employee inserted " + insertCount);

			
			String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
			pstmt.setString(1, "Mathew");
			pstmt.setInt(2, 30);
			pstmt.setString(3, "Lead");
			pstmt.setString(4, "IT");
			pstmt.setString(5, "India");			
			int insertCount = pstmt.executeUpdate();
			System.out.println(insertCount + " Employee(s) inserted");
			
			
			String updateQuery = "UPDATE employee SET designation = ? WHERE id = ?";
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, "Software Engineer");
			pstmt.setInt(2, 1);			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " Employee(s) updated");
			
			
			String deleteQuery = "DELETE FROM employee WHERE id = ?";
			pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, 2);			
			int deleteCount = pstmt.executeUpdate();
			System.out.println(deleteCount + " Employee(s) updated");			

			String selectQuery = "SELECT * FROM employee";
			rs = stmt.executeQuery(selectQuery);

			
			
			System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Age", "Name", "Designation", "Department",
					"Country");
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				
				System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name, designation, department, country);
			}

		} catch (SQLException se) {
			
			se.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException se2) {
			}
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