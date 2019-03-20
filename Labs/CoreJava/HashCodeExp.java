package com.example.java.collection;
import java.util.*;
public class HashCodeExp {
	


	public static void main (String args[]) {
		
	
		
		HashSet set=new HashSet();
			set.add(1);
			set.add("Joey");
			set.add("OnePlus 6T");
			set.add("Male");
			set.add("Joey");
		
			for (Object hash: set) {
				System.out.print(hash);
			}
		
		
	}
}
