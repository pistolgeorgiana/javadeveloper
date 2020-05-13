package devmind.h3.string;

import java.util.ArrayList;
import java.util.Comparator;

public class ExerciseTwo {
	private static ArrayList<Character> charList(String arg) {
		ArrayList<Character> letters = new ArrayList<Character>();
		for(int i=0; i<arg.length(); i++) {
			char letter = arg.charAt(i);
			if(Character.isAlphabetic(letter)) {
				letters.add(letter);
			}
		}
		
//		Collections.sort(letters);
		letters.sort(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return o1 < o2 ? -1 : 1;
			}
		});
		return letters;
	}
	
	private static Boolean anagramSolver(String anag1, String anag2) {
		ArrayList<Character> anag1Array = charList(anag1.toLowerCase());
		ArrayList<Character> anag2Array = charList(anag2.toLowerCase());
		
		for(int i=0; i<anag1Array.size(); i++) {
			if(anag1Array.get(i) != anag2Array.get(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		boolean result = anagramSolver("fairy tales!", "rail, safety");
		System.out.println("anagramSolver(\"fairy tales!\", \"rail, safety\") -> " 
				+ (result ? "TRUE" : "FALSE"));
		
		result = anagramSolver("silver bullet", "sunny day");
		System.out.println("anagramSolver(\"silver bullet\", \"sunny day\") -> " 
				+ (result ? "TRUE" : "FALSE"));
		
		result = anagramSolver("William Shakespeare", "I am a weakish speller!");
		System.out.println("anagramSolver(\"William Shakespeare\", \"I am a weakish speller!\") -> " 
				+ (result ? "TRUE" : "FALSE"));
	}
}
