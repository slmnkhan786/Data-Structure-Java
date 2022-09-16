package Queue;

import java.util.*;

public class QueueUsingStackEnqueueEff {
	Stack<Integer> primary;
	Stack<Integer> secondary;

	public QueueUsingStackEnqueueEff() {
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
		this.primary.push(item);
	}

	public void dequeue() {

		while (primary.size() != 1) {
			secondary.push(primary.pop());
		}
		primary.pop();
		while (!secondary.isEmpty()) {
			primary.push(secondary.pop());
		}

	}

	public int getFront() {
		while (primary.size() != 1) {
			secondary.push(primary.pop());
		}
		int rv = primary.peek();
		secondary.push(primary.pop());
		while (!secondary.isEmpty()) {
			primary.push(secondary.pop());
		}
		return rv;
	}

	public void display() {
		while (!primary.isEmpty()) {
			secondary.push(primary.pop());
		}
		while (!secondary.isEmpty()) {
			System.out.print(secondary.peek() + " ");
			primary.push(secondary.pop());
		}
		System.out.println();
	}

}
