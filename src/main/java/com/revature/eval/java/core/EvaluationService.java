// Steven Ray Coronel
// Submission, comment edits pending.

package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import javax.net.ssl.SSLEngineResult.HandshakeStatus;

public class EvaluationService {

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value. 
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
			// If our input is valid (non-negative)...
			if(0 <= kilometersPerHour)
			{	
				// then Convert the Kilometers per Hour to Miles per Hour
				//    and return the rounded result.(conversion value is taken from google)
				return Math.round(kilometersPerHour * 0.621);
			}
			// Otherwise, the input is invalid and we return -1 to communicate this.
			return -1;
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			
			// If our input is valid (non-negative)...
			if(0 <= kilometersPerHour)	
			{	
				// then Convert the Kilometers per Hour to Miles per Hour
				//    and communicate the rounded result.(conversion value is taken from google)
				return kilometersPerHour + " km/h = " + Math.round(kilometersPerHour * 0.621) + " mi/h";
			}
			// Otherwise, we will communicate that it is invalid.
			else 
			{
				return "Invalid Value";
			}

		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int XX) 
	{
		// a Megabyte should be 1024 KiloBytes right?
		
		// If the input is valid (non-negative)
		if(0 <= XX)
		{
			return XX + " KB = " + XX/1024 + " MB and " + XX%1024 + " KB";
	
		}
		// Otherwise, communicate the input is invalid.
		else 
		{
			return "Invalid Value";
		}
		
		
	}
	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	// CLARIFICATION REQUIRED
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) 
	{

		// When saying after 10 hours, are we taking 10 hours:0 minutes: 1 second 
		//   into account? Are we only considering once the new hour comes up?
		
		// If the hour is valid (non-negative up to 23) and the dog is barking...
		if( (0<=hourOfDay && hourOfDay  <=23) && isBarking == true)
		{
			// then return true if The hour is before 8 hours or after 22 hours.
			if(hourOfDay <= 7 || 23 == hourOfDay)
			{
				return true;
			}
			// Otherwise, return false.
			else 
			{
			
				return false;
				
			}
		}
		// Otherwise, return false.
		else 
		{
			return false;
		}
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) 
	{
		// Format double type input using String and compare them. String.equals will 
		//    take care of handling the resulting true or false value.
		return String.format("%.3f", firstNum).equals(String.format("%.3f", secondNum));
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) 
		{
			// We are hoping for one of the 3 inputs are within a range of 13-19.		
			
			// Now we need to check:
			
			// If only 1 of the inputs are a teen...
			if((isTeen(x)^isTeen(y))^isTeen(z))
			{
				// then we return true.
				return true;
			}
			// and otherwise return false.
			else
			{
				return false;
			}
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {
			return 13 <= number && number <=19;
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	// ************This is initially return type String
	public String printYearsAndDays(long minutes) {
		if(0 <= minutes)
		{
			return minutes + " min = " + (minutes / 525600)
					+ " y and " +  (minutes%525600)/1440 
					+ " d";
					
		}
		else 
		{
			return "Invalid Value";	
		}
	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {

			switch (number) {
			case 0 :return "ZERO";
			case 1 :return "ONE";
			case 2 :return "TWO";
			case 3 :return "THREE";
			case 4 :return "FOUR";
			case 5 :return "FIVE";
			case 6 :return "SIX";
			case 7 :return "SEVEN";
			case 8 :return "EIGHT";
			case 9 :return "NINE";
			default:return "OTHER";
			}
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {

		if(first < 10 || second < 10)
		{
			return -1;
		}
		
		
		int largeNum;
		int smallNum;
		
		if(first < second)
		{
			smallNum = first;
			largeNum = second;
		}
		else 
		{
			smallNum = second;
			largeNum = first;
		}

		
				
		for(int divisor = 1; divisor <= smallNum; divisor++)
		{
			if(smallNum%divisor == 0)
			{
				if(largeNum%(smallNum/divisor) == 0)
				{
					return smallNum/divisor;
				}
			}
				
		}
		
		return -1;
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		if(num<0)
		{
			return -1;
		}
		
		String numString = String.valueOf(num);
		
		int firstDigit = Character.getNumericValue(numString.charAt(numString.length()-1));
		int lastDigit = Character.getNumericValue(numString.charAt(0));
		

		return (firstDigit + lastDigit);
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {
		String result = "";
		for(int i = string.length()-1; 0<=i; i--)
		{
			result += string.charAt(i);
		}
		return result;
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		
		String result;
		if(phrase.charAt(0)!= ' ')
		{
			result = phrase.charAt(0) + "";
		}
		else 
		{
			result = "";
		}
		
		boolean foundSpace = false;
		
		for(int i=0; i<phrase.length(); i++)
		{
			if(foundSpace == true)
			{
				result += phrase.charAt(i);
				foundSpace = false;
			}
			else if(phrase.charAt(i)== ' '||phrase.charAt(i)== '-')
			{
				foundSpace= true;
			}
		}
		return result.toUpperCase();
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne == sideTwo && sideTwo==sideThree)
			{
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			if((sideOne==sideTwo || sideTwo==sideThree) || sideOne==sideThree)
			{
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			if((sideOne!=sideTwo && sideTwo!=sideThree) && sideOne!=sideThree)
			{
				return true;
			}
			return false;
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {

		int score = 0;
		
		string = string.toUpperCase();
		
		for(int i=0; i <string.length();i++)
		{
			switch(string.charAt(i))
			{
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
				case 'L':
				case 'N':
				case 'R':
				case 'S':
				case 'T':
							score++;
							break;
				case 'D':
				case 'G':
							score+=2;
							break;
				case 'B':
				case 'C':
				case 'M':
				case 'P':
							score+=3;
							break;
				case 'F':
				case 'H':
				case 'V':
				case 'W':
				case 'Y':
							score+=4;
							break;
				case 'K':
							score+=5;
							break;
				case 'J':
				case 'X':
							score+=8;
							break;
				case 'Q':
				case 'Z':
							score+=10;
							break;
				default:	break;
			}
		}
		return score;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String result = "";

		int index = 0;
		if(string.charAt(index) == '+')
		{
			index = 2;
		}
		else if(string.charAt(index) == '1')
		{
			index=1;
		}
				
		int digit = 0;
		char currentChar;
		
		while(digit <10)
		{
			currentChar = string.charAt(index);
			
			if(digit == 0 || digit == 3)
			{
				if(2 <= Character.getNumericValue(currentChar) 
						&& Character.getNumericValue(currentChar) <=9)
				{
					result+= currentChar;
					digit++;
				}
			}
			else
			{
				if(0 <= Character.getNumericValue(currentChar) 
						&& Character.getNumericValue(currentChar) <=9)
				{
					result+= currentChar;
					digit++;
				}
			}
		
			
			index++;
			
		}
		return result;
		
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {		
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		String parsedString[] = string.split("\n*[^A-Za-z]\n*");
		
		for(String str : parsedString)
		{
			if(!result.containsKey(str))
			{
				result.put(str, 1);
			}
			else 
			{
				result.put(str, result.get(str)+1);
			}
		}
		
		return result;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		boolean result = false;
		
		String str = String.valueOf(input);
		
		int digitCount = str.length();
		
		double total = 0;
		for(int i =0; i<str.length(); i++)
		{
			total += Math.pow(Character.getNumericValue(str.charAt(i)), digitCount);
		}
		
		if(total == input)
		{
			result = true;
		}
		
		return result;
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> result = new ArrayList<Long>();
		
		long currentValue = l;
		boolean finished = false;
		
		while(!finished)
		{
			if(currentValue%2 == 0)
			{
				result.add((long)2);
				currentValue/=2;
			}
			else if(currentValue%3 == 0)
			{
				result.add((long)3);
				currentValue/=3;
			}
			else if(currentValue%5 == 0)
			{
				result.add((long)5);
				currentValue/=5;
			}
			else if(currentValue%7 == 0)
			{
				result.add((long)7);
				currentValue/=7;
			}
			else if(currentValue%11 == 0)
			{
				result.add((long)11);
				currentValue/=11;
			}
			else 
			{
				finished = true;
			}
		}
		
		return result;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		if(k==0)
		{
			return -1;
		}
		if(k== 1)
		{
			return 2;
		}
		if(k==2)
		{
			return 3;
		}
		int prime = 1; // initial value
		int primeCount = 2;
		
		boolean checkingPrime;
		int currentTestNumber = 3;
		int possibleMultiple;
		

		while(primeCount<k)
		{
			checkingPrime = true;
			currentTestNumber=prime+2;
			possibleMultiple=3;
			
			while(checkingPrime && possibleMultiple<currentTestNumber/2)
			{
				if(currentTestNumber%possibleMultiple == 0) 
				{
					checkingPrime = false;
				}
				possibleMultiple+=2;
			}
			
			if(checkingPrime==true)
			{
				prime = currentTestNumber;
				primeCount++;
			}
		}
		
		
		return prime;
	}

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		
		Set<Character> checkList = new HashSet<Character>(Arrays.asList('a', 'b','c','d','e', 'f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
		string = string.toLowerCase();
		for(int i = 0; i<string.length(); i++)
		{
			if(checkList.contains(string.charAt(i)))
			{
				checkList.remove(string.charAt(i));
			}
				
		}
		if(checkList.size()==0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		// I'm kind of confused what is desired with the set being already provided?
		
		
		return 0;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		Random random = new Random();
		int numbers[] = {random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1};
		return numbers;
	}
	
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		Random rand = new Random();
		
		return rand.nextInt(y-x+1) + x;
			
		
	}
}
