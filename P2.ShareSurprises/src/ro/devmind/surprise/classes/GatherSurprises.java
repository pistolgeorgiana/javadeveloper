package ro.devmind.surprise.classes;

import java.util.ArrayList;
import java.util.Random;

public final class GatherSurprises {
	private static Random random = new Random();
	
	private GatherSurprises() { }
	
	public static ArrayList<ISurprise> gather(int n) {
		ArrayList<ISurprise> surprises = new ArrayList<ISurprise>();
		for(int i = 0; i < n; i++) {
			surprises.add(gather());
		}
		
		return surprises;
	}
	
	public static ISurprise gather() {
		int type = random.nextInt(3);
		switch(type) {
			case 0:
				return Candies.generate();
			case 1:
				return FortuneCookie.generate();
			case 2:
				return MinionToy.generate();
			default:
				return null;
		}
	}
}
