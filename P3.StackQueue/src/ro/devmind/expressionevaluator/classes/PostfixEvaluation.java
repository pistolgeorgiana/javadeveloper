package ro.devmind.expressionevaluator.classes;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixEvaluation {
	private final String operators = "+-*/^";
	private Deque<Double> operands = new ArrayDeque<>();
	
	public double evaluateExpression(String expression) {
		for(String word : expression.split("\\s+")) {
			if(!operators.contains(word)) {
				operands.push(Double.valueOf(word));
			} else {
				if (operands.size() < 2) {
					throw new UnsupportedOperationException("The postfixed expression is wrong");
				} 
				double res = opResult(operands.pop(), operands.pop(), word);
				operands.push(res);				
			}
		}
		
		double result = operands.pop();
		if (!operands.isEmpty()) {
			throw new UnsupportedOperationException("The postfixed expression is wrong");
		}
		return result;
	}
	
	private double opResult(double op1, double op2, String op) {
		switch(op) {
			case "+":
				return op1 + op2;
			case "-":
				return op2 - op1;
			case "*":
				return op1 * op2;
			case "/":
				return op2 / op1;
			case "^":
				return Math.pow(op2, op1);
			default:
				throw new IllegalArgumentException("Wrong operand");
		}
	}
}
