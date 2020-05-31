package ro.devmind.tech.classes;

import java.util.ArrayList;

public class Screen {
	private ArrayList<Pixel> pixels;
	private Dimensions dimensions;
	
	public Screen(int pixelsNo, int width, int length, int depth) {
		this.pixels = new ArrayList<>(pixelsNo);
		this.dimensions = new Dimensions(width, length, depth);
	}
	
	public void setPixel(int index, String color) {
		if(index < 0 || index >= this.pixels.size()) {
			throw new IllegalArgumentException();
		}
		
		pixels.get(index).setPixel(color);
	}
	
	public void colorScreen(String color) {
		for(Pixel pixel : pixels) {
			pixel.setPixel(color);
		}
	}
}
