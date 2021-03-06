package com.example.java.LambdaExp;

import java.util.function.Consumer;
import java.util.function.BiFunction;

public class LambdaExp {

	 public static void main(String args[]) {
		   LambdaExp lamExp = new LambdaExp();
			
		   BiFunction<Integer,Integer,Integer> add= (Integer a, Integer b) -> a+b;
		   BiFunction<Integer,Integer,Integer> sub= (Integer a, Integer b) -> a-b;
		   BiFunction<Integer,Integer,Integer> mul= (Integer a, Integer b) -> a*b;
		   BiFunction<Integer,Integer,Integer> div= (Integer a, Integer b) -> a/b;
		   
		   System.out.println("10 + 5 = " + lamExp.operate(10,5,add));
		   System.out.println("10 - 5 = " + lamExp.operate(10,5,sub));
		   System.out.println("10 * 5 = " + lamExp.operate(10,5,mul));
		   System.out.println("10 / 5 = " + lamExp.operate(10,5,div));
	      //with type declaration
	 /* MathOperation addition = (int a, int b) -> a + b;
		
	  //with out type declaration
	  MathOperation subtraction = (a, b) -> a - b;
		
	  //with return statement along with curly braces
	  MathOperation multiplication = (int a, int b) -> { return a * b; };
		
	  //without return statement and without curly braces
	  MathOperation division = (int a, int b) -> a / b;
		
	  System.out.println("10 + 5 = " + lamExp.operate(10, 5, addition));
	  System.out.println("10 - 5 = " + lamExp.operate(10, 5, subtraction));
	  System.out.println("10 x 5 = " + lamExp.operate(10, 5, multiplication));
	  System.out.println("10 / 5 = " + lamExp.operate(10, 5, division));*/
	      
	  
	      //without parenthesis and using Consumer functional interface
	  Consumer<String> greetService1 = message ->
	  System.out.println("Hello " + message);
		
	  //with parenthesis and using custom functional interface
	  GreetingService greetService2 = (message) ->
	  System.out.println("Hello " + message);
		
	  greetService1.accept("Mahesh");
	  greetService2.sayMessage("Suresh");      
		      
		   }
			
		   interface MathOperation {
		      int operation(int a, int b);
		   }
			
		   
		   interface GreetingService {
		      void sayMessage(String message);
		   }
			
		   
		   private int operate(int a, int b, BiFunction<Integer,Integer,Integer> function) {
		      return function.apply(a, b);
		   }

	
}
