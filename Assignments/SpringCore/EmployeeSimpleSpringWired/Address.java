package com.examples.spring.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Address {

	String city;
	int pin;
	String country;
	
	Address(String city, int pin, String country){
		this.city = city;
		this.pin = pin;
		this.country= country;
	}
}