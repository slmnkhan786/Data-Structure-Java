package String;

import java.util.*;

public class PatternMatching2 {

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
		int pl = Pattern.length();2

		int count[] = new int[pl];

		if (pl > tl)
			return 0;

		int i = 0;

		HashMap<Character, Integer> map = new HashMap<>();

		for (; i < pl; i++) {
			char ch = Pattern.charAt(i);

			if (map.containsKey(ch)) {
				count[i] = map.get(ch);
			} else {
				count[i] = -1;
				map.put(ch, i);
			}
		}

		i = 0;
		int j = -1;

		while (i < tl) {

			j = -1;

			while (j < pl - 1 && i < tl) {

				if (Text.charAt(i) == Pattern.charAt(j + 1)) {
					i++;
					j++;
				}

				else {
					if (j == -1)
						i++;
					else {
						j = count[j];
					}
				}
			}

			if (j == pl - 1) {
				ans += 1;
			}

		}

		return ans;
	}

}
