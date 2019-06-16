package Recursion;

import java.util.*;

public class NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Boolean[][] board = new Boolean[n][n];
		for (int i = 0; i < n; i++)

		{
			for (int j = 0; j < n; j++) {
				board[i][j] = false;
			}
		}
		//System.out.println(count_NQueen(board, 0));
		print_NQueen(board, 0, "");
	}

	public static int count_NQueen(Boolean arr[][], int row) {
		if (row == arr.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < arr[row].length; col++) {
			if (isItSafe(arr, row, col)) {
				arr[row][col] = true;
				count = count + count_NQueen(arr, row + 1);
				arr[row][col] = false;

			}
		}
		return count;
	}

	private static Boolean isItSafe(Boolean arr[][], int row, int col) {
		for (int i = row; i >= 0; i--) {
			if (arr[i][col])
				return false;
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j])
				return false;
		}

		for (int i = row, j = col; i >= 0 && j < arr.length; i--, j++) {
			if (arr[i][j])
				return false;
		}
		return true;

	}

	public static void print_NQueen(Boolean arr[][], int row, String ans) {
		if (row == arr.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < arr[row].length; col++) {
			if (isItSafe(arr, row, col)) {
				arr[row][col] = true;
				print_NQueen(arr, row + 1, ans + "{" + (row + 1) + "-" + (col + 1) + "}");
				arr[row][col] = false;

			}
		}

	}

}
