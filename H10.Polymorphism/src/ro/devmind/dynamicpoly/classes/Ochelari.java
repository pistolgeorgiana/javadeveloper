package ro.devmind.dynamicpoly.classes;

public class Ochelari {
	private String model;
	private String producator;
	private String tipLentile;
	
	public Ochelari(String model, String producator, String lentile) {
		super();
		this.model = model;
		this.producator = producator;
		this.tipLentile = lentile;
	}
	
	public boolean schimbaTipLentila(String lentile) {
		System.out.println("Err: ochelarii au configuratie standard");
		return false;
	}
}
