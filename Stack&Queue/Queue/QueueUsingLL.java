package Queue;

import java.util.LinkedList;

public class QueueUsingLL {

	private LinkedList<Integer> queue;

	public static int CAPACITY = 10;

	public QueueUsingLL() {
		queue = new LinkedList<>();
	}

	private boolean isEmpty() {
		return this.queue.isEmpty();
	}

	private void enqueue(int item) {
		this.queue.addLast(item);
	}

	private void dequeue() {
		this.queue.removeFirst();
	}

	private int getFront() {
		return this.queue.getFirst();
	}

	public static void main(String[] args) {
		QueueUsingLL queue = new QueueUsingLL();
		for (int i = 1; i < 15; i++) {
			queue.enqueue(i * 10);
		}
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		while (!queue.isEmpty()) {
			System.out.println(queue.getFront());
			queue.dequeue();
		}

	}
	
	

}
