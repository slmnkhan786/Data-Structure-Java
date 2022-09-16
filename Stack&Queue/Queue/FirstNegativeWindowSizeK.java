package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstNegativeWindowSizeK {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();

		int k = scn.nextInt();
		findMax(a, k);

	}

	private static void findMax(int[] a, int k) {

		Deque<Integer> q = new LinkedList<>();
		int i;

		for (i = 0; i < k; i++) {
			if (a[i] < 0)
				q.addLast(i);
		}

		for (; i < a.length; i++) {

			if (!q.isEmpty())
				System.out.print(a[q.getFirst()] + " ");
			else
				System.out.print("0" + " ");

			while (!q.isEmpty() && q.peek() <= i - k)
				q.removeFirst();

			if (a[i] < 0)
				q.addLast(i);
		}

		if (!q.isEmpty())
			System.out.print(a[q.getFirst()] + " ");
		else
			System.out.print("0" + " ");

	}
}
