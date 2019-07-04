package DynamicProgramming;

import java.util.*;

public class StairCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] strg = new int[n+1];

		System.out.println(noSteps(n, strg));

	}

	public static int noSteps(int n, int[] strg) {
		if (n == 0 || n == 1)
			return 1;

		if (strg[n] != 0)
			return strg[n];

		int one_step = noSteps(n - 1, strg);
		int two_step = noSteps(n - 2, strg);

		strg[n] = one_step + two_step;

		return strg[n];

	}

}
