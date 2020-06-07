package ro.devmind.surprise.sharesurprise;

import java.util.ArrayList;
import java.util.Random;

import ro.devmind.surprise.bagfactory.BagFactory;
import ro.devmind.surprise.bagfactory.IBag;
import ro.devmind.surprise.classes.GatherSurprises;
import ro.devmind.surprise.classes.ISurprise;

public class ProgramMain {
	private static Random random = new Random();
	
	public static void main(String[] args) {
		BagFactory createBag = BagFactory.getInstance();
		IBag fifoBag = createBag.makeBag("FIFO");
		IBag lifoBag = createBag.makeBag("LIFO");
		IBag randomBag = createBag.makeBag("RANDOM");
		
		int fifoBagSize = random.nextInt(3) + 2;
		for(int i = 0; i < fifoBagSize; i++) {
			fifoBag.put(GatherSurprises.gather());
		}
		System.out.println("Size of FIFO bag: " + fifoBag.size());
		
		ArrayList<ISurprise> surprises = GatherSurprises.gather(5);		
		randomBag.put(GatherSurprises.gather());
		System.out.println("Size of RANDOM bag: " + randomBag.size());
		
		for(ISurprise surprise : surprises) {
			lifoBag.put(surprise);
		}
		System.out.println("Size of LIFO bag: " + lifoBag.size());
		
		GiveSurpriseAndApplause applause = new GiveSurpriseAndApplause("FIFO", 9);
		
		applause.put(GatherSurprises.gather());
		applause.put(fifoBag.takeOut());
		
		GiveSurpriseAndHug hug = new GiveSurpriseAndHug("LIFO", 5);
		while (!lifoBag.isEmpty()) {
			hug.put(lifoBag.takeOut());
		}
		System.out.println("Size of LIFO bag after copying the surprises in container: " + lifoBag.size());
		
		surprises = GatherSurprises.gather(7);
		for(ISurprise surprise : surprises) {
			lifoBag.put(surprise);
		}
		System.out.println("Size of LIFO bag after generating other surprises: " + lifoBag.size());
		
		randomBag.put(lifoBag);
		System.out.println("Size of RANDOM bag after copying LIFO bag surprises: " + randomBag.size());
		System.out.println("Size of LIFO bag after copying surprises into RANDOM bag: " + lifoBag.size());
		GiveSurpriseAndSing sing = new GiveSurpriseAndSing("RANDOM",  7);
		while (!randomBag.isEmpty()) {
			sing.put(randomBag.takeOut());
		}
		
		ArrayList<AbstractGiveSurprises> giveList = new ArrayList<AbstractGiveSurprises>();
		giveList.add(sing);
		giveList.add(hug);
		
		System.out.println("======================================================\n");
		System.out.println("\tGenerated surprises RANDOM mode:\n");
		GiveSurpriseAndHug giveHug = new GiveSurpriseAndHug("RANDOM", 3);
//		GiveSurpriseAndHug giveHug = new GiveSurpriseAndHug("FIFO", 3);
//		GiveSurpriseAndHug giveHug = new GiveSurpriseAndHug("LIFO", 3);
		surprises = GatherSurprises.gather(4);
		for (ISurprise surprise : surprises) {
			surprise.enjoy(); //test the "takeOut" mode
			giveHug.put(surprise);
		}
		System.out.println("\n\tGive surprises RANDOM mode:\n");
		giveHug.giveAll();		
		System.out.println("======================================================\n");
		applause.giveAll();
		System.out.println("======================================================\n");
		while(!sing.isEmpty() || !hug.isEmpty()) {
			int rnd = random.nextInt(2);
			giveList.get(rnd).give();
		}
		System.out.println("======================================================\n");
	}

}
