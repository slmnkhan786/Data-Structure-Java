package String;

import java.util.*;

public class PatternMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String Text = sc.nextLine();
		String Pattern = sc.next();

		System.out.println("No. of times Pattern matches : " + patternMatch(Text, Pattern));

	}

	public static int patternMatch(String Text, String Pattern) {
		int ans = 0;
		int tl = Text.length();
		int pl = Pattern.length();

		for (int i = 0; i <= tl - pl; i++) {

			int flag = 1;
			int j = 0;
			
			for (; j < pl; j++) {

				if (Text.charAt(i+j) == Pattern.charAt(j)) {
					continue;
				}

				flag = 0;
				break;

			}

			if (flag == 1 && j == pl)
				ans++;

		}

		return ans;
	}

}
