package DynamicProgramming;

import java.util.*;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();

		int T[][] = new int[str1.length() + 1][str2.length() + 1];

		System.out.println(longestCommonSubstring(str1, str2, T));

	}

	public static int longestCommonSubstring(String str1, String str2, int[][] W) {

		int row = str1.length() + 1;
		int col = str2.length() + 1;
		int max = -100000;

		for (int i = 1; i < row; i++) {

			for (int j = 1; j < col; j++) {

				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					W[i][j] = W[i - 1][j - 1] + 1;
				}
				if (max < W[i][j])
					max = W[i][j];

			}

		}

		return max;

	}

}
