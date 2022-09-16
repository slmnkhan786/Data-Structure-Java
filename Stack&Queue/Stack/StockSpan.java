package Stack;

import java.util.*;

public class StockSpan {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		arr = calculateSpan(arr, n);

	}

	public static int[] calculateSpan(int price[], int n) {
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			 while(!stack.isEmpty() && price[i] >= price[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty())
				arr[i] = i + 1;
			else
				arr[i] = i - stack.peek();
			stack.push(i);

		}

		return arr;
	}

}
