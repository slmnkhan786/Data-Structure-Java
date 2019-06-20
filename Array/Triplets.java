package Array;

import java.util.*;

public class Triplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		find_triplets(arr, n, sum);

	}

	public static void find_triplets(int[] arr, int n, int target) {
		int flag = 0;
		Arrays.sort(arr);
		for (int i = 0; i < n - 2; i++) {

			int start = i + 1;
			int end = n - 1;
			int sum = 0;

			while (start < end) {
				sum = arr[i] + arr[start] + arr[end];

				if (sum == target) {
					flag = 1;
					System.out.println(arr[i] + " " + arr[start] + " " + arr[end]);
					break;
				} else if (sum > target) {
					end--;
				} else {
					start++;
				}
				sum = 0;
			}

		}

		if (flag == 0)
			System.out.println("No triplets");

	}

}
