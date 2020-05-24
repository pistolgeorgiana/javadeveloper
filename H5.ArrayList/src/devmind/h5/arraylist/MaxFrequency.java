package devmind.h5.arraylist;

import java.util.ArrayList;

public class MaxFrequency {	
	public static void maxFrequency(ArrayList<String> arguments) {
		int freqMax = 0;
		ArrayList<String> words = new ArrayList<String>();
		for(int i=0; i<arguments.size(); i++) {
			int freq = 1;
			String word = arguments.get(i);
			for(int j=i+1; j<arguments.size(); j++) {
				if(word.equalsIgnoreCase(arguments.get(j))) {
					freq++;
				}
			}
			
			if (freq >= freqMax) {
				if(freq > freqMax) {
					words.clear();
				}
				freqMax = freq;
				words.add(word);
			}
		}
		
		for(int i=0; i<words.size(); i++) {
			System.out.println("Word '" + words.get(i) + "' appears " + freqMax + " times.");
		}
	}
}
