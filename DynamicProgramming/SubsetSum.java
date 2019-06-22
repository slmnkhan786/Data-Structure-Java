package DynamicProgramming;

import java.util.*;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = sc.nextInt();

		Boolean T[][] = new Boolean[n + 1][sum + 1];
		
		
		System.out.println(subsetSum(arr, T));

	}

	public static boolean subsetSum(int[] arr, Boolean[][] W) {

		int row = arr.length;
		int col = W[0].length;

		for (int i = 0; i <= row; i++) {
			W[i][0] = true;
		}
		for (int i = 1; i < col; i++) {
			W[0][i] = false;
		}

		for (int i = 1; i <= row; i++) {

			for (int w = 1; w < col; w++) {

				if (w >= arr[i - 1]) {
					if (W[i - 1][w])
						W[i][w] = W[i - 1][w];
					else
						W[i][w] = W[i - 1][w - arr[i - 1]];
				}

				else {
					W[i][w] = W[i - 1][w];

				}

			}

		}
		
		return W[row][col - 1];

	}

}
