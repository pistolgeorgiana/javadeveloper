package ro.devmind.surprise.bagfactory;

import ro.devmind.surprise.classes.ISurprise;

public interface IBag {
	public void put(ISurprise newSurprise);
	public void put(IBag bagOfSurprises);
	public ISurprise takeOut();
	public boolean isEmpty();
	public int size();
}
