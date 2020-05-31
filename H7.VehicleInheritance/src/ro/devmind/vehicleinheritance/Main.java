package ro.devmind.vehicleinheritance;

public class Main {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("3FDS9DFF8FSD7", 4, "Moby");
		vehicle.goTo(21.68, 30.5);
		vehicle.addFuel(15.72);
		vehicle.printInfo();
		
		OnRoad onRoad = new OnRoad("FDFL8KMFSDLKM6", 2, "Sporty", 4, 2);
		onRoad.goTo(21.3, 12.88);
		onRoad.addFuel(28.12);
		onRoad.printInfo();
		
		OnWater onWater = new OnWater("F8GFDG86D87GGD", 20, "Wavess", 2, 2000.0);
		onWater.goTo(11.8, 4.33);
		onWater.addFuel(148.05);
		onWater.printInfo();
		
		OnAir onAir = new OnAir("GJR96GDF98DF9ND", 120, "Bluesky", 4, true);
		onAir.goTo(41.3, 120.88);
		onAir.addFuel(3000.5);
		onAir.printInfo();
		
		onAir = new OnAir("GTD12DFG98DF9ND", 120, "Birdish", 4, false);
		onAir.printInfo();
	}

}
