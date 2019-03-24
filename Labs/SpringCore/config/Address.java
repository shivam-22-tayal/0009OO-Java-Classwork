package com.example.spring.core.config;

public class Address {

	String city;
	int pin;
	String country;
	
	Address(){
		
	}
	
	Address(String city, int pin, String country){
		this.city = city;
		this.pin = pin;
		this.country = country;
	}
}
