package DynamicProgramming;

import java.util.*;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(editDistanceR(s1, s2));
		System.out.println(editDistanceI(s1,s2));

	}

	public static int editDistanceR(String s1, String s2) {

		if (s1.length() == 0)
			return s2.length();
		if (s2.length() == 0)
			return s1.length();

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;

		if (s1.charAt(0) == s2.charAt(0)) {
			ans = editDistanceR(ros1, ros2);
		}

		else {
			int f1 = editDistanceR(ros1, ros2)+1;
			int f2 = editDistanceR(s1, ros2)+1;
			int f3 = editDistanceR(ros1, s2)+1;
			ans = Math.min(f3, Math.min(f1, f2));
		}

		return ans;
	}
	
	public static int editDistanceI(String str1, String str2) {

		int strg[][] = new int[str1.length() + 1][str2.length() + 1];

		for(int i=0;i<str1.length();i++)
		{
			strg[i][str2.length()]=str1.length()-i;
		}
		
		for(int i=0;i<str2.length();i++)
		{
			strg[str1.length()][i]=str2.length()-i;
		}
		
		for (int i = str1.length()-1; i >= 0; i--) {
			for (int j = str2.length()-1; j >= 0; j--) {

				if (str1.charAt(i) == str2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1];
				} else {
					strg[i][j] = Math.min(strg[i+1][j+1]+1,Math.min(strg[i][j + 1]+1, strg[i + 1][j]+1));
				}
			}
		}

		return strg[0][0];

	}

}
