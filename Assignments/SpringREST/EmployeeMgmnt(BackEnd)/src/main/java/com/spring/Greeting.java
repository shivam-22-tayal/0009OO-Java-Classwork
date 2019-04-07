package com.spring;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}