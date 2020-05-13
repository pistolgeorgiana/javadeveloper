package devmind.h4.oop;

public class Main {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("Ford", 2019, "1M8GDM9AXKP042788", 
				100, "B 120 ANF", 2019);
		System.out.println(vehicle.isVinValid(true));
		vehicle.printVinDecomposed();
		System.out.println(vehicle.display());
	}
}
