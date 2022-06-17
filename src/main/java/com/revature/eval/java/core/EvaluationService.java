package com.revature.eval.java.core;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.css.Counter;

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

		public static long toMilesPerHour(double kph) {
			if (kph < 0)
				return -1;
			return (Math.round(kph * 0.621371));
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
		public static String printConversion(double kph) {
			double mph = kph * 0.621371;
			DecimalFormat dF = new DecimalFormat("#");

			return ((kph) + " km/h = " + dF.format(mph) + " mi/h");
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
	public String printMegaBytesAndKiloBytes(int kB) {
		if (kB < 0)
			return ("Invalid Value");
		Integer mB = kB / 1024;
		return (kB + " KB = " + mB + " MB and " + (kB - mB * 1024) + " KB");
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
	public boolean shouldWakeUp(boolean bork, int hour) {
		if ((hour == 22 && hour == 23) || (hour >= 0 && hour < 8) && bork) {
			return true;
		}
		return false;
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

	public int maxFun(String one, String two) {
		if (one.length() >= two.length())
			return one.length();
		return two.length();
	}

	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		// Step 1: get numbers into a form where they can be compared
		Double num1 = firstNum;
		Double num2 = secondNum;
		String num1s = num1.toString();
		String num2s = num2.toString();
		int p1 = num1s.indexOf('.');
		int p2 = num2s.indexOf('.');
		// Step 2: compare numbers

		if (p1 != p2)
			return false;

		for (int i = 0; i < p1; i++) {
			if (num1s.charAt(i) != num2s.charAt(i))
				return false;
		}
		for (int i = p1 + 1; i < maxFun(num1s, num2s); i++) {
			if (i > p1 + 3)
				break;
			Character a;
			Character b;
			/*
			 * try { a = num1s.charAt(i); } catch(java.lang.StringIndexOutOfBoundsException
			 * e) { a = '0'; } try { b = num2s.charAt(i); }
			 * catch(java.lang.StringIndexOutOfBoundsException e) { b = '0'; }
			 */
			if (i < num1s.length())
				a = num1s.charAt(i);
			else
				a = '0';
			if (i < num2s.length())
				b = num2s.charAt(i);
			else
				b = '0';

			if (a != b)
				return false;
			// if(num1s.charAt(i) != num2s.charAt(i)) return false;
		}

		// "46.13 vs 36.1365"
		// "36.13" vs "36.1365" -- different string lengths could be an issue..

		// Step 3: ->
		return true;
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
		private static boolean isNotTeen(int a) {
			if (a < 13 || a > 19)
				return true;
			return false;
		}

		public static boolean hasTeen(int x, int y, int z) {
			if (isNotTeen(x) && isNotTeen(y) && isNotTeen(z))
				return false;
			return true;
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
	private static int minPYear = 525600;

	public String printYearsAndDays(long mins) {
		if (mins < 0)
			return ("Invalid Value");
		Integer years = (int) (mins / minPYear);
		return ((mins + " min = " + years + " y and " + (int) (mins - years * minPYear) * 365 / minPYear + " d"));
		// return null;
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
		String[] sArr = new String[] { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
		try {
			return (sArr[number]);
		} catch (ArrayIndexOutOfBoundsException e) {
			return ("OTHER");
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
		if (first < 10 || second < 10)
			return -1;
		if (first == second)
			return first;
		boolean max = false;

		if (first > second)
			max = true;

		int gcd = 1;

		for (int i = (max ? second / 2 : first / 2); i > 1; i--) {
			if (first % i == 0 && second % i == 0)
				return (i);
		}

		return gcd;
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
	public int sumFirstAndLastDigit(Integer num) {
		if (num < 0)
			return -1;
		String s = num.toString();
		return (Character.digit(s.charAt(0), 10) + Character.digit(s.charAt(s.length() - 1), 10));
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String s) {
		int len = s.length();
		if (len < 2)
			return (s);
		char[] chAr = new char[len];
		for (int i = 0; i < len; i++) {
			chAr[len - i - 1] = s.charAt(i);
		}
		String b = new String(chAr);
		return (b);

	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		if (phrase.length() < 1)
			return ("");
		char[] chAr = phrase.toCharArray();
		boolean space = true;
		int iter = 0;
		for (int i = 0; i < phrase.length(); i++) {
			char temp = chAr[i];
			if (space) {

				chAr[iter++] = Character.toUpperCase(temp);
				space = false;

			} else {
				if (temp == ' ' || temp == '-' || temp == '_')
					space = true;
			}
		}
		String b = new String(chAr);
		return (b.substring(0, iter));
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
		private int type;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
			this.type = findType();
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

		private int findType() {
			if (sideOne == sideTwo && sideTwo == sideThree)
				return (0);
			if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree)
				return (1);
			return (2);
		}

		public boolean isEquilateral() {
			return (type == 0);
		}

		public boolean isIsosceles() {
			return (type == 1);
		}

		public boolean isScalene() {
			return (type == 2);
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
		if (string.length() == 0)
			return (0);

		char[] lets = new char[] { 'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't', 'd', 'g', 'b', 'c', 'm', 'p', 'f',
				'h', 'v', 'w', 'y', 'k', 'j', 'x', 'q', 'z' };
		byte[] points = new byte[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 8, 8, 10, 10 };
		int[] fin = new int['z' + 1];
		for (int i = 0; i < 26; i++) {
			fin[lets[i]] = points[i];
		}
		int total = 0;

		for (int i = 0; i < string.length(); i++) {
			total += fin[string.toLowerCase().charAt(i)];
		}

		/*
		 * char[] chAr = string.toCharArray(); for(int i = 0; i < string.length();i++) {
		 * for(int j = 0; j < 26; j++) { if(Character.toLowerCase(chAr[i]) == lets[j]) {
		 * total+=points[j]; break; } } }
		 */
		// end bad implementation

		return (total);
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
	 * 
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		// step 1: remove all non numbers
		char[] chAr = string.toCharArray();
		char[] outArr = new char[11];
		int iter = 0;
		IllegalArgumentException e = new IllegalArgumentException();
		for (char c : chAr) {
			if (iter > 10) {

				throw (e);
			}
			int check = Character.getNumericValue(c);
			if (check > -1 && check < 10) {
				outArr[iter++] = c;
			}
		}
		if (iter < 9)
			throw (e);

		// step 2: check for country code, removing if needed
		// step 2b: ignore step 2
		String s = new String(outArr);
		if (outArr[10] != '\u0000')
			if (outArr[0] == 1)
				return (s.substring(1));
			else
				throw (e);
		return (s.substring(0, 10));
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

		Map<String, Integer> map = new HashMap<>();
		for (String s : string.replace(",", " ").replace("\n", " ").split(" ")) {
			if (s.length() > 0) {
				Integer num = map.putIfAbsent(s, 1);
				if (!(num == null)) {
					map.put(s, num + 1);
				}
			}
		}

		// TODO Write an implementation for this method declaration
		return map;
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
		if (input < 10)
			return true;
		char[] chAr = Integer.toString(input).toCharArray();
		int len = chAr.length;
		int num = 0;
		int ret = 0;
		int temp = 0;
		for (int i = 0; i < len; i++) {
			temp = Character.digit(chAr[i], 10);
			num = temp;
			// System.out.println(temp);
			for (int j = 0; j < len - 1; j++) {
				num *= temp;
			}
			// System.out.println(num);
			ret += num;
		}
		// System.out.println("input: " + input + " output: " + ret);
		return (ret == input);
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	private static long lastIter;
	public static List<Long> calculatePrimeFactorsOf(long l) {
		
		LinkedList<Long> ans = new LinkedList<>();
		lastIter = 3L;
		int counter = 0;
		while(l%2 == 0) {
			l /= 2;
			counter++;
		}
		if(l > 2) {
			calPrime(ans,l);
		}
		for(int i = 0; i < counter; i++) {
			ans.addFirst(2L);
		}
		
		return(ans);
		
	}
	
	private static void calPrime(LinkedList<Long> list,long l) {
		//step 1: find the smallest factor of l, div

		long div = 3;
		boolean found = false;
	
		if(l > 3) {
			for(long i = lastIter; i <= l/2; i+=2) {
				//if(lastIter > 2 && (i & 1) == 0) i++;
				if(l%i == 0) {
					div = i; lastIter = i; found = true; break;
				}
			}
		
		//step 2: call self on l / div unless l is prime (div not found)
			if(found) {
				calPrime(list,l/div);
			}
			
		}
		//step 3; add factors to list, in order
		if(found) list.addFirst(div); else list.addFirst(l);
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
	
	public int calculateNthPrime(int k) throws IllegalArgumentException {
		IllegalArgumentException e = new IllegalArgumentException();
		if(k < 1) throw(e);
		int counter = 3;
		int loc = 5;
		if(k == 1) return 2;
		if(k == 2) return 3;
		if(k == 3) return 5;
		while(counter < k) {
			loc+=2;
			if(isPrime(loc)) {
				counter++;
			}
		}
		return loc;
	}
	private boolean isPrime(int i) { //does not work for evens, but dont pass those in?
		boolean ans = true;
		for(int j = 3; j < i/2; j+=2) {
			if(i%j == 0) return false;
			j+=2;
			if(i%j == 0) return false;
		}
		return(ans);
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
		return false;
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
		return 0;
	}

	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas. Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random
	 * class.
	 */

	public int[] threeLuckyNumbers() {
		return null;
	}

	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range: int x =
	 * minimum iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and
	 * y.
	 */

	public int guessingGame(int x, int y) {
		return 0;
	}
}
