package ro.devmind.radixsort.classes;

import java.util.ArrayDeque;
import java.util.Deque;

public class RadixSort {
	private int maxDecimals;
	private Deque<String>[] queue = new ArrayDeque[10];
	
	public RadixSort() {
		this.maxDecimals = 0;
		for(int i = 0; i < queue.length; i++) {
			queue[i] = new ArrayDeque<>();
		}
	}

	private void sort(String numbers) {
		for(int i = 0; i < maxDecimals; i++) {
			for(String num : numbers.split(" ")) {
				int digit = Integer.valueOf(num.substring(maxDecimals - i - 1, maxDecimals - i));
				queue[digit].add(num);
			}
			
			String temp = "";
			for (int j = 0; j < 10; j++) {
				while (!queue[j].isEmpty()) {
					temp += queue[j].poll() + " ";
				}
			}
			
			numbers = temp;
		}
		
		System.out.println(numbers);
	}
	
	private void sortDesc(String numbers) {
		for(int i = 0; i < maxDecimals; i++) {
			for(String num : numbers.split(" ")) {
				int digit = Integer.valueOf(num.substring(maxDecimals - i - 1, maxDecimals - i));
				queue[digit].add(num);
			}
			
			String temp = "";
			for (int j = 9; j >= 0; j--) {
				while (!queue[j].isEmpty()) {
					temp += queue[j].poll() + " ";
				}
			}
			
			numbers = temp;
		}
		
		System.out.println(numbers);
	}
	
	private String addArray(int[] numbers) {
		StringBuilder result = new StringBuilder();
		getMaxDecimals(numbers);
		
		for(int i = 0; i < numbers.length; i++) {
			String num = String.valueOf(numbers[i]);
			int zeros = maxDecimals - num.length();
			while (zeros > 0) {
				result.append("0");
				zeros--;
			}
			result.append(num + " ");
		}
		
		return result.toString();
	}
	
	private void getMaxDecimals(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			int length = String.valueOf(numbers[i]).length();
			maxDecimals = length > maxDecimals ? length : maxDecimals;
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = {1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713};
		
		RadixSort sort = new RadixSort();
		String num = sort.addArray(numbers);
		sort.sort(num);
		sort.sortDesc(num);
	}
}
