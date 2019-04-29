package Backtraching;

import java.util.Scanner;

public class BlockedPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		  int n = sc.nextInt(); int[][] arr = new int[size][size]; for (int i = 0; i <
		  n; i++) { int row = sc.nextInt(); int col = sc.nextInt(); arr[row][col] = 1;
		  // System.out.println(arr[row][col]); } int cr = sc.nextInt(); int cc =
		  sc.nextInt(); int er = sc.nextInt(); int ec = sc.nextInt();
		 
		// boolean[][] arr1 = new boolean[size][size];
		// Pathblock(arr, arr1, cr, cc, er, ec, "");
		// nqueen(arr1, 0, "");
		int arr[] = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();
		// int[] ans = mergesort(arr, 0, arr.length - 1);
		quicksort(arr, 0, arr.length - 1);
		for (int val : arr)
			System.out.println(val);
	}

	public static void Pathblock(int[][] arr, boolean[][] arr1, int cr, int cc, int er, int ec, String ans) {
		if (cr == ec && cc == ec) {
			System.out.println(ans);
			return;
		}
		if (cr < 0 || cc < 0 || cr > er || cc > ec || arr[cr][cc] == 1 || arr1[cr][cc]) {
			return;
		}
		arr1[cr][cc] = true;
		Pathblock(arr, arr1, cr - 1, cc, er, ec, ans + "T");
		Pathblock(arr, arr1, cr + 1, cc, er, ec, ans + "D");
		Pathblock(arr, arr1, cr, cc + 1, er, ec, ans + "R");
		Pathblock(arr, arr1, cr, cc - 1, er, ec, ans + "L");
		arr1[cr][cc] = false;
	}

	public static boolean issafe(boolean[][] arr1, int row, int col) {
		int r = row - 1;
		int c = col;
		while (r >= 0) {
			if (arr1[r][c])
				return false;
			r--;
		}
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (arr1[r][c])
				return false;
			r--;
			c--;
		}
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < arr1.length) {
			if (arr1[r][c])
				return false;
			r--;
			c++;
		}
		return true;
	}

	public static void nqueen(boolean[][] arr1, int row, String ans) {
		if (row == arr1.length) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < arr1[0].length; i++) {
			if (issafe(arr1, row, i)) {
				arr1[row][i] = true;
				nqueen(arr1, row + 1, ans + "[" + row + "-" + i + "]");
				arr1[row][i] = false;
			}

		}
	}

	public static int[] mergesort(int[] arr, int lo, int hi) {
		int mid = (lo + hi) / 2;
		if (lo == hi) {
			int arr1[] = new int[1];
			arr1[0] = arr[lo];
			return arr1;
		}

		int[] fh = mergesort(arr, lo, mid);
		int[] sh = mergesort(arr, mid + 1, hi);
		int sort[] = mergeTwosortedarrays(fh, sh);
		return sort;
	}

	public static int[] mergeTwosortedarrays(int[] one, int[] two) {
		int[] mer = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] > two[j]) {
				mer[k] = two[j];
				k++;
				j++;
			} else {
				mer[k] = one[i];
				k++;
				i++;
			}
		}
		if (i < one.length) {
			while (i < one.length) {
				mer[k] = one[i];
				k++;
				i++;
			}
		}
		if (j < two.length) {
			while (j < two.length) {
				mer[k] = two[j];
				k++;
				j++;
			}
		}
		return mer;
	}

	public static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		int left = lo;
		int right = hi;
		int pivot = arr[mid];
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);

	}

}
