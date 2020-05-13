package devmind.h1.algoritmi;

import java.util.Scanner;

public class ExercitiulTrei {
	private static Scanner sc = new Scanner(System.in);
	
	public static int readNumber() {
		int number = -1;
		while (number < 0) {
			System.out.println("Insert the number >= 0 to check:");
			number = sc.nextInt();
		}
		
		return number;
	}
	
	public static int getMultipleOf5Lower(int number) {
		return number / 5 * 5;
	}
	
	public static int getMultipleOf5Upper(int number) {
		return (number / 5 + (number % 5 == 0 ? 0 : 1)) * 5;
	}
	
	public static void main(String[] args) {
		int number = readNumber();
		int multiple = getMultipleOf5Lower(number);
		System.out.println("getMultipleOf5Lower(" + number + ") -> (" 
				+ multiple + ")");
		
		multiple = getMultipleOf5Upper(number);
		System.out.println("getMultipleOf5Upper(" + number + ") -> (" 
				+ multiple + ")");
	}
}
