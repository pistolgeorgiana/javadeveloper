package ro.devmind.dynamicpoly.classes;

public class OchelariVedere extends Ochelari {
	private double dioptrie;

	public OchelariVedere(String model, String producator, String lentile, double dioptrie) {
		super(model, producator, lentile);
		this.dioptrie = dioptrie;
	}

	@Override
	public boolean schimbaTipLentila(String lentile) {
		this.dioptrie = Double.valueOf(lentile);
		System.out.println("Dioptrie lentila noua: " + lentile);
		return true;
	}	
}
