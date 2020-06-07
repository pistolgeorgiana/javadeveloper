package ro.devmind.surprise.sharesurprise;

import java.util.concurrent.TimeUnit;

import ro.devmind.surprise.bagfactory.BagFactory;
import ro.devmind.surprise.bagfactory.IBag;
import ro.devmind.surprise.classes.ISurprise;

public abstract class AbstractGiveSurprises {
	private IBag bag;
	private int waitTime;
	
	public AbstractGiveSurprises(String type, int waitTime) {
		this.bag = BagFactory.getInstance().makeBag(type);
		this.waitTime = waitTime;
	}
	
	public void put(ISurprise newSurprise) {
		this.bag.put(newSurprise);
	}
	
	public ISurprise give() {
		if(!this.bag.isEmpty()) {
			giveWithPassion();
			ISurprise surprise = this.bag.takeOut();
			surprise.enjoy();
			System.out.println();
			return surprise;
		}
		return null;
	}
	
	public void giveAll() {
		while(!this.bag.isEmpty()) {
			give();
			waitTime();
		}
	}

	private void waitTime() {
		try {
			TimeUnit.SECONDS.sleep(this.waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isEmpty() {
		return this.bag.isEmpty();
	}
	
	abstract void giveWithPassion();
}
