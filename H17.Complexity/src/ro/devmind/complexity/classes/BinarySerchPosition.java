package ro.devmind.complexity.classes;

public class BinarySerchPosition {
	public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		int middle = -1;
		while(left <= right) {
			middle = (left + right) / 2;
			
			if(target == nums[middle]) {
				return middle;
			}else if(target > nums[middle]) {
				left = middle + 1;
			}else if(target < nums[middle]) {
				right = middle - 1;
			}
		}
		
		if(right < 0) {
			return 0;
		}else {
			return left > right ? left : right;
		}
	}
	
	public static void main(String[] args) {
		int[] values = {3, 7, 19, 24, 37, 209, 300};
		int key = 20;
		System.out.println(binarySearch(values, key));
	}
}
