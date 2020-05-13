package devmind.h2.recursivitate;

public class ExerciseFour {
	private static void bubbleSort(double[] array) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i=0; i<array.length - 1; i++) {
				if(array[i] > array[i+1]) {
					isSorted = false;
					double aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
				}
			}
		}
	}
	
	private static void bubbleSortDesc(double[] array) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i=0; i<array.length - 1; i++) {
				if(array[i] < array[i+1]) {
					isSorted = false;
					double aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
				}
			}
		}
	}
	
	private static void displayArray(double[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		double[] array = new double[] { 25, 10, -3, 7, 98, 20, 99 };
		
		bubbleSort(array);
		displayArray(array);
		
		bubbleSortDesc(array);
		displayArray(array);
	}
}
