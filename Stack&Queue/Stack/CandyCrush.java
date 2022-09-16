package Stack;

import java.util.*;

public class CandyCrush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int k = scn.nextInt();
		System.out.print(Reduced_String(k, s));
	}

	static String Reduced_String(int k, String s) {
		if(k==1)
			return "";
		StringBuilder s1= new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				count++;
				if (count == k)
					stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
		while(!stack.isEmpty())
		{
			 s1.append(stack.pop());
		}
		return s1.reverse().toString();
	}
}
