package ro.devmind.dynamicpoly.classes;

public class OchelariSoare extends Ochelari {
	private String culoareLentila;

	public OchelariSoare(String model, String producator, String lentile, String culoareLentila) {
		super(model, producator, lentile);
		this.culoareLentila = culoareLentila;
	}

	@Override
	public boolean schimbaTipLentila(String lentile) {
		this.culoareLentila = lentile;
		System.out.println("Culoare lentila noua: " + lentile);
		return true;
	}
}
