package com.example.java.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOperation {
	
     public static void main(String args[]) {
    	 
    	 try{    
             FileInputStream fin=new FileInputStream("D:\\input.txt");    
             FileOutputStream fout=new FileOutputStream("D:\\testout.txt");    
             int i=0;    
             while((i=fin.read())!=-1){    
              System.out.print((char)i); 
              fout.write(i); 
             }    
              
             fin.close(); 
             fout.close();
           }catch(Exception e)
    	 {
        	   System.out.println(e);
    	 }     
    	
	
}
}
