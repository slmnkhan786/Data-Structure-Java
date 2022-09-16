package Queue;

import java.util.*;

public class QueueUsingStackDequeueEff {
	Stack<Integer> primary;
	Stack<Integer> secondary;

	public QueueUsingStackDequeueEff() {
		primary = new Stack<>();
		secondary = new Stack<>();
	}

	public boolean isEmpty() {
		return this.primary.isEmpty();
	}

	public int size() {
		return this.primary.size();
	}

	public void enqueue(int item) {
		while (!primary.isEmpty()) {
			secondary.push(primary.pop());
		}
		primary.push(item);
		while (!secondary.isEmpty()) {
			primary.push(secondary.pop());
		}
	}

	public void dequeue() {
		primary.pop();
	}

	public int getFront() {
		return primary.peek();
	}

	public void display() {
		while (!primary.isEmpty()) {
			System.out.print(primary.peek() + " ");
			secondary.push(primary.pop());
		}
		System.out.println();
		while (!secondary.isEmpty()) {
			primary.push(secondary.pop());
		}

	}

}
