package devmind.h2.recursivitate;

import java.util.Scanner;

public class ExerciseTwo {
	private static Scanner sc = new Scanner(System.in);
	
	private static int readInput(String message) {
		System.out.println(message);
		int number = sc.nextInt();
		
		return number;
	}
	
	private static int myMathPowR(int x, int y) {
		if (y == 0) {
			return 1;
		}
		return x * myMathPowR(x, y - 1);
	}
	
	public static void main(String[] args) {
		int base = readInput("Insert base:");
		int pow = readInput("Insert pow:");
		int res = myMathPowR(base, pow);
		
		System.out.println("myMathPowR(" + base + ",  " + pow + ") -> " + res);
	
	}
}
