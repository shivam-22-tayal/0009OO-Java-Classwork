package com.example.core.java;

public class EmployeeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("********************Employee Details********************");
		System.out.println();
		System.out.println("ID\tName\tAge\tGender\tDepartment\tSalary");
		System.out.println("--------------------------------------------------------");
		Employee mathew = new Employee("Mathew",23,"Male","Sales\t",35000);
		mathew.setSalary(45000);
		mathew.getDetails();
		mathew.appraise();
		
		Employee daniel = new Employee("Daniel",27,"Male","Development",55000);
		daniel.getDetails();
			
		System.out.println();
		System.out.println("********************Contractor Details********************");
		System.out.println();
		System.out.println("ID\tName\tAge\tGender\tDuration");
		System.out.println("--------------------------------------------------------");
		Contractor james = new Contractor("James",28,"Male",6);
		james.getDetails();
	}
}
