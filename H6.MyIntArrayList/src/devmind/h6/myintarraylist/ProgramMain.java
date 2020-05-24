package devmind.h6.myintarraylist;

public class ProgramMain {
	private static void displayArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyIntArrayList array = new MyIntArrayList();
		array.set(0, 22);
		System.out.println(array.contains(22));
		
		for(int i=0; i<array.size(); i++) {
			System.out.print(array.get(i) != 0 ? 
					array.get(i) + " " : "");
		}
		System.out.println();
		
		array = new MyIntArrayList(5);
		array.set(0, 10);
		array.set(1, -2);
		array.set(2, 23);
		array.set(3, 1);
		array.set(4, -19);
		array.add(9);
		array.add(2, 39);
		int[] myArray = array.toArray();
		displayArray(myArray);
		
		MyIntArrayList testArray = new MyIntArrayList(array);
		testArray.remove(10);
		testArray.removeElementAtIndex(5);
		
		for(int i=0; i<testArray.size(); i++) {
			System.out.print(testArray.get(i) + " ");
		}
		System.out.println();
		
//		array.addAll(testArray);
		array.addAll(2, testArray);
		
		for(int i=0; i<array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
}
