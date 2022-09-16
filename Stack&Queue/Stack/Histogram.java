package Stack;

import java.util.*;

public class Histogram {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		System.out.println(calculateArea(arr, n));
		System.out.println(histogram(arr, n));
	}

	public static int histogram(int arr[], int n) {
		Stack<Integer> stack = new Stack<>();
		int[] leftSmaller = new int[n];
		int[] rightSmaller = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty())
				leftSmaller[i] = 0;
			else
				leftSmaller[i] = stack.peek();
			stack.push(i);
		}

		stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty())
				rightSmaller[i] = n - 1;
			else
				rightSmaller[i] = stack.peek();
			stack.push(i);
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, arr[i] * (rightSmaller[i] - leftSmaller[i] - 1));
		}
		return ans;
	}

	public static int calculateArea(int arr[], int n) {
		Stack<Integer> stack = new Stack<>();
		int ans = 0;
		int i = 0;
		for (; i < n; i++) {
			while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {

				int rv = stack.pop();
				int width = 0;

				if (stack.isEmpty())
					width = i;
				else
					width = i - stack.peek() - 1;

				ans = Math.max(ans, arr[rv] * width);
			}

			stack.push(i);

		}

		while (!stack.isEmpty()) {
			int rv = stack.pop();
			int width = 0;

			if (stack.isEmpty())
				width = i;
			else
				width = i - stack.peek() - 1;

			ans = Math.max(ans, arr[rv] * width);
		}

		return ans;
	}

}
