package DynamicProgramming;

import java.util.*;

public class MaxSubSquareMatrix {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		int arr[][] = new int[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++)

				arr[i][j] = sc.nextInt();

		}

		System.out.println(maxSubSquareMatrix(arr, row, col));

	}

	// Max SubSquare Matrix containing all 1's

	private static int maxSubSquareMatrix(int[][] arr, int row, int col) {

		int max = -1;
		int M[][] = new int[row + 1][col + 1];

		for (int i = 1; i <= row; i++) {

			for (int j = 1; j <= col; j++) {

				if (arr[i - 1][j - 1] == 0)
					M[i][j] = 0;

				else {
					M[i][j] = Math.min(Math.min(M[i - 1][j], M[i][j - 1]), M[i - 1][j - 1])+1;
				}

				if (max < M[i][j])
					max = M[i][j];

			}
		}

		return max;
	}

}
