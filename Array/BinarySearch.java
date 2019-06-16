package Array;

import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int item = sc.nextInt();
		System.out.println(binarySearch(arr, item, 0, n - 1));
	}

	public static int binarySearch(int[] arr, int item, int lo, int hi) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] < item) {
				lo = mid + 1;
			} else if (arr[mid] > item) {
				hi = mid - 1;
			} else
				return mid;
		}
		return -1;
	}

}
