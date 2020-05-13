package devmind.h1.algoritmi;

import java.util.Scanner;

public class ExercitiulPatru {
	private static int sumOfDivisors(int number) {
		int sum = 1;
		for(int i=2; i<=number/2; i++) {
			if(number % i == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	private static boolean areFriendsNumbers(int a, int b) {
		int sumOfDivisorsA = sumOfDivisors(a);
		int sumOfDivisorsB = sumOfDivisors(b);
		
		return sumOfDivisorsA == b && sumOfDivisorsB == a;
	}
	
	private static void friendsNumberPairs(int lowerLimit, int upperLimit) {
		for(int i=lowerLimit; i<=upperLimit; i++) {
			for (int j=i+1; j<=upperLimit; j++) {
				if(areFriendsNumbers(i, j)) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
	
	private static int areFriendsNumbersOptimized(int number) {
		int pair = sumOfDivisors(number);
		if (sumOfDivisors(pair) == number) {
			return pair;
		}
		return number;
	}
	
	private static void friendsNumberPairsOptimized(int lowerLimit, int upperLimit) {
		for (int i=lowerLimit; i<=upperLimit; i++) {
			int pair = areFriendsNumbersOptimized(i);
			if(i < pair) {
				System.out.println(i + " -> " + pair);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Lower limit:");
		int lowerLimit = sc.nextInt();
		
		System.out.println("Upper limit:");
		int upperLimit = sc.nextInt();
		
//		friendsNumberPairs(lowerLimit, upperLimit);
		friendsNumberPairsOptimized(lowerLimit, upperLimit);
	}
}
