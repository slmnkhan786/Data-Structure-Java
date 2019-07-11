package BitManipulation;

import java.util.*;

public class BitManipulation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
//		int arr[] = new int[n];
//
//		for (int i = 0; i < n; i++)
//			arr[i] = sc.nextInt();
//
//		System.out.println(uniqueOccurrence(arr));

//		int ans = oddEven(n);
//		if (ans == 0)
//			System.out.println("Even");
//		else
//			System.out.println("Odd");

		int i = sc.nextInt();
//		System.out.println(extractBit(n, i));
		
		System.out.println(setBit(n,i));
		System.out.println(resetBit(n,i));
		
	}

	// checking no. is odd or even

	private static int oddEven(int n) {

		return n & 1;

	}

	// unique occurrence of element in given array

	private static int uniqueOccurrence(int[] arr) {

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum ^= arr[i];
		}

		return sum;

	}

	// extracting ith bit from no.

	public static int extractBit(int n, int i) {

		int j = 1 << (i - 1);

		n = n & j;

		return (n == 0 ? 0 : 1);

	}

	// set ith bit in given no.

	public static int setBit(int n, int i) {

		int j = 1 << (i - 1);

		n = n | j;

		return n;

	}

	// reset ith bit in given no.

	public static int resetBit(int n, int i) {

		int j = 1 << (i - 1);

		j = ~j;

		return n & j;

	}

}
