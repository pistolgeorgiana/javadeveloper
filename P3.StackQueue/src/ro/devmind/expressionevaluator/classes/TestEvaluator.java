package ro.devmind.expressionevaluator.classes;

public class TestEvaluator {
	public static void main(String[] args) {
		String arg = "3 + ( 2 + 1 ) * 2 ^ 3 ^ 2 - 8 / ( 5 - 1 * 2 / 2 )";
		ShuntingYard postfixed = new ShuntingYard();
		String res = postfixed.shuntingAlgorithm(arg);
		
		PostfixEvaluation expression = new PostfixEvaluation();
		double result = expression.evaluateExpression(res);
		System.out.println(arg + " = " + result);
	}
}
