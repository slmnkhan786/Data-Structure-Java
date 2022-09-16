package Queue;

import java.util.*;

public class MaxElementEveryWindow {

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
			if (!q.isEmpty() && a[i] >= a[q.getLast()])
				q.removeLast();
			q.addLast(i);
		}

		for (;i < a.length; i++) {
			System.out.print(a[q.getFirst()] + " ");

			while (!q.isEmpty() && q.getFirst() <= i - k)
				q.removeFirst();

			if (!q.isEmpty() && a[i] >= a[q.getLast()])
				q.removeLast();
			q.addLast(i);
		}

		System.out.print(a[q.getFirst()] + " ");

	}

}
