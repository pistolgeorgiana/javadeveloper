package ro.devmind.javaio.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExerciseTwo {
	private static void sortInFile() throws IOException {
		try (Scanner sc1 = new Scanner(new BufferedReader(new FileReader("Numbers1.txt")));
				Scanner sc2 = new Scanner(new BufferedReader(new FileReader("Numbers2.txt")));
				BufferedWriter bf = new BufferedWriter(new FileWriter("NumbersMerge.txt"))) {
			int n1 = sc1.nextInt();
			int n2 = sc2.nextInt();
			while (sc1.hasNextInt() || sc2.hasNextInt()) {
				if (n1 < n2) {
					System.out.println(n1);
					if (sc1.hasNextInt()) {
						n1 = sc1.nextInt();
					} else {
						n1 = Integer.MAX_VALUE;
					}
				} else {
					System.out.println(n2);
					if (sc2.hasNextInt()) {
						n2 = sc2.nextInt();
					} else {
						n2 = Integer.MAX_VALUE;
					}
				}
			}
			if (n1 != Integer.MAX_VALUE && n2 != Integer.MAX_VALUE) {
				if (n1 < n2) {
					System.out.println(n1);
					System.out.println(n2);
				} else {
					System.out.println(n2);
					System.out.println(n1);
				}
			} else if (n1 != Integer.MAX_VALUE) {
				System.out.println(n1);
			} else if (n2 != Integer.MAX_VALUE) {
				System.out.println(n2);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		sortInFile();
	}

}
