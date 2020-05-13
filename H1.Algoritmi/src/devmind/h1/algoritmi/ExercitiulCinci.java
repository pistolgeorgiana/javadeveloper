package devmind.h1.algoritmi;

import java.util.Scanner;

public class ExercitiulCinci {
	private static Scanner scanner = new Scanner(System.in);
	
	private static boolean isPrime(int number) {
		for(int div=2; div<=number/2; div++) {
			if (number % div == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void sumPrimeNumbers(int upperLimit) {
		int sum = 2;
		for (int i=3; sum <= upperLimit; i++) {
			if (isPrime(i)) {
				System.out.print(sum + " ");
				sum += i;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Insert upper limit: ");
		int upperLimit = scanner.nextInt();
		System.out.print(upperLimit + " -> ");
		sumPrimeNumbers(upperLimit);
	}
}
