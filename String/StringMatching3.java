package String;

import java.util.*;

public class StringMatching3 {

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

		if (pl > tl)
			return 0;

		int hashcode = 0, val = 0;
		int mult1 = (int) Math.pow(10, pl - 1);
		int mult = mult1;
		
		for (int i = 0; i < pl; i++) {

			hashcode += mult * (Pattern.charAt(i) - 96);
			val += mult * (Text.charAt(i) - 96);
			mult /= 10;

		}

		for (int i = 1; i <= tl - pl + 1; i++) {

			val = (val - mult1 * (Text.charAt(i - 1) - 96)) * 10 + (Text.charAt(i + pl - 1) - 96);
			if (val == hashcode)
				ans += 1;

		}

		return ans;
	}

}
