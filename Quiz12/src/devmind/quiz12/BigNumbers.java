package devmind.quiz12;

public class BigNumbers {
	public int[] sum(int[] op1, int[] op2) {
		int dim = op2.length > op1.length ? op2.length + 1 : op1.length + 1;
		int[] result = new int[dim];
		int it = result.length - 1;
		int sum = 0;
		int i = op1.length - 1;
		int j=op2.length - 1;
		while (i >= 0 && j >= 0) {
			sum += op1[i] + op2[j];
			result[it] = sum % 10;
			sum /= 10;
			it--;
			i--;
			j--;
		}
		while (i >= 0) {
			result[it] = sum + op1[i];
			i--;
			it--;
			sum /= 10;
		} 
		while (j >= 0) {
			result[it] = sum + op2[j];
			j--;
			it--;
			sum /= 10;
		}
		
		result = resizeArray(result);
		return result;
	  }
	
	private static int[] resizeArray(int[] result) {
		int dim = result.length;
		for(int iterator=0; iterator<result.length - 1; ) {
			while (result[iterator] == 0) {
				iterator++;
				dim--;
			}
			break;
		}
		int[] newRes = new int[dim];
		for(int i=dim - 1; i>=0; i--) {
			newRes[i] = result[i + 1];
		}
		return newRes;
	}
	 
	  public static void main(String[] args) {
	    System.out.println("Checking input...");
	 
	    int[] op1 = {2, 1, 7, 8};
	    int[] op2 = {5, 9, 6};
	 
	    BigNumbers bn = new BigNumbers();
	    int[] rez = bn.sum(op1, op2);
	    int[] correct = {2, 7, 7, 4};
	    System.out.println(noToString(op1) + " + " + noToString(op2) + 
	                       " = " + noToString(rez) + " C: " + noToString(correct));
	    
	    int noTests = 6;
	    
	    int[][] op3 = {{0}, {9, 9}, {9}, {2, 1, 7, 8}, 
	                   {5, 0, 5, 0, 5}, {1, 0, 8, 6, 7, 8, 9, 4, 2, 3, 4}};
	    int[][] op4 = {{1, 0, 1}, {1}, {9, 9, 9, 9}, {5, 9, 6}, 
	                   {5, 5, 0, 5, 0}, {3, 4, 2, 8, 9, 7, 9, 2, 3, 4, 9}};
	    int[][] correct1 = {{1, 0, 1}, {1, 0, 0}, {1, 0, 0, 0, 8}, {2, 7, 7, 4}, 
	                   {1, 0, 5, 5, 5, 5}, {4, 5, 1, 5, 7, 6, 8, 6, 5, 8, 3}};
	 
	    int total = 0;
	    for (int i = 0; i < noTests; i++) {
	      System.out.println("Test " + (i+1) + ":");
	      String op1S = noToString(op3[i]);
	      String op2S = noToString(op4[i]);
	 
	      BigNumbers bn1 = new BigNumbers();
	      int[] rez1 = bn1.sum(op3[i], op4[i]);
	 
	      String rezS = noToString(rez1);
	      String correctS = noToString(correct1[i]);
	      System.out.println(op1S + " + " + op2S + " = " + rezS + " C: " + correctS + 
	                         "......" + (rezS.equals(correctS) ? "OK" : "WRONG"));
	      System.out.println();
	 
	      total += rezS.equals(correctS) ? 1 : 0;
	    }
	 
	    System.out.println("Your total score is: " + total + " / " + noTests);
	    System.out.println(total > 3 ? "You passed! Hurray! :)" : "Sorry.. :(");
	  }
	 
	  private static String noToString(int[] no) {
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < no.length; i++) {
	      sb.append(no[i]);
	    }
	    return sb.toString();
	  }
	
}
