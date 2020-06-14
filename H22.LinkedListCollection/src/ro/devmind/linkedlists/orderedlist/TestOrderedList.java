package ro.devmind.linkedlists.orderedlist;

public class TestOrderedList {
	public static void main(String[] args) {
		 
	    OrderedList<Town> orderedTownsList = new OrderedList<>();
	 
	    orderedTownsList.addInOrderedList(new Town("Timisoara", 100));
	    orderedTownsList.addInOrderedList(new Town("Arad", 150));
	    orderedTownsList.addInOrderedList(new Town("Bucuresti", 0));
	    orderedTownsList.addInOrderedList(new Town("Ploiesti", 30));

	 
	    System.out.println(orderedTownsList);
	}
}
