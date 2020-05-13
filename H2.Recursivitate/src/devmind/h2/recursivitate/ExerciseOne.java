package devmind.h2.recursivitate;

import java.util.Scanner;

public class ExerciseOne {
	private static Scanner sc = new Scanner(System.in);
	
	private static int readInput(String message) {
		System.out.println(message);
		int number = sc.nextInt();
		
		return number;
	}
	
	private static int reverseNumberR(int number) {
		if (number < 10) {
			return number;
		}
		int reverse = reverseNumberR(number / 10);
		int tenMul;
		for(tenMul=1; tenMul<=number/10; tenMul*=10);
		return (number % 10) * tenMul + reverse;
	}
	
	public static void main(String[] args) {
		int number = readInput("Insert number:");
		int reverse = reverseNumberR(number);
		
		System.out.println("reverseNumberR(" + number + ") -> " + reverse);
		
	}
}
