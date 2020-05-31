package ro.devmind.dynamicpoly.classes;

public class ProgramMain {

	public static void main(String[] args) {
		Ochelari dioptrie = new OchelariVedere("eyeg", "Glassi", "premium", -1.5);
		Ochelari soare = new OchelariSoare("jenel", "Sorinel", "subtiri", "oglinda");
		Ochelari ochelari = new Ochelari("simply", "The Best", "aqua");
		
		ochelari.schimbaTipLentila("subtiri");
		dioptrie.schimbaTipLentila("-2.0");
		soare.schimbaTipLentila("transparent");
	}

}
