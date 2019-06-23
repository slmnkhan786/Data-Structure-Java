package Stack_Queue;

import java.util.*;

public class StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Stack stack = new Stack();

		for (int i = 1; i <= 5; i++) {
			stack.push(10 * i);
		}

		stack.display();

		for (int i = 1; i <= 5; i++) {
			stack.pop();
		}

		stack.display();

	}

}
