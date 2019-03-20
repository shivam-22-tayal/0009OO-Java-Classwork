package com.example.core.java;

public class SwapNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first = 5, second = 6;
		System.out.println("Before swapping: first = "+first+" and second = "+second);
		
		first = first + second;
		second = first - second;
		first = first - second;
		
		System.out.println("After swapping: first = "+first+" and second = "+second);
		
		float a = 0.7f;
		if(a == 0.7) {
			System.out.println("xyz");
		}
		else
			System.out.println("abc");
	}
}
