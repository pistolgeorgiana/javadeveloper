package ro.devmind.tech.classes;

public class Dimensions {
	private int width;
	private int length;
	private int depth;
	
	public Dimensions(int width, int length, int depth) {
		super();
		this.width = width;
		this.length = length;
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public int getDepth() {
		return depth;
	}
}
