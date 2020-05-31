package devmind.h15.functional;

public class LambdaOperator { 
	public static int addFunction(int a, int b) {
		return a + b;
	}
	
	public static int subFunction(int a, int b) {
		return a - b;
	}
	
	public static int mulFunction(int a, int b) {
		return a * b;
	}
	
	public static int divFunction(int a, int b) {
		return a / b;
	}
	
	public static int modFunction(int a, int b) {
		return a % b;
	}
	
	public static boolean isEvenFunction(int num) {
		return num % 2 == 0;
	}
	
	public static boolean isNegFunction(int num) {
		return num < 0;
	}
	
	public static boolean isZeroFunction(int num) {
		return num == 0;
}
	
	public static void main(String[] args) {
		IOperator adunare = (a, b) -> a + b;
		System.out.println(adunare.operation(2, 3));
		adunare = LambdaOperator::addFunction;
		System.out.println(adunare.operation(2, 3));
		
		IOperator scadere = (a, b) -> a - b;
		System.out.println(scadere.operation(123, 89));
		scadere = LambdaOperator::subFunction;
		System.out.println(scadere.operation(123, 89));
		
		IOperator inmultire = (a, b) -> a * b;
		System.out.println(inmultire.operation(9, 7));
		inmultire = LambdaOperator::mulFunction;
		System.out.println(inmultire.operation(9, 7));
		
		IOperator impartire = (a, b) -> a / b;
		System.out.println(impartire.operation(23, 5));
		impartire = LambdaOperator::divFunction;
		System.out.println(impartire.operation(23, 5));
		
		IOperator module = (a, b) -> a % b;
		System.out.println(module.operation(39, 9));
		module = LambdaOperator::modFunction;
		System.out.println(module.operation(39, 9));
		
		IVerifyProperty isEvenNumber = x -> x % 2 == 0;
		System.out.println(isEvenNumber.hasProperty(5));
		isEvenNumber = LambdaOperator::isEvenFunction;
		System.out.println(isEvenNumber.hasProperty(8));
		
		IVerifyProperty isNegativeNumber = x -> x < 0;
		System.out.println(isNegativeNumber.hasProperty(-19));
		isNegativeNumber = LambdaOperator::isNegFunction;
		System.out.println(isNegativeNumber.hasProperty(9));
		
		IVerifyProperty isZero = x -> x == 0;
		System.out.println(isZero.hasProperty(9));
		isZero = LambdaOperator::isZeroFunction;
		System.out.println(isZero.hasProperty(0));
	}
}
