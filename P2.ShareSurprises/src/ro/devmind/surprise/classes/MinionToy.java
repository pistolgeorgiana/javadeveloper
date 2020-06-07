package ro.devmind.surprise.classes;

import java.util.Arrays;
import java.util.List;

public class MinionToy implements ISurprise {
	private String name;
	private static int minion = 0;
	private static List<String> minions = Arrays.asList("Dave", "Carl", 
			"Kevin", "Stuart", "Jerry", "Tim");

	public MinionToy(String name) {
		super();
		this.name = name;
	}

	@Override
	public void enjoy() {
		System.out.println("Congrats " + this.name + " minion.");
	}

	public static MinionToy generate() {
		int current = minion;
		if(++minion >= minions.size()) {
			minion = 0;
		}
		
		return new MinionToy(minions.get(current));
	}
}
