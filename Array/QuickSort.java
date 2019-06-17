package Array;

import java.util.*;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		quickSort(arr, 0, n - 1);
		print(arr);
	}

	public static void quickSort(int[] arr, int l, int h) {

		if (l < h) {

			int j = partition(arr, l, h);
			quickSort(arr, l, j - 1);
			quickSort(arr, j + 1, h);

		}

	}

	public static int partition(int[] arr, int l, int h) {

		int i = l;
		int j = h;
		int mid = (l + h) / 2;
		int pivot = arr[mid];

		while (i < j) {
			while (pivot >= arr[i]) {
				i++;
			}

			while (pivot < arr[j]) {
				j--;
			}
			if(i<j)
			{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			}
		}

		arr[mid] = arr[j];
		arr[j] = pivot;
		return j;
	}

	public static void print(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");

		}
	}

}
