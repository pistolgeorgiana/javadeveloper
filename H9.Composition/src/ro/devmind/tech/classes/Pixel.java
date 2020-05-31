package ro.devmind.tech.classes;

public class Pixel {
	private String color;
	
	public Pixel() {
		this.color = "#FFFFFF";
	}

	public Pixel(String color) {
		this.color = color;
	}

	public void setPixel(String color) {
		this.color = color;
	}
}
