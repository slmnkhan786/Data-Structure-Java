package L9_sep16;

public class QueueClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.queue(10);
		q.queue(20);
		q.queue(30);
		q.queue(40);
		q.queue(50);
		q.queue(60);
		q.display();
		System.out.println(q.enqueue());
		System.out.println(q.enqueue());
		q.queue(60);
		q.queue(70);
		q.display();
	}

}
