package com.example.java.collection;
import java.util.Vector;
import java.lang.*;
public class CollectionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Vector countries=new  Vector();

//countries.add("India");
//countries.add("USA");
//countries.add("China");

//another way
for(int i=0;i<500;i++) {
	countries.add("India"+i);
}
//Differnt Operations
System.out.println(countries.size());
System.out.println(countries.get(1));

//How to print through loop
for(Object item:countries)
{
System.out.println(item);	
}
//How to remove
countries.remove(2);
System.out.println(countries.size());
//convert collection object to array




//convert array into collection object
 
	}
}
