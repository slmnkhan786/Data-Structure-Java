package DynamicProgramming;

import java.util.*;

public class Histogram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		System.out.println(maxAreaHistogram(arr));

	}

	private static int maxAreaHistogram(int[] arr) {

		int top = 0;
		int area = 0;
		int max_area = -1;
		int i = 0;
		LinkedList<Integer> stack = new LinkedList<>();

		for (i = 0; i < arr.length;) {

			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.addFirst(i);
				i++;
			}

			else {

					top = stack.removeFirst();

					if (stack.isEmpty())
						area = arr[top] * i;
					else
						area = arr[top] * (i - stack.peek() - 1);

					if (area > max_area)
						max_area = area;

			}
		}

		while (!stack.isEmpty()) {

			top = stack.removeFirst();

			if (stack.isEmpty())
				area = arr[top] * i;
			else
				area = arr[top] * (i - stack.peek() - 1);

			if (area > max_area)
				max_area = area;

		}

		return max_area;

	}

}
