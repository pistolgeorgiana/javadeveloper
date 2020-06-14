package ro.devmind.linkedlists.orderedlist;

public class Town implements Comparable<Town> {
	private String townName;
	private int km;

	public Town(String townName, int km) {
		super();
		this.townName = townName;
		this.km = km;
	}

	public String getTownName() {
		return townName;
	}

	public int getKm() {
		return km;
	}

	@Override
	public int compareTo(Town o) {
		return this.getKm() < o.getKm() ? -1 : (this.getKm() == o.getKm() ? 0 : 1);
	}

	@Override
	public String toString() {
		return townName + " " + km;
	}

	
}
