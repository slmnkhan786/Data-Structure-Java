package DynamicProgramming;

import java.util.*;

public class MaxSumRectangle {

	private static final String MaxSumRectangle = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		int arr[][] = new int[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++)

				arr[i][j] = sc.nextInt();

		}

		System.out.println(maxSumRectangle(arr, row, col));

	}

	private static int maxSumRectangle(int[][] arr, int row, int col) {

		int max_sum = 0;
		int max_right = 0;
		int max_left = 0;
		int max_up = 0;
		int max_down = 0;
		int[] temp = new int[row];

		for (int L = 0; L < col; L++) {
			for (int R = L; R < col; R++) {
				if (L == R) {
					for (int i = 0; i < row; i++) {
						temp[i] = arr[i][L];
					}
				} else {
					for (int i = 0; i < row; i++) {
						temp[i] += arr[i][R];
					}
				}
				Pair p = kadanesSum(temp);

				if (p.sum > max_sum) {
					max_sum = p.sum;
					max_left = L;
					max_right = R;
					max_up = p.top;
					max_down = p.bottom;
				}
			}
		}
		
		System.out.println("("+max_left+","+max_up+")"+"=>"+"("+max_down+","+max_right+")");
		return max_sum;

	}

	private static class Pair {
		int top = 0;
		int bottom = 0;
		int sum = 0;
	}

	private static Pair kadanesSum(int[] temp) {

		int max_sum = 0;
		int curr_sum = 0;
		int start = 0;
		int mstart = 0;
		int end = 0;

		Pair np = new Pair();

		for (int i = 0; i < temp.length; i++) {
			curr_sum += temp[i];

			if (curr_sum < 0) {
				curr_sum = 0;
				start = i + 1;
			}
			if (curr_sum > max_sum) {
				max_sum = curr_sum;
				mstart = start;
				end = i;
			}
		}

		np.sum = max_sum;
		np.top = start;
		np.bottom = end;
		

		return np;
	}

}
