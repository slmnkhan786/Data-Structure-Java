package DynamicProgramming;

import java.util.*;

public class MaxSumNAE {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(maxSum(arr));

	}

	public static int maxSum(int[] arr) {

		int inc = arr[0];
		int exl = 0;
		int temp = inc;

		for (int i = 1; i < arr.length; i++) {
			temp = inc;
			inc = Math.max(exl + arr[i], inc);
			exl = temp;
		}

		if (inc > exl)
			return inc;

		return exl;

	}

}
