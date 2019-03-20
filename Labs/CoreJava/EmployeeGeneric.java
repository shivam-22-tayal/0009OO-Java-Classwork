package com.example.java.generics;


public class EmployeeGeneric<T extends Number> {
	
	private T salary;
	
	public EmployeeGeneric(T salary) {
		this.salary=salary; 
		
	}   

	public T getSalary() {
		return salary;
	}

	public void setSalary(T salary) {
		this.salary = salary;
	}
	
		public static void main (String args[]) {
			
			EmployeeGeneric<Number> empgen=new EmployeeGeneric<>(769.69);
			
			System.out.println( empgen.getSalary());
			
		
		}
	
	}
