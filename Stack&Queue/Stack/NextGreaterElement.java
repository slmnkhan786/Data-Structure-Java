package Stack;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		long[] arr = new long[n];

		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				int rv = stack.pop();
				arr[rv] = arr[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}

	}

}
