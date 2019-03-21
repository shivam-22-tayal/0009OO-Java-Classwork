package com.assignment1.java;

public class EmployeeManager {
	
	static int ind;
	
public static void addEmp() {
		
	}
	public static void main(String[] args) {
		// Declaring employee array
		Employee empList[] = new Employee[50];
		
		//Adding employees to employee array
		empList[0] = new Employee("shivam",22,"fsd",35000,"Male");
		empList[1] = new Employee("rohit",28,"sales",37000,"Male");
		empList[2] = new Employee("priya",22,"atnt",45000,"Female");
		empList[3] = new Employee("Shivani",22,"FSD",45000,"Female");
		
	
		System.out.println("ID\tName\tAge\tGender\tDepartment\tSalary");
		for(Employee emp : empList) {
			if(emp == null)
				continue;
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getGender()+"\t"+emp.getDepartment()+"\t\t"+emp.getSalary());
		}
		
	
		for(int i = 0; i<empList.length;i++) {
			if(empList[i] != null && empList[i].getId() == 2)
				empList[i] = null;
		}
		
		
		System.out.println("After Delete");
		for(Employee emp : empList) {
			if(emp == null)
				continue;
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getGender()+"\t"+emp.getDepartment()+"\t\t"+emp.getSalary());
		}
		
		
		for(int i = 0; i<empList.length;i++) {
			if(empList[i] != null && empList[i].getId() == 1)
				empList[i].setName("Harshit");;
		}
		
		
				System.out.println("After Update");
				for(Employee emp : empList) {
					if(emp == null)
						continue;
					System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getGender()+"\t"+emp.getDepartment()+"\t\t"+emp.getSalary());
				}
	}
	
		
			
	

}
