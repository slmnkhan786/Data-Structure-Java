package DynamicProgramming;

import java.util.*;

public class BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int strg[] = new int[n + 1];
		//System.out.println(cbpRS(0, n, strg));
		System.out.println(cbpIS(n));
	}

	public static int cbpRS(int cur, int end, int[] strg) {
		if (cur == end)
			return 1;

		if (cur > end)
			return 0;

		if (strg[cur] != 0)
			return strg[cur];

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += cbpRS(cur + dice, end, strg);
		}
		strg[cur] = count;

		return strg[cur];

	}

	public static int cbpIS(int n) {

		int strg[] = new int[n + 1];
		strg[n] = 1;

		for (int i = n-1; i >= 0; i--) {
			
			for (int dice = 1; dice <= 6 && (dice+i)<strg.length; dice++) {
				
				strg[i]+=strg[i+dice];

			}
		}

		return strg[0];

	}

}
