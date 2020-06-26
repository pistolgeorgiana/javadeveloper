package ro.devmind.expressionevaluator.classes;

import java.util.ArrayDeque;
import java.util.Deque;


public class ShuntingYard {
	private final String operators = "+-*/^";
	private Deque<String> operands = new ArrayDeque<>();
	
	public String shuntingAlgorithm(String expression) {
		StringBuilder res = new StringBuilder();
		for (String op : expression.split("\\s+")) {
			if (op.equals("(")) {
				operands.push(op);
			} else if (op.equals(")")) {
				while(!operands.peek().equals("(")) {
					res.append(operands.pop() + " ");
				}
				if (operands.isEmpty()) {
					throw new IllegalArgumentException("The expression contains wrong parantheses");
				} else {
					operands.pop();
				}
			} else if (!operators.contains(op)) {
				res.append(op + " ");
			} else if (operators.contains(op)) {
				String op2 = operands.peek();
				while (!operands.isEmpty() && (!op2.equals("(")) 
						&& (operatorPrecedence(op) < operatorPrecedence(op2) 
						|| operatorPrecedence(op) == operatorPrecedence(op2) 
						&& operatorAssociativity(op2).equals("stanga-dreapta"))) {
					res.append(operands.pop() + " ");
					op2 = operands.peek();
				}
				operands.push(op);
			}
		}
		while (!operands.isEmpty()) {
			if(operands.peek().equals("(")) {
				throw new IllegalArgumentException("The expression contains wrong parantheses");
			}
			res.append(operands.pop() + " ");
		}
		
		return res.toString();
	}
	
	private int operatorPrecedence(String op) {
		switch(op) {
			case "+":
			case "-":
				return 11;
			case "*":
			case "/":
				return 12;
			case "^":
				return 13;
			default:
				throw new IllegalArgumentException("Wrong operator");
		}
	}
	
	private String operatorAssociativity(String op) {
		switch(op) {
			case "+":
			case "-":
			case "*":
			case "/":
				return "stanga-dreapta";
			case "^":
				return "dreapta-stanga";
			default:
				throw new IllegalArgumentException("Wrong operator");
		}
	}
}
