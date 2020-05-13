package devmind.h1.algoritmi;

import java.util.Scanner;

public class ExercitiulUnu {
	public static int citesteNumar(Scanner sc) {
		System.out.println("Introdu un numar pentru rotund-perfect:");
		int numarRotund = sc.nextInt();
		return numarRotund;
	}
	
	public static int numarRotundPerfect(int numarRotund) {
		int complementar = 10;
		while (complementar < numarRotund) {
			complementar *= 10;
		}
		complementar -= numarRotund;
		return complementar;
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int nrCitit = citesteNumar(sc);
		int nrComplementar = numarRotundPerfect(nrCitit);
		System.out.println(nrCitit + " -> " + nrComplementar);
	}
}
