package Stack;

public class StackUsingQueueClient {

	public static void main(String[] args) {

		StackUsingQueuePushEfficient stack = new StackUsingQueuePushEfficient();

		for (int i = 1; i < 10; i++) {
			stack.push(i * 10);
			System.out.println(stack.size());
		}

		stack.display();
		stack.pop();
		stack.pop();
	    stack.display();
		System.out.println(stack.size());

	}

}
