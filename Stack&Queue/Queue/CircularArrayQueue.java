package Queue;

public class CircularArrayQueue {

	private int[] data;
	private int front;
	private int rear;
	private int cs;
	private int ms;

	public static int CAPACITY = 10;

	public CircularArrayQueue() {
		this(CAPACITY);
	}

	public CircularArrayQueue(int capacity) {
		this.data = new int[capacity];
		this.front = 0;
		this.rear = capacity - 1;
		this.cs = 0;
		this.ms = capacity;
	}

	private boolean isEmpty() {
		return this.cs == 0;
	}

	private boolean isFull() {
		return this.cs == this.ms;
	}

	private void enqueue(int item) {
		if (!this.isFull()) {
			this.rear = (this.rear + 1) % this.ms;
			this.data[this.rear] = item;
			this.cs++;
		}
	}

	private void dequeue() {
		if (!this.isEmpty()) {
			this.front = (this.front + 1) % this.ms;
			this.cs--;
		}
	}

	private void reverseQueue(CircularArrayQueue queue) {
		if (queue.isEmpty())
			return;
		int item = queue.getFront();
		queue.dequeue();
		reverseQueue(queue);
		queue.enqueue(item);
	}

	private int getFront() {
		return this.data[this.front];
	}

	public static void main(String[] args) {
		CircularArrayQueue queue = new CircularArrayQueue();
		for (int i = 1; i < 15; i++) {
			queue.enqueue(i * 10);
		}
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.reverseQueue(queue);
//		queue.reverseQueue(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.getFront());
			queue.dequeue();
		}
	}

}
