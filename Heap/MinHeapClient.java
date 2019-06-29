package HeapDemo;

public class MinHeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MinHeap heap = new MinHeap();

		heap.add(90);
		heap.add(80);
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(20);
		heap.add(10);
		System.out.println(heap.size());
		System.out.println(heap.isEmpty());
		heap.display();
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.get());
		heap.display();
	}

}
