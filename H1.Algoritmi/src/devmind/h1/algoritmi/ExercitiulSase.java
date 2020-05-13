package devmind.h1.algoritmi;

import java.util.Scanner;

public class ExercitiulSase {
	private static Scanner sc = new Scanner(System.in);
	
	private static void dispalyPythagoreanTriple(int upperLimit) {
		for (int i=1; i<= upperLimit; i++) {
			for (int j=i + 1; j<=upperLimit; j++) {
				int c2 = i * i + j * j;
				int rez = (int) Math.sqrt(c2);
				if (Math.pow(rez, 2) == c2 && rez <= upperLimit) {
					System.out.println(i + " " + j + " " + rez);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Insert upper limit:");
		int upperLimit = sc.nextInt();
		dispalyPythagoreanTriple(upperLimit);
	}
}
