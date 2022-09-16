package Stack;

import java.util.*;

public class CloneStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		Stack<Integer> cloned = new Stack<>();
		st.add(1);
		st.add(2);
		st.add(3);
		clonestack(st, cloned);
		while (!cloned.isEmpty())
			System.out.print(cloned.pop() + " ");
	}

	static void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
		reverse(st);
		while (!st.isEmpty())
			cloned.push(st.pop());
	}

	static void reverse(Stack<Integer> st) {
		if (st.isEmpty())
			return;
		int item = st.pop();
		reverse(st);
		st.push(item);
	}

}
