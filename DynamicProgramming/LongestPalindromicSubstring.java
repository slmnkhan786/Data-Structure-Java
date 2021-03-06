package DynamicProgramming;

import java.util.*;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = "";
		
		for (int i = str1.length() - 1; i >= 0; i--) {
			str2 += str1.charAt(i);
		}
		
		int T[][] = new int[str1.length() + 1][str2.length() + 1];

		System.out.println(longestPalindromicSubstring(str1, str2, T));

	}

	public static int longestPalindromicSubstring(String str1, String str2, int[][] W) {

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
