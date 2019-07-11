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
		
		System.out.println(posRSB(n));

//		System.out.println(addOne(n));

		System.out.println(magicNo(n));
		
		System.out.println(pascalSum(n));
		
		System.out.println(powerOfTwo(n));
		
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
	
	// position of first right set bit

	public static int posRSB(int n) {

		int mask = 1;
		int pos = 1;

		while ((n & mask) == 0) {
			pos++;
			mask <<= 1;
		}

		return pos;

	}

	// adding one to given no.

	public static int addOne(int n) {

		int pos = posRSB((~n));
		int mask = 1;

		while (pos > 0) {
			n ^= mask;
			mask <<= 1;
			pos--;
		}

		return n;

	}

	// ith magic no. in the power or sum of powers of 5

	public static int magicNo(int i) {

		int pow = 5;
		int ans = 0;

		while (i != 0) {

			if ((i & 1) != 0)
				ans += pow;

			pow *= 5;

			i >>= 1;

		}

		return ans;

	}

	// Pascals triangle sum

	public static int pascalSum(int i) {

		int ans = 1 << i;

		return (ans - 1);

	}

	// check no. can represent in power of two or not

	public static boolean powerOfTwo(int n) {

		int ans = n & (n - 1);

		return (ans == 0 ? true : false);

	}

}
