package ro.devmind.linkedlists.classes;

public class TestMyLinkedList {

	public static void main(String[] args) {
		MyLinkedList<String> towns = new MyLinkedList<String>();
		towns.add("Cluj");
		towns.add("Targu Jiu");
		towns.add("Suceava");
		towns.add("Bucuresti");
		towns.add("Brasov");
		towns.add(2, "Braila");
		for (int i = 0; i < towns.size(); i++) {
			System.out.println("Current town is: " + towns.get(i));
		}
		System.out.println();
		System.out.println(towns.contains("Bacau"));
		System.out.println(towns.contains("Cluj"));
		System.out.println(towns.contains("brasov"));
		
		System.out.println(towns.indexOf("Suceava"));
		System.out.println(towns.lastIndexOf("Baia Mare"));
		towns.remove("Braila");
		towns.removeElementAtIndex(4);
		towns.set(1, "Targu-Jiu");
		System.out.println();
		
		for (int i = 0; i < towns.size(); i++) {
			System.out.println("Current town is: " + towns.get(i));
		}
		System.out.println();
		
		MyLinkedList<String> copyList = new MyLinkedList<String>();
		copyList.add("Cluj");
		copyList.add("Targu Jiu");
		copyList.add("Suceava");
		copyList.add("Bucuresti");
		copyList.add("Brasov");
		copyList.add(2, "Braila");
		
		towns.addAll(2, copyList);
		System.out.println(towns.size());
		for (int i = 0; i < towns.size(); i++) {
			System.out.println("Current town is: " + towns.get(i));
		}
		System.out.println();
		
		towns.addAll(towns);
		System.out.println(towns.size());
		for (int i = 0; i < towns.size(); i++) {
			System.out.println("Current town is: " + towns.get(i));
		}
		System.out.println();
		
		Object[] townsArray = towns.toArray();
		for(Object town : townsArray) {
			System.out.println(town);
		}
		
		towns.clear();
		System.out.println("\n" + towns.size());
	}

}
