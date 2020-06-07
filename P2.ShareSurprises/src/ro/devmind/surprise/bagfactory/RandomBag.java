package ro.devmind.surprise.bagfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ro.devmind.surprise.classes.ISurprise;

public class RandomBag implements IBag {
	private List<ISurprise> surprises;
	private Random random = new Random();
	
	public RandomBag() {
		this.surprises = new ArrayList<ISurprise>();
	}

	@Override
	public void put(ISurprise newSurprise) {
		if(newSurprise == null) {
			throw new IllegalArgumentException();
		}
		this.surprises.add(newSurprise);
	}

	@Override
	public void put(IBag bagOfSurprises) {
		if(bagOfSurprises == null) {
			throw new IllegalArgumentException();
		}
		while(!bagOfSurprises.isEmpty()) {
			this.surprises.add(bagOfSurprises.takeOut());
		}
	}

	@Override
	public ISurprise takeOut() {
		int index = random.nextInt(this.size());
		return this.surprises.remove(index);
	}

	@Override
	public boolean isEmpty() {
		return this.surprises.isEmpty();
	}

	@Override
	public int size() {
		return this.surprises.size();
	}
}
