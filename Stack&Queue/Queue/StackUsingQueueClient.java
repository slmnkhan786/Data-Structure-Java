package Queue;

public class StackUsingQueueClient {
	public static void main(String[] args) {
		QueueUsingStackDequeueEff queue = new QueueUsingStackDequeueEff();
		for (int i = 1; i < 15; i++) {
			queue.enqueue(i * 10);
		}
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.display();
		while (!queue.isEmpty()) {
			System.out.println(queue.getFront());
			queue.dequeue();
		}

	}
}
