package ro.devmind.abstraction.classes;

import java.util.ArrayList;

public class ProgramMain {

	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<>();
		
		Triangle t1 = new Triangle(10, 5);
		Triangle t2 = new Triangle("I reflect light", "glass", 23, 11);
		System.out.println(t2);
		t1.displayTriangleHeight();
		System.out.println(t2.getSize());
		System.out.println(t1.equals(t2));		
		
		Rectangle r1 = new Rectangle("Yellow rectangle", "steel", 10, 50);
		Rectangle r2 = new Rectangle("Yellow rectangle", "steel", 10, 50);
		System.out.println(r1);
		r2.displayRectangleHeight();
		System.out.println(r1.getSize());
		System.out.println(r1.equals(r2));
		
		shapes.add(t1);
		shapes.add(t2);
		shapes.add(r1);
		shapes.add(r2);
		
		System.out.println();
		for(Shape shape : shapes) {
			System.out.println(shape);
			System.out.println(shape.getSize());
			if (shape instanceof Triangle) {
				((Triangle) shape).displayTriangleHeight();
			} else {
				((Rectangle) shape).displayRectangleHeight();
			}
		}
	}

}
