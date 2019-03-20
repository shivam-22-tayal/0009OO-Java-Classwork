package com.example.java.fileio;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Dusayanta");
		map.put(2, "Satyam");
		map.put(3, "Shivam");
		map.put(4, "Molly");
		
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\DusayantaPrasad\\Desktop\\output.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
			out.writeObject(map);
			out.close();
			fout.close();
			
			System.out.printf("Serialized data is saved");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
