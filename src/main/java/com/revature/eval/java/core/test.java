package com.revature.eval.java.core;

import java.util.Scanner;

public class test {

	public static String askForInput()
	{
		Scanner scan = new Scanner(System.in);
		
		return scan.next();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		String str = askForInput();
		
		System.out.println(str);
	}

}
