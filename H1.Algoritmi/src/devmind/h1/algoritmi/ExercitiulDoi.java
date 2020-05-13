package devmind.h1.algoritmi;

import java.util.Scanner;

public class ExercitiulDoi {
	//exercitiul 2
	public static int readInput(Scanner sc, String message) {
		System.out.println(message);
		int number = sc.nextInt();
		return number;
	}
	
	public static int basePower(int base, int exponent) {
		int result = 1;
		for(int i=0; i<exponent; i++) {
			result *= base;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base = readInput(sc, "Insert the base:");
		int exponent = readInput(sc, "Insert the exponent:");
		System.out.print(base + " " + exponent + " -> ");
		for (int i = 0; i <= exponent; i++) {
			System.out.print(basePower(base, i) + " ");
		}	
	}
}
