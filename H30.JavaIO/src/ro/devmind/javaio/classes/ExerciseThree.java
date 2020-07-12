package ro.devmind.javaio.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ExerciseThree {
	private static List<String> readWords() {
		List<String> words = new ArrayList<String>();
		try(Scanner sc = new Scanner(System.in)) {
			while (sc.hasNextLine()) {
				words.add(sc.nextLine());
			}
		}
		
		return words;
	}
	
	private static void writeMinMaxFile(List<String> words) throws IOException {
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			} 
		});
		
		try (BufferedWriter bf = new BufferedWriter(new FileWriter("Output.txt"))) {
			bf.write("The shortest word: " + words.get(0) + "\n");
			bf.write("The longest word: " + words.get(words.size() - 1) + "\n");
		}
	}
	
	private static void writeAlphaFile(List<String> words) throws IOException {
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.charAt(0) - o2.charAt(0);
			} 
		});
		
		try (BufferedWriter bf = new BufferedWriter(new FileWriter("Output.txt", true))) {
			bf.write("First word: " + words.get(0) + "\n");
			bf.write("Last word: " + words.get(words.size() - 1) + "\n");
			bf.write("Total words: " + words.size());
		}
	}
	
	public static void main(String[] args) throws IOException {
		writeFile();
	}

	private static void writeFile() throws IOException {
		List<String> words = readWords();
		writeMinMaxFile(words);
		writeAlphaFile(words);
	}
}
