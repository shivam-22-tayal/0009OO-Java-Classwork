package com.example.spring.core.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
	
	@Bean
	public Employee employee() {
		return new Employee(1, "Jason", address(),dob());
	}
	
	@Bean
	public Address address() {
		return new Address("Kolkata",711103,"India");
	}
	
	@Bean
	public LocalDate dob() {
		LocalDate date = LocalDate.parse("1996-07-23");
		return date;
	}
}
