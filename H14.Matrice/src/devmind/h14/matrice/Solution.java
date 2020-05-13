package devmind.h14.matrice;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	private static Scanner sc = new Scanner(System.in);
	private static int matrixDimension;
	private static int mainDiagValue;
	private static int sndDiagValue;
	private static int centerValue;
	private static int leftValue;
	private static int upValue;
	private static int rightValue;
	private static int bottomValue;
	

	private static int readDimensions(String message) {
		System.out.print(message);
		return sc.nextInt();
	}
	
	private static void initDimensions() {
		matrixDimension = readDimensions("Insert matrix dimension: ");
		mainDiagValue = readDimensions("Insert main diag value: ");
		sndDiagValue = readDimensions("Insert secondary diag value: ");
		if (matrixDimension % 2 != 0) {
			centerValue = readDimensions("Insert center value: ");
		}
		leftValue = readDimensions("Insert left value: ");
		upValue = readDimensions("Insert up value: ");
		rightValue = readDimensions("Insert right value: ");
		bottomValue = readDimensions("Insert bottom value: ");
	}
	
	private static int[][] genMatrix() {
		int[][] result = new int[matrixDimension][matrixDimension];
		for (int i=0; i<result.length; i++) {
			for (int j=0; j<result[0].length; j++) {
				if (i==j) {
					result[i][j] = mainDiagValue;
				} else if (i + j == matrixDimension - 1) {
					result[i][j] = sndDiagValue;
				} else if (i > j && i + j < matrixDimension - 1) {
					result[i][j] = leftValue;
				} else if (i < j && i + j < matrixDimension - 1) {
					result[i][j] = upValue;
				} else if (i < j && i + j > matrixDimension - 1) {
					result[i][j] = rightValue;
				} else {
					result[i][j] = bottomValue;
				}
			}
		}
		if (matrixDimension % 2 != 0) {
			result[matrixDimension/2][matrixDimension/2] = centerValue;
		}
		return result;
	}
	
	private static ArrayList<ArrayList<Integer>> genArrayListMatrix() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(matrixDimension);
		for (int i=0; i<matrixDimension; i++) {
			ArrayList<Integer> line = new ArrayList<Integer>(matrixDimension);
			for (int j=0; j<matrixDimension; j++) {
				if (i==j) {
					line.add(mainDiagValue);
				} else if (i + j == matrixDimension - 1) {
					line.add(sndDiagValue);
				} else if (i > j && i + j < matrixDimension - 1) {
					line.add(leftValue);
				} else if (i < j && i + j < matrixDimension - 1) {
					line.add(upValue);
				} else if (i < j && i + j > matrixDimension - 1) {
					line.add(rightValue);
				} else {
					line.add(bottomValue);
				}
			}
			result.add(line);
		}
		if (matrixDimension % 2 != 0) {
			result.get(matrixDimension/2).set(matrixDimension/2, centerValue);
		}
		return result;
	}
	
	private static void printMatrix(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	private static void printArrayListMatrix(ArrayList<ArrayList<Integer>> listMatrix) {
		for (int i=0; i<listMatrix.size(); i++) {
			for (int j=0; j<listMatrix.get(0).size(); j++) {
				System.out.print(listMatrix.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}
	
	private static int[][] addMatrix(int[][] matrixA, ArrayList<ArrayList<Integer>> matrixB) {
		int[][] result = new int[matrixDimension][matrixDimension];
		if (matrixA.length == matrixB.size() 
				&& matrixA[0].length == matrixB.get(0).size()) {
			for (int i=0; i<matrixDimension; i++) {
				for (int j=0; j<matrixDimension; j++) {
					result[i][j] = matrixA[i][j] + matrixB.get(i).get(j);
				}
			}
		}
		return result;
	}
	
	private static int[][] substractMatrix(int[][] matrixA, ArrayList<ArrayList<Integer>> matrixB) {
		int[][] result = new int[matrixDimension][matrixDimension];
		if (matrixA.length == matrixB.size() 
				&& matrixA[0].length == matrixB.get(0).size()) {
			for (int i=0; i<matrixDimension; i++) {
				for (int j=0; j<matrixDimension; j++) {
					result[i][j] = matrixA[i][j] - matrixB.get(i).get(j);
				}
			}
		}
		return result;
	}
	
	private static int[][] multiplyMatrix(int[][] matrixA, ArrayList<ArrayList<Integer>> matrixB) {
		int[][] result = new int[matrixDimension][matrixDimension];
		if (matrixA[0].length == matrixB.size()) {
			for (int i=0; i<matrixDimension; i++) {
				for (int j=0; j<matrixDimension; j++) {
					for (int k=0; k<matrixDimension; k++) {
						result[i][j] += (matrixA[i][k] * matrixB.get(k).get(j));
					}
				}
			}
		}
		return result;
	}
	
	private static int[][] multiplyScalarMatrix(int[][] matrixA, int scalar) {
		int[][] result = new int[matrixDimension][matrixDimension];
		for (int i=0; i<matrixDimension; i++) {
			for (int j=0; j<matrixDimension; j++) {
				result[i][j] = matrixA[i][j] * scalar;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		initDimensions();
		
		int[][] matrix = genMatrix();
		printMatrix(matrix);
		
		ArrayList<ArrayList<Integer>> listMatrix = genArrayListMatrix();
		printArrayListMatrix(listMatrix);
		
		int[][] result = addMatrix(matrix, listMatrix);
		System.out.println("Add matrix:");
		printMatrix(result);
		
		result = substractMatrix(matrix, listMatrix);
		System.out.println("Substract matrix:");
		printMatrix(result);
		
		result = multiplyMatrix(matrix, listMatrix);
		System.out.println("Multiply matrix:");
		printMatrix(result);
		
		result = multiplyScalarMatrix(matrix, 0);
		System.out.println("Multiply scalar matrix:");
		printMatrix(result);
	}

}
