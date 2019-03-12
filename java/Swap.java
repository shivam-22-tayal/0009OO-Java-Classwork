package com.examples.core.java;

import java.util.Scanner;

class Swap
{
   public static void main(String args[])
   {
      int x, y, temp;
      System.out.println("Enter x and y");
      Scanner in = new Scanner(System.in);
     
      x = in.nextInt();
      y = in.nextInt();
     
      System.out.println("Before Swapping\nx = "+x+"\ny = "+y);
     
     /* temp = x;
      x = y;
      y = temp;*/
      
      y=x+y;
      x=y-x;
      y=y-x;
     
      System.out.println("After Swapping\nx = "+x+"\ny = "+y);
   }
}