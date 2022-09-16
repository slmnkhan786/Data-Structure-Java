package Stack;

import java.util.*;

public class StackUsingQueuePushEfficient {

	Queue<Integer> primary;
	Queue<Integer> secondary;

	public StackUsingQueuePushEfficient() {
		primary = new LinkedList<>();
		secondary = new LinkedList<>();
	}

	public int size() {
		return primary.size();
	}

	public boolean isEmpty() {
		return primary.isEmpty();
	}

	public void push(int item) {
		primary.add(item);
	}

	public void pop() {
		while (primary.size() != 1) {
			secondary.add(primary.poll());
		}
		primary.poll();
		Queue<Integer> temp = primary;
		primary = secondary;
		secondary = temp;
	}

	public int top() {
		while (primary.size() != 1) {
			secondary.add(primary.poll());
		}
		int rv = primary.poll();
		secondary.add(rv);
		Queue<Integer> temp = primary;
		primary = secondary;
		secondary = temp;
		return rv;
	}

	public void display() {
		reverseQueue(primary);
		while (!primary.isEmpty()) {
			System.out.print(primary.peek() + " ");
			secondary.add(primary.poll());
		}
		System.out.println();
		Queue<Integer> temp = primary;
		primary = secondary;
		secondary = temp;

		reverseQueue(primary);
	}

	private static void reverseQueue(Queue<Integer> queue) {
		if (queue.isEmpty())
			return;
		int item = queue.poll();
		reverseQueue(queue);
		queue.add(item);
	}
}
