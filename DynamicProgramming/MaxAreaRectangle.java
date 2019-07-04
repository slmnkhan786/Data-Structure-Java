package DynamicProgramming;

import java.util.*;

public class MaxAreaRectangle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		int arr[][] = new int[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++)

				arr[i][j] = sc.nextInt();

		}

		System.out.println(maxAreaRectangle(arr, row, col));

	}

	private static int maxAreaRectangle(int[][] arr, int row, int col) {
		int max = -1;

		int temp[] = new int[col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				if (arr[i][j] == 0)
					temp[j] = 0;

				else
					temp[j] += arr[i][j];

			}

			int area = maxAreaHistogram(temp);

			if (area > max)
				max = area;

		}

		return max;
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

		while ( !stack.isEmpty()) {

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
