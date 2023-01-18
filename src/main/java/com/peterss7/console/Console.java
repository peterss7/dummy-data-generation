package com.peterss7.console;

public class Console {

	public static void println(String input) {
		System.out.println(input);
	}
	
	public static void print(String input) {
		System.out.print(input);
	}
	
	public static void printStrings(String[] values, String[] headers) {
		
		int count = 0;
		for (String element : values) {
			System.out.println(headers[count] + ": " + element);
			count++;
		}
	}
	
	public static void println(String[] values) {
		for (String element : values)
			System.out.println(element);
	}
	
	 
}
