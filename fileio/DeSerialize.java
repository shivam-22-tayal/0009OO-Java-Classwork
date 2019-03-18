package com.example.java.fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;


public class DeSerialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer,String> map = null;
		 try {
	         FileInputStream fileIn = new FileInputStream("D:\\input.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         map = (HashMap) in.readObject();
	         in.close();
	         fileIn.close();
	         System.out.println("Data DeSerialized");
	      } catch (Exception e) {
	        
	      }

	}

}
