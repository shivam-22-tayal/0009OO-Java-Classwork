package com.assignment2.java;

import java.util.*;

public class EmployeeManager {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EmployeeService service = new EmployeeService();
		
		try {
		int input = 0;
		do {
			int exit = -1;
			System.out.println();
			System.out.println("****EMPLOYEE MANAGEMENT****");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employees");
			System.out.println("3. Find Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Sort Employee");
			//System.out.println("7.\tPrint Statistics");
			System.out.println("0.\tExit ");
			System.out.println("Enter option: ");
			input = service.acceptValidInteger();
			if(input == -1)
				return;
			System.out.println();
			switch(input) {
			case 0: exit = 1;
				break;
			case 1:
				service.addEmp();
				break;
			case 2:
				service.viewEmp();
				break;
			case 3:
				service.findEmp();
				break;
			case 4:
				service.updateEmp();
				break;
			case 5:
				service.deleteEmp();
				break;
			case 6:
				service.sortEmp();
				break;
			/*case 7:
				service.printStatistics();
				break;*/
			default: System.err.println("Invalid Selection");
			}
			if(exit == 1)
				break;
		} while (input != 0);
		}catch(Exception e) {
			System.out.println("Sorry!! Executiuon went Wrong");
			System.out.println(e.getMessage());
		}
		
	}
}
