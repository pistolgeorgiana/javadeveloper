package ro.devmind.hashmap.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ro.devmind.hashmap.extra.RentedCars;

public class CarRentalSystem {
	private static Scanner sc = new Scanner(System.in);
	private HashMap<String, String> rentedCars = new HashMap<String, String>(100, 0.5f);
	private Map<String, RentedCars> ownersCars = new HashMap<String, RentedCars>(100, 0.5f);
	
	private static String getPlateNo() {
		System.out.println("Introduceti numarul de inmatriculare:");
		return sc.nextLine();
	}
	
	private static String getOwnerName() {
		System.out.println("Introduceti numele proprietarului:");
		return sc.nextLine();
	}
	
	private boolean isCarRent(String plateNo) {
		return rentedCars.containsKey(plateNo);
	}
	
	private String getCarRent(String plateNo) {
		if(rentedCars.containsKey(plateNo)) {
			return rentedCars.get(plateNo);
		}
		
		throw new IllegalArgumentException("Autovehiculul " + plateNo + " este inexistent.");
	}
	
	private void rentCar(String plateNo, String ownerName) {
		if(!rentedCars.containsKey(plateNo)) {
			rentedCars.put(plateNo, ownerName);
		}

		throw new UnsupportedOperationException("Autoturismul este deja inchiriat.");
	}
	
	private void returnCar(String plateNo) {
		if(rentedCars.remove(plateNo) != null) {
			System.out.println("Autoturismul " + plateNo + " a fost sters cu succes.");
		}
		
		throw new IllegalArgumentException("Autoturismul " + plateNo + " nu este inchiriat.");
	}
	
	private int totalRented() {
		return rentedCars.size();
	}
	
	private static void printCommandsList() {
		System.out.println("help         - Afiseaza aceasta lista de comenzi");
		System.out.println("add          - Adauga o noua pereche (masina, sofer)");
		System.out.println("check        - Verifica daca o masina este deja luata");
		System.out.println("remove       - Sterge o masina existenta din hashtable");
		System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
		System.out.println("rented       - Afiseaza numarul masinilor inchiriate");
		System.out.println("quit         - Inchide aplicatia");
	}
	
	public void run() {
		boolean quit = false;
		while(!quit) {
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			String command = sc.nextLine();
			switch(command) {
				case "help":
					printCommandsList();
					break;
				case "add":
					rentCar(getPlateNo(), getOwnerName());
					break;
				case "check":
					System.out.println(isCarRent(getPlateNo()));
					break;
				case "remove":
					returnCar(getPlateNo());
					break;
				case "getOwner":
					System.out.println(getCarRent(getPlateNo()));
					break;
				case "rented":
					System.out.println(totalRented() + " masini inchiriate");
					break;
				case "quit":
					System.out.println("Aplicatia se inchide...");
					quit = true;
					break;
				default:
					System.out.println("Unknown command. Choose from:");
					printCommandsList();
			}
		}
	}
	
	public static void main(String[] args) {
		new CarRentalSystem().run();
	}
}
