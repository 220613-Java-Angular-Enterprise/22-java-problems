package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalTesting {

	public static void main(String[] args) {
		System.out.println(calculatePrimeFactorsOf(2L));
	}
	
public static List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> primeList= new ArrayList<Long>();
		int flag = 1;
		for (long i = 2; i <= l; i++) {
			for (long j = 2; j <= i/2; j++) {
				if (i % j == 0 ) {
					flag = 0;
					break;
				}
			}
			if (flag == 1) {
				primeList.add(i);
			}
		}
		return primeList;
	}
}
