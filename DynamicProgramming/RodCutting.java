package DynamicProgramming;

import java.util.*;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int prof[] = new int[n];
		int piece[] = new int[n];

		for (int i = 0; i < n; i++) {
			prof[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			piece[i] = sc.nextInt();
		}

		int len = sc.nextInt();

		int W[][] = new int[n + 1][len + 1];
		System.out.println(maxProfit(prof, piece, W));

	}

	public static int maxProfit(int[] prof, int[] piece, int[][] W) {

		int row = prof.length + 1;
		int col = W[0].length;

		for (int i = 1; i < row; i++) {

			for (int w = 1; w < col; w++) {

				if (w - piece[i - 1] >= 0) {
					W[i][w] = Math.max(W[i - 1][w], W[i - 1][w - piece[i - 1]] + prof[i - 1]);
				}

				else {
					W[i][w] = W[i - 1][w];

				}

			}

		}

		// which weights included
		int rem_prof = W[row - 1][col - 1];
		row--;
		int x[] = new int[row];

		for (int i = row; i > 0; i--) {

			int flag = 1;

			for (int j = col - 1; j >= 0; j--) {

				if (rem_prof == 0 || W[i - 1][j] == rem_prof) {
					flag = 0;
					break;
				}

			}

			if (rem_prof != 0 && flag == 1) {
				x[i - 1] = 1;
				rem_prof -= prof[i - 1];
			}

		}

		for (int i = 0; i < row; i++) {
			if (x[i] == 1)
				System.out.print(piece[i] + " ");
		}

		System.out.println();

		return W[row][col - 1];

	}

}
