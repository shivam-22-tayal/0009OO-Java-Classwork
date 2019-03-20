package com.example.java.date_time;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;



public class LocalDateTime {
	   public static void main(String args[]) {
		   LocalDateTime localDateTimeEx = new LocalDateTime();
	      localDateTimeEx.testLocalDateTime();
	   }
		
	   public void testLocalDateTime() {
		   
		   LocalDate today = LocalDate.now();                          //Today's date
		   Scanner sc=new Scanner(System.in);
		   System.out.println("Enter the DOB: (yyyy-mm-dd)");
		   String dob=sc.nextLine();
		  // LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);  //Birth date
		    LocalDate birthday= LocalDate.parse(dob);
		   Period p = Period.between(birthday, today);
		    
		   //Now access the values as below
		   System.out.println(p.getDays()+"Days\t"+p.getMonths()+"Months\t"+p.getYears()+"Years");
		   
		  // System.out.println(p.getMonths());
		   //System.out.println(p.getYears());
		   
		   //Sir Code from Here!!!!!!!!!!!!!!
	    /*  // Get the current date and time
	      LocalDateTime currentTime = LocalDateTime.now();
	      System.out.println("Current DateTime: " + currentTime);
			
	      LocalDate date1 = currentTime.toLocalDate();
	      System.out.println("date1: " + date1);
			
	      Month month = currentTime.getMonth();
	      int day = currentTime.getDayOfMonth();
	      int seconds = currentTime.getSecond();
			
	      System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);
			
	      LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
	      System.out.println("date2: " + date2);
			
	      //12 december 2014
	      LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
	      System.out.println("date3: " + date3);
			
	      //22 hour 15 minutes
	      LocalTime date4 = LocalTime.of(22, 15);
	      System.out.println("date4: " + date4);
			
	      //parse a string
	      LocalTime date5 = LocalTime.parse("20:15:30");
	      System.out.println("date5: " + date5);*/
	      
	   }
}
