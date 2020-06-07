package ro.devmind.surprise.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Candies implements ISurprise {
	private int candiesNo;
	private String type;
	private static Random random = new Random();
	private static List<String> types = Arrays.asList("chocolate", "jelly", "fruits", "vanilla");

	private Candies(int candiesNo, String type) {
		this.candiesNo = candiesNo;
		this.type = type;
	}

	@Override
	public void enjoy() {
		System.out.println("Congrats! Your surprise: " 
				+ this.candiesNo + " " + this.type + " candies");
	}

	public static Candies generate() {
		int type = random.nextInt(4);
		int candiesNo = Math.abs(random.nextInt(1000) + 1);
		
		return new Candies(candiesNo, types.get(type));
	}
}
