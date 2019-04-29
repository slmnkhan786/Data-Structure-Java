package Generic;

import L9_sep16.Queue;
import L_18.BinaryTree.Node;

public class LinkedList<T> {
	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// get first node data
	public T getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.head.data;
	}

	// get last node data
	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.tail.data;
	}

	// get data of particular node
	public T getAt(int index) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (index < 0 || this.size <= index) {
			throw new Exception("Invalid index");
		}
		Node temp = head;
		for (int i = 1; i <= index; i++)
			temp = temp.next;
		return temp.data;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	// Adding new node in LL at last
	public void addLast(T item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		if (size > 0)
			this.tail.next = nn;
		if (this.size == 0) {
			this.head = nn;
		}
		this.tail = nn;
		this.size++;
	}

	// Getting a node of given index
	private Node getNodeAt(int index) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (index < 0 || this.size <= index) {
			throw new Exception("Invalid index");
		}
		Node temp = head;
		for (int i = 1; i <= index; i++)
			temp = temp.next;
		return temp;
	}

	// Adding new node in LL at first
	public void addFirst(T item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		if (size > 0)
			nn.next = this.head;
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
		}
		this.head = nn;
		this.size++;
	}

	// Adding new node in LL at a given position
	public void addAt(int idx, T item) throws Exception {

		if (idx < 0 || this.size <= idx) {
			throw new Exception("Invalid index");
		}
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		if (this.size == 0) {
			this.addFirst(item);
		} else if (this.size == idx) {
			this.addLast(item);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			nn.next = nm1.next.next;
			nm1.next = nn;
			this.size++;
		}
	}

	// Removing first node of LL
	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		T temp = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			head = head.next;
			this.size--;
		}
		return temp;
	}

	// Removing last node of LL
	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		T temp = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node ptr = this.getNodeAt(this.size - 2);
			ptr.next = null;
			this.tail = ptr;
			this.size--;
		}
		return temp;
	}

	// Removing a given index node of LL
	public T removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (idx < 0 || this.size <= idx) {
			throw new Exception("Invalid index");
		}
		Node temp = null;
		if (idx == 0) {
			return this.removeFirst();
		} else if (this.size - 1 == idx) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			temp = nm1.next;
			nm1.next = nm1.next.next;

			this.size--;

		}
		return temp.data;

	}

	// Reversing LL Iteratively by swapping node data
	
}
