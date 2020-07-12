package ro.devmind.hashmap.extra;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class RentedCars implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int carsNo;
	private List<String> platesNo = new LinkedList<String>();

	public RentedCars() { } 
	
	public RentedCars(int carsNo, List<String> platesNo) {
		super();
		this.carsNo = carsNo;
		this.platesNo = platesNo;
	}
	
	public int getCarsNo() {
		return carsNo;
	}

	public List<String> getPlatesNo() {
		return platesNo;
	}

	public boolean addCar(String plateNo) {
		if (platesNo.contains(plateNo)) {
			return false;
		}
		platesNo.add(plateNo);
		carsNo++;
		return true;
	}
	
	public boolean removeCar(String plateNo) {
		if (!platesNo.contains(plateNo)) {
			return false;
		}
		platesNo.remove(plateNo);
		carsNo--;
		return true;
	}
	
	public boolean isCarRent(String plateNo) {
		return platesNo.contains(plateNo);
	}
}
