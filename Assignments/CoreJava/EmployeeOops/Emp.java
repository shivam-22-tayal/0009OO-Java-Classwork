package com.examples.core.oops;

public class Emp extends Person {
static int id;
String name;
int age;
String department;
int salary;

public Emp(String name,int age, String department,int salary , String gender){
	super(name, gender,age);
	//this.id=id;
	
	this.department=department;
	this.salary=salary;
	id++;
}
public void getEmp() {
	System.out.println("Employee Details");
	System.out.println("ID\tName\tAge\tDepartment\tSalary\tGender");
	System.out.println(id+"\t"+this.getName()+"\t"+this.getAge()+"\t"+department+"\t\t"+salary+"\t"+this.getGender());
}
}