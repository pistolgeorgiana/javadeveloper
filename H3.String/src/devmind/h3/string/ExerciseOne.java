package devmind.h3.string;

import java.util.ArrayList;

public class ExerciseOne {
	private static void maxFrequency(String argument) {
		argument = argument.toLowerCase();
		int freqMax = 0;
		ArrayList<Character> letters = new ArrayList<Character>();
		for(int i=0; i<argument.length(); i++) {
			int freq = 1;
			char letter = argument.charAt(i);
			
			if(!Character.isWhitespace(argument.charAt(i))) {
				for(int j=i+1; j<argument.length(); j++) {
					if(letter == argument.charAt(j)) {
						freq++;
					}
				}
			}
			
			if (freq >= freqMax) {
				if(freq > freqMax) {
					letters.clear();
				}
				freqMax = freq;
				letters.add(letter);
			}
		}
		
		for(int i=0; i<letters.size(); i++) {
			System.out.println("Character '" + letters.get(i) + "' appears " + freqMax + " times.");
		}
	}

	public static void main(String[] args) {
		maxFrequency("Simple sentence.");
		maxFrequency("Becoming a programmer is like gaining super powers!");
	}

}
