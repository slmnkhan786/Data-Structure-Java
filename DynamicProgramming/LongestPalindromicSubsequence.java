package DynamicProgramming;

import java.util.*;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2="";
		
		for(int i=str1.length()-1;i>=0;i--)
		{
			str2+=str1.charAt(i);
		}
		 System.out.println(lcsR(str1, str2));
		System.out.println(lcsI(str1, str2));

	}

	public static int lcsR(String str1, String str2) {

		if (str1.length() == 0 || str2.length() == 0)
			return 0;

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		int count = 0;

		if (str1.charAt(0) == str2.charAt(0)) {
			count = lcsR(ros1, ros2) + 1;
		} else {
			int f1 = lcsR(str1, ros2);
			int f2 = lcsR(ros1, str2);
			count = Math.max(f1, f2);
		}
		return count;

	}

	public static int lcsI(String str1, String str2) {

		int strg[][] = new int[str1.length() + 1][str2.length() + 1];

		for (int i = str1.length(); i >= 0; i--) {
			for (int j = str2.length(); j >= 0; j--) {

				if (i == str1.length() || j == str2.length()) {
					strg[i][j] = 0;
					continue;
				}

				if (str1.charAt(i) == str2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {
					strg[i][j] = Math.max(strg[i][j + 1], strg[i + 1][j]);
				}
			}
		}

		return strg[0][0];

	}

}
