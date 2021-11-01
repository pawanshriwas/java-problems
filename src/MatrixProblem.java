
public class MatrixProblem {

	public static void main(String[] args) {

		int[][] x = new int[][] { { 1, 2, 3, 4 }, { 1, -1, 3, 3 }, { 0, -1, 2, 3 }, { 1, 2, 3, 4 } };
		rotateMatrixBy90(x);
		
		int [][] x1 = new int[][] {{1, 2, 3, 4, 5},{1, -1, 3, 3, 5}};
		int [][] y1 = new int[][] {{2, 2, 9, 1, 3},{2, 2, -5, 1, -3}};
		matrixSubstraction(x1,y1);
		
		matrixAddition(y1, y1);
		
	    isMatrixSame(x1, y1);
	    
	    matrixRowSum(x);
	    
	    matrixDiagonalElementSum(x);
	    
	    matrixMinorDiagonalElementSum(x);
	    
	    matrixScalerProduct(x, 3);
	}

	public static int[][] rotateMatrixBy90(int[][] A) {

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int temp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = temp;
			}
		}

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length / 2; j++) {

				int temp = A[i][j];
				A[i][j] = A[i][(A.length - 1) - j];
				A[i][(A.length - 1) - j] = temp;
			}
		}

//    for printing of matrix 
//		System.out.println("========final=======");
//
//		for(int i=0;i<A.length;i++) {
//			for(int j=0;j<A.length; j++) {
//				System.out.print(A[i][j]+" ");
//				//addPostion--;
//			}
//			System.out.println();
//		}
		return A;
	}

	public static int[][] matrixSubstraction(int[][] A, int[][] B) {
		int[][] resultArray = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				resultArray[i][j] = A[i][j] - B[i][j];
			}
		}
		return resultArray;
	}

	public static int[][] matrixAddition(int[][] A, int[][] B) {
		int[][] resultArray = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				resultArray[i][j] = A[i][j] + B[i][j];
			}
		}
		return resultArray;
	}

	public static int isMatrixSame(int[][] A, int[][] B) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (!(A[i][j] == B[i][j]))
					return 0;
			}
		}
		return 1;
	}

	public static int[] matrixRowSum(int[][] A) {
		int[] resultArray = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int sumofRow = 0;
			for (int j = 0; j < A[0].length; j++) {
				sumofRow += A[i][j];
			}
			resultArray[i] = sumofRow;
		}
		return resultArray;

	}

	public static int matrixDiagonalElementSum(int[][] A) {

		int sumofRow = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (i == j) {
					sumofRow += A[i][j];
				}
			}
		}
		return sumofRow;

	}

	public static int matrixMinorDiagonalElementSum(int[][] A) {

		int sumofRow = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (((i + 1) + (j + 1)) == (A.length + 1)) {
					sumofRow += A[i][j];
				}
			}
		}
		return sumofRow;

	}

	public static int[][] matrixScalerProduct(int[][] A, int B) {
		int[][] resultArray = new int[A.length][A[0].length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {

				resultArray[i][j] = A[i][j] * B;
			}
		}
		return resultArray;
	}
}
