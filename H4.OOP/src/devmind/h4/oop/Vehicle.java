package devmind.h4.oop;

public class Vehicle {
	private static String producedBy; //no setter
	private int productionYear; //no setter
	private String vin; //no setter
	private String plateNumber; //get+set
	private double kilometers; //no setter
	private int lastSoldOnYear;
	private double positionX;
	private double positionY;
	
	public Vehicle(String producedBy, int productionYear, String vin, double kilometers) {
		Vehicle.producedBy = producedBy;
		this.productionYear = productionYear;
		this.vin = vin;
		this.kilometers = kilometers;
	}

	public Vehicle(String producedBy, int productionYear, String vin, double kilometers, String plateNumber, int lastSoldOnYear) {
		this(producedBy, productionYear, vin, kilometers);
		this.plateNumber = plateNumber;
		this.lastSoldOnYear = lastSoldOnYear;
	}

	public Vehicle(String producedBy, int productionYear, String vin, String plateNumber, double kilometers, int lastSoldOnYear,
			double positionX, double positionY) {
		this(producedBy, productionYear, vin, kilometers, plateNumber, lastSoldOnYear);
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public double getKilometers() {
		return kilometers;
	}
	
	public void sellVehicle(String plateNumber, int lastSoldOnYear) {
		this.plateNumber = plateNumber;
		this.lastSoldOnYear = lastSoldOnYear;
	}
	
	public void moveCar(double positionX, double positionY) {
		double distance = Math.sqrt(Math.pow(positionX - this.positionX, 2) 
				+ Math.pow(positionY - this.positionY, 2));
		this.kilometers += distance;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public boolean isVinValid(boolean isDrivingInNorthAmerica) {
		if(isDrivingInNorthAmerica) {
			int[] weight = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };
			
			StringBuilder trans = new StringBuilder();
			for(int i=0; i<this.vin.length(); i++) {
				char letter = this.vin.charAt(i);
				if(Character.isAlphabetic(letter)) {
					int transKey = (letter - 2) % 9;
					transKey += letter >= 83 ? 2 : 1;
					trans.append(transKey);
				} else {
					trans.append(letter);
				}
			}
			long vin = Long.valueOf(trans.toString());
			int sum = 0;
			for(int i=weight.length - 1; i>=0; i--) {
				sum += weight[i] * (vin % 10);
				vin /= 10;
			}
			return (sum % 11 == 10);
		}
		return true;
	}
	
	public void printVinDecomposed() {
		System.out.println("Identificatorul producatorului: " + this.vin.substring(0, 3));
		System.out.println("Atributele vehiculului: " + this.vin.substring(3, 8));
		System.out.println("Cifra de verificare: " + this.vin.charAt(8));
		System.out.println("Anul productiei modelului: " + this.vin.charAt(9));
		System.out.println("Seria fabricii: " + this.vin.charAt(10));
		System.out.println("Identificatorul numeric: " + this.vin.substring(11));
	}
	
	public String display() {
		return "Autovehicul " + this.plateNumber + " "
				+ Vehicle.producedBy + ": " 
				+ this.productionYear + "\nSerie sasiu: "
				+ this.vin + "\nUltimul an al vanzarii: "
				+ this.lastSoldOnYear + "\n" 
				+ this.kilometers + " km, "
				+ this.positionX + " " + this.positionY;
	}
}
