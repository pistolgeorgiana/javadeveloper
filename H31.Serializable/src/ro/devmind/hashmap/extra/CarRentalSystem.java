package ro.devmind.hashmap.extra;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ro.devmind.hashmap.extra.RentedCars;

public class CarRentalSystem {
	private static Scanner sc = new Scanner(System.in);
	private Map<String, String> rentedCars = new HashMap<String, String>(100, 0.5f);
	private Map<String, RentedCars> owners = new HashMap<String, RentedCars>(100, 0.5f);
	
	private void saveDataToBinaryFile() throws IOException {
		try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("RentedCars.dat")))) {
			binaryFileOut.writeObject(rentedCars);
			binaryFileOut.writeObject(owners);
		}
	}
	
	private void restoreDataFromBinaryFile() throws IOException {
		try (ObjectInputStream binaryFileIn = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("RentedCars.dat")))) {
			while(true) {
				try {
					rentedCars = (Map<String, String>) binaryFileIn.readObject();
					owners = (Map<String, RentedCars>) binaryFileIn.readObject();
				} catch (EOFException e) {
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("A class not found exception: " + e.getMessage());
		} catch (EOFException e) {
		}
	}
	
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
			if(!owners.containsKey(ownerName)) {
				owners.put(ownerName, new RentedCars());
			}
			owners.get(ownerName).addCar(plateNo);
		} else {
			throw new UnsupportedOperationException("Autoturismul este deja inchiriat.");
		}
	}
	
	private void returnCar(String plateNo) {
		String owner = rentedCars.remove(plateNo);
		if(owner != null) {
			System.out.println("Autoturismul " + plateNo + " a fost sters cu succes.");
			owners.get(owner).removeCar(plateNo);
			if(owners.get(owner).getCarsNo() == 0) {
				owners.remove(owner);
			}
		} else {
			throw new IllegalArgumentException("Autoturismul " + plateNo + " nu este inchiriat.");
		}
	}
	
	private int getCarsNo(String ownerName) {
		if (owners.containsKey(ownerName)) {
			return owners.get(ownerName).getCarsNo();
		}
		return 0;
	}
	
	private List<String> getCarsList(String ownerName) {
		if (owners.containsKey(ownerName)) {
			List<String> cars = owners.get(ownerName).getPlatesNo();
			for(String car : cars) {
				System.out.println(car);
			}
			return cars;
		}
		throw new UnsupportedOperationException("The owner has no rented cars.");
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
		System.out.println("getCarsNo    - Afiseaza numarul de masini inchiriate ale proprietarului");
		System.out.println("getCarsList  - Afiseaza lista de masini inchiriate ale proprietarului");
		System.out.println("rented       - Afiseaza numarul masinilor inchiriate");
		System.out.println("quit         - Inchide aplicatia");
	}
	
	public void run() throws IOException {
		boolean quit = false;
		restoreDataFromBinaryFile();
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
				case "getCarsNo":
					System.out.println(getCarsNo(getOwnerName()) + " masini inchiriate");
					break;
				case "getCarsList":
					getCarsList(getOwnerName());
					break;
				case "rented":
					System.out.println(totalRented() + " masini inchiriate");
					break;
				case "quit":
					System.out.println("Aplicatia se inchide...");
					saveDataToBinaryFile();
					quit = true;
					break;
				default:
					System.out.println("Unknown command. Choose from:");
					printCommandsList();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new CarRentalSystem().run();
	}
}
