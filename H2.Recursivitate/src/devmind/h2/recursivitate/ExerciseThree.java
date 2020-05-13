package devmind.h2.recursivitate;

public class ExerciseThree {
	private static int[] moveZeros(int[] array) {
		int lastZeroPosition = array.length - 1;
		for (int i=array.length - 1; i >= 0; i--) {
			if (array[i] != 0) {
				array[lastZeroPosition] = array[i];
				lastZeroPosition--;
			}
		}
		while (lastZeroPosition >= 0) {
			array[lastZeroPosition] = 0;
			lastZeroPosition--;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 0, -5};
		array = moveZeros(array);
		
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
