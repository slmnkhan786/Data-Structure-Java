package Stack;

import java.util.*;

import Queue.CircularArrayQueue;

public class StackUsingQueuePopEff {

	Queue<Integer> primary;
	Queue<Integer> secondary;

	public StackUsingQueuePopEff() {
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
		secondary.add(item);
		while (!primary.isEmpty()) {
			secondary.add(primary.poll());
		}
		Queue<Integer> temp = primary;
		primary = secondary;
		secondary = temp;
	}

	public void pop() {
		primary.poll();
	}

	public int top() {
		return primary.peek();
	}

	public void display() {
		while (!primary.isEmpty()) {
			System.out.print(primary.peek() + " ");
			secondary.add(primary.poll());
		}
		System.out.println();
		primary = secondary;
		secondary = new LinkedList<>();
	}

}
