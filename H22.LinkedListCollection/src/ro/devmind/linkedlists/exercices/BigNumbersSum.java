package ro.devmind.linkedlists.exercices;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BigNumbersSum {
	private static int addWithCarry(int op1, int op2, int carry, LinkedList<Integer> result) {
		int sum = op1 + op2 + carry;
		carry = sum / 10;
		result.addFirst(sum % 10);
		return carry;
	}
	
	public LinkedList<Integer> sum(LinkedList<Integer> op1, LinkedList<Integer> op2) {
		LinkedList<Integer> result = new LinkedList<>();
		
		int carry = 0;
		while(!op1.isEmpty() && !op2.isEmpty()) {
			carry = addWithCarry(op1.removeLast(), op2.removeLast(), carry, result);
		}
		while(!op1.isEmpty()) {
			carry = addWithCarry(op1.removeLast(), 0, carry, result);
		}
		while(!op2.isEmpty()) {
			carry = addWithCarry(0, op2.removeLast(), carry, result);
		}
		
		return result;
	}
	  
	public static void main(String[] args) {
    	BigNumbersSum bn = new BigNumbersSum();
    	
    	LinkedList<Integer> op1 = new LinkedList<Integer>();
    	LinkedList<Integer> op2 = new LinkedList<Integer>();
    	
    	op1.add(2); op1.add(1); op1.add(7); op1.add(8);
    	op2.add(5); op2.add(9); op2.add(6);
    	
    	LinkedList<Integer> result = bn.sum(op1, op2);
       	displayResult(result);
	    
    	op1.clear(); op2.clear();
    	
    	op1.add(5); op1.add(0); op1.add(5); op1.add(0); op1.add(5);
    	op2.add(1); op2.add(0); op2.add(5); op2.add(5); op2.add(5); op2.add(5);
    	
    	result = bn.sum(op1, op2);
    	displayResult(result);
	}

	private static void displayResult(LinkedList<Integer> result) {
		for(Integer num : result) {
    		System.out.print(num + " -> ");
    	}
		System.out.println();
	}
}
