package ro.devmind.surprise.bagfactory;

import java.util.ArrayList;
import java.util.List;

public class BagFactory implements IBagFactory {
	private static BagFactory instance = null;

	private BagFactory() {
	}

	public static BagFactory getInstance() {
		if (instance == null) {
			instance = new BagFactory();
		}

		return instance;
	}

	@Override
	public IBag makeBag(String type) {
		switch (type) {
			case "RANDOM":
				return new RandomBag();
			case "FIFO":
				return new FifoBag();
			case "LIFO":
				return new LifoBag();
		}
		return null;
	}

}
