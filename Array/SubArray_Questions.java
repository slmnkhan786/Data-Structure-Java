package Array;

import java.util.*;

public class SubArray_Questions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

//		System.out.println(max_sum_subarray(arr, n));
		System.out.println(zero_sum_subarray(arr, n));
	}

	public static int max_sum_subarray(int[] arr, int n) {

		int max = 0;
		int temp_max = 0;

		for (int i = 0; i < n; i++) {
			temp_max += arr[i];

			if (temp_max < 0)
				temp_max = 0;

			if (temp_max > max)
				max = temp_max;

		}

		return max;

	}

	public static boolean zero_sum_subarray(int[] arr, int n) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < n; i++) {

			sum += arr[i];
			if (map.containsKey(sum)) {
				return true;
			} else {
				map.put(sum, 1);
			}

		}

		return false;

	}

}
