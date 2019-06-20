package String;

import java.util.*;

public class PalindromicSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		palindromicSS(str);

	}

	public static void palindromicSS(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {

				String ss = str.substring(i, j);
				if (isPalindrome(ss))
					System.out.println(ss);
			}
		}
	}

	public static boolean isPalindrome(String str) {

		int start = 0;
		int end = str.length() - 1;

		while (start < end) {

			if (str.charAt(start) == str.charAt(end)) {
				end--;
				start++;
			}

			else
				return false;

		}

		return true;

	}

}
