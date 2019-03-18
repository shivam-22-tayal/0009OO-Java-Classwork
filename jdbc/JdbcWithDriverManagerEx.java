package com.example.java.jdbc;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcWithDriverManagerEx {

	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/jdbctraining";
		//static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";// other way round

		// Database credentials
		static final String USER = "root";
		static final String PASS = "pass@word1";

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection established: " +conn);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			//String insertQuery="INSERT INTO employee (name, age, designation, department,country) VALUES ('Shivam', 22, 'ASE', 'FSD', 'India')";
			//boolean status= stmt.execute(insertQuery);
			//System.out.println("Employee Inserted" + status);
			
			//String insertQuery1="INSERT INTO employee (name, age, designation, department,country) VALUES ('Saptrishi', 38, 'ASE', 'SAP', 'India')";
			//int res= stmt.executeUpdate(insertQuery1);
			//System.out.println("Employee Inserted" + res);
			
			
			PreparedStatement pstmt;
			String insertQueryforPreparedStatement="INSERT INTO employee (name, age, designation, department,country) VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(insertQueryforPreparedStatement);
		    pstmt.setString(1, "Somoy");
		    pstmt.setInt(2, 40);
		    pstmt.setString(3, "AGM");
		    pstmt.setString(4, "Admin");
		    pstmt.setString(5, "INDIA");
             
		    int insertCount = pstmt.executeUpdate();
			System.out.println(insertCount + " Employee(s) inserted");
			
             
			String sql1, sql2;
			sql1 = "SELECT id, name, age, designation, department, country FROM employee";
			//System.out.println(sql1);
      		// sql1 = "SELECT id, name, age FROM employee WHERE age >= 35 AND department='Admin' ORDER BY name";
			
			sql2 = "UPDATE employee SET designation=? WHERE id=?";

			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, "ASM");
			pstmt.setInt(2, 5);
			
			// DELETE query
			String deleteQuery = "DELETE FROM employee WHERE id = ?";
			pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, 7);			
			int deleteCount = pstmt.executeUpdate();
			System.out.println(deleteCount + " Employee(s) updated");

//			boolean status = stmt.execute(sql2);
			boolean status = pstmt.execute();
			System.out.println("Update status: " + status);
			ResultSet rs = stmt.executeQuery(sql1);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String country = rs.getString("country");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", Name: " + name);
				System.out.print(", Designation: " + designation);
				System.out.print(", Country: " + country);

				System.out.println();
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		
	}

}
