package Array;

import java.util.*;

public class Merge_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sort(arr, 0, arr.length - 1);
		print(arr);
	}

	public static void sort(int arr[], int l, int h) {
		if (l < h) {
			int mid = (l + h) / 2;
			sort(arr, l, mid);
			sort(arr, mid + 1, h);
			merge(arr, l, mid, h);
		}

	}

	public static void merge(int arr[], int l, int mid, int h) {

		int n1 = mid - l + 1;
		int n2 = h - mid;

		int[] first = new int[n1];
		int[] second = new int[n2];

		for (int i = 0; i < n1; i++)
			first[i] = arr[i + l];

		for (int i = 0; i < n2; i++)
			second[i] = arr[i + mid + 1];

		int i = 0;
		int j = 0;
		int start = l;

		while (i < n1 && j < n2) {

			if (first[i] <= second[j]) {
				arr[start] = first[i];
				i++;
			}

			else {
				arr[start] = second[j];
				j++;
			}
			start++;
		}

		// copy remaining element of first array if any
		while (i < n1) {

			arr[start] = first[i];
			i++;
			start++;
		}

		// copy remaining element of second array if any
		while (j < n2) {

			arr[start] = second[j];
			j++;
			start++;
		}

	}

	public static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
