package ro.devmind.staticpoly.classes;

public class AddingVariables {
	public static void addVar(int a, int b) {
		int res = a + b;
		System.out.println("Sum of int: " + res);
	}
	
	public static void addVar(double a, double b) {
		double res = a + b;
		System.out.println("Sum of double: " + res);
	}
	
	public static void addVar(char a, char b) {
		char res = (char) ((int) a + (int) b);
		System.out.println("Sum of char: " + res);
	}
	
	public static void addVar(String a, String b) {
		String res = a + b;
		System.out.println("Sum of string: " + res);
	}
}
