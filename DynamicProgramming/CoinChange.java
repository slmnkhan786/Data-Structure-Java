package DynamicProgramming;

import java.util.*;

public class CoinChange {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int coins[] = new int[n];

		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}

		int total = sc.nextInt();

//		System.out.println(coinChangeMinSum(coins, total));

		System.out.println(coinChangeWays(coins, total));

	}

	public static int coinChangeMinSum(int[] coins, int total) {

		int T[] = new int[total + 1];
		int R[] = new int[total + 1];

		T[0] = 0;

		for (int i = 1; i <= total; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			R[i] = -1;
		}

		for (int i = 1; i <= total; i++) {

			for (int j = 0; j < coins.length; j++) {

				if (i >= coins[j]) {

					if (T[i - coins[j]] + 1 < T[i]) {

						T[i] = T[i - coins[j]] + 1;
						R[i] = j;

					}
				}

			}

		}

		printCoins(R, coins);

		return T[total];

	}

	public static void printCoins(int[] R, int[] coins) {

		int len = R.length - 1;

		if (R[len] == -1) {

			System.out.println("No Combination Possible");
			return;

		}

		System.out.print("Coins Used are : ");

		while (len > 0) {

			int j = R[len];
			System.out.print(coins[j] + " ");
			len = len - coins[j];

		}

		System.out.println();

	}

	public static int coinChangeWays(int[] coins, int total) {

		int T[][] = new int[coins.length + 1][total + 1];

		for (int i = 0; i < coins.length; i++) {
			T[i][0] = 1;
		}

		for (int i = 1; i <= coins.length; i++) {

			for (int j = 1; j <= total; j++) {

				if (j >= coins[i - 1]) {

					T[i][j] = T[i - 1][j] + T[i][j - coins[i - 1]];

				}

				else {

					T[i][j] = T[i - 1][j];

				}

			}

		}

		return T[coins.length][total];

	}

}
