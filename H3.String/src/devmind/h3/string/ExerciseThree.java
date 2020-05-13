package devmind.h3.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExerciseThree {
	public static int convertStringToNumber(String numberStr) {
	  char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	  int numValue = 0;
	 
	  for(int i=0; i<numberStr.length(); i++) {
		  for(int j=0; j<digits.length; j++) {
			  char digit = numberStr.charAt(i);
			  if(digit == digits[j]) {
				  numValue = numValue * 10 + j;  
			  }
		  }
	  }
	 
	  return numValue;
	} 
	
	public static void main(String[] args) {
		int number = convertStringToNumber("20109");
		System.out.println(number);
	}
}