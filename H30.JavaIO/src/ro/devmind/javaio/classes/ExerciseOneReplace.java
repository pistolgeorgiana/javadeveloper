package ro.devmind.javaio.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExerciseOneReplace {
	private static void replaceFile(String word, String replace) throws IOException {
		StringBuilder res = new StringBuilder();
		
		try (Scanner sc = new Scanner(new BufferedReader(new FileReader("TextInput.txt")))) {
			while(sc.hasNextLine()) {
				res.append(sc.nextLine() + "\n");
			}
		}
		
		try (BufferedWriter bf = new BufferedWriter(new FileWriter("TextInput.txt"))) {
			bf.write(res.toString().replaceAll(word, replace));
		}
	}
	
	private static void replaceInFile(String word, String replace) throws IOException {
		
		try (Scanner sc = new Scanner(new BufferedReader(new FileReader("TextInput.txt")));
				BufferedWriter bf = new BufferedWriter(new FileWriter("TextOutput.txt"))) {
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				nextLine = nextLine.replace(word, replace);
				bf.write(nextLine + "\n");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		String replace = sc.nextLine();
		
		replaceInFile(word, replace);
		replaceFile(word, replace);
		
		sc.close();
	}
}
