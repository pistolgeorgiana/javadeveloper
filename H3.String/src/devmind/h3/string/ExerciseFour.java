package devmind.h3.string;

public class ExerciseFour {
	private static String[] selectiveFilter(String[] words, String key, int matchKey) {
		String[] result = new String[words.length];
		int wordIndex = 0;
		for(int i=0; i<words.length; i++) {
			int match = 0;
			int index = 0;
			int length = words[i].length() < key.length() ? words[i].length() : key.length();
			while(match <= matchKey && index < length) {
				if (words[i].toLowerCase().charAt(index) == key.toLowerCase().charAt(index)) {
					match++;
				}
				index++;
			}
			if(match >= matchKey) {
				result[wordIndex] = words[i];
				wordIndex++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] words = new String[] {"clothes", "ant", "drop", "Fly", "racoon", "class", "Plane"};
		String[] result = selectiveFilter(words, "plot", 1);
		
		for (int i=0; i<result.length; i++) {
			if(result[i] != null) {
				System.out.print(result[i] + " ");
			}
		}
	}
}
