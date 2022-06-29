package com.revature.eval.java.core;

import java.util.HashMap;
import java.util.Map;

public class PersonalTesting {

	public static void main(String[] args) {
		Map<String, Integer> words = new HashMap<String, Integer>();
		
		String string = "one fish two fish red fish blue fish";
		String[] strArray = string.split(" ");
		
		for (int i = 0; i < strArray.length; i++ ){
			int count = 1;
			for (int j = i+1; j < strArray.length; j++) {
				if (strArray[i].equals(strArray[j])) {
					strArray[j] = "0";
					count++;
				}
			}
			if(strArray[i]!="0") {
				words.put(strArray[i], count);
				count=1;
			}
		         System.out.println(strArray[i]+"--"+count); //Printing the word along with count
		         
			
		}
	}
}
