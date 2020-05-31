package ro.devmind.vehicleinheritance;

public class Vehicle {
	private String serialNumber;
	private int noPersons;
	private String name;
	
	public Vehicle(String serialNumber, int noPersons) {
		this.serialNumber = serialNumber;
		this.noPersons = noPersons;
	}

	public Vehicle(String serialNumber, int noPersons, String name) {
		this(serialNumber, noPersons);
		this.name = name;
	}

	public final String getSerialNumber() {
		return serialNumber;
	}

	public boolean goTo(double positionX, double positionY) {
		System.out.println("Error: unknown vehicle cannot move…");
		return false;
	}
	
	public boolean addFuel(double amount) {
		System.out.println("Error: unknown type of vehicle…");
		return false;
	}
	
	public void printInfo() {
		System.out.println("Vehicle properties:\r\n" + 
				"	- serial number: " + this.serialNumber + "\r\n" + 
				"	- capacity: " + this.noPersons + " persons\r\n" + 
				"	- name: " + this.name);
	}
}
