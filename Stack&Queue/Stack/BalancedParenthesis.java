package Stack;

import java.util.*;

public class BalancedParenthesis {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
//		System.out.println(isBalanced(s));
//		System.out.println(maxLength(s));
		
		System.out.println(isValidParenthesis(s));
	}

	static boolean isBalanced(String s) {
		boolean isbalance = true;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
			}
		}

		return isbalance;
	}

	static boolean isValidParenthesis(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					switch (c) {
					case '}':
						if (stack.pop() != '{')
							return false;
						break;
					case ')':
						if (stack.pop() != '(')
							return false;
						break;
					case ']':
						if (stack.pop() != '[')
							return false;
						break;

					}
				} else
					return false;
			}
		}
		return true;
	}

	static int maxLength(String S) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();

		stack.push(-1);
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty())
					stack.pop();
				if (!stack.isEmpty())
					max = Math.max(max, i - stack.peek());
				else
					stack.push(i);
			}

		}
		return max;
	}

}
