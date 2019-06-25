package LinkedListL;

import L9_sep16.Queue;
import L_18.BinaryTree.Node;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// get first node data
	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.head.data;
	}

	// get last node data
	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.tail.data;
	}

	// get data of particular node
	public int getAt(int index) throws Exception {
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
	public void addLast(int item) {
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
	public void addFirst(int item) {
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
	public void addAt(int idx, int item) throws Exception {

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
	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		int temp = this.head.data;
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
	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		int temp = this.tail.data;
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
	public int removeAt(int idx) throws Exception {
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
	public void reverseDI() {

		Node temp1 = this.head;
		Node temp2 = null;
		while (temp1.next != null) {
			temp2 = temp1.next;
			while (temp2 != null) {
				int temp = temp1.data;
				temp1.data = temp2.data;
				temp2.data = temp;
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}

	}

	// Reversing LL Iteratively
	public void reversePI() {
		Node temp1 = this.head;
		Node temp2 = this.head.next;
		while (temp2 != null) {
			Node temp = temp2.next;
			temp2.next = temp1;
			temp1 = temp2;
			temp2 = temp;

		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void reversePR() {
		PRH(this.head, this.head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void PRH(Node prv, Node cur) {
		if (cur == null)
			return;
		PRH(cur, cur.next);
		cur.next = prv;
	}

	public void reverseDRReturn() {

		DRReturn(this.head, this.head, 0);

	}

	private Node DRReturn(Node left, Node right, int count) {
		if (right == null)
			return left;

		left = DRReturn(left, right.next, count + 1);
		if (count >= size / 2) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}
		return left.next;
	}

	private class HeapMover {
		private Node left = head;
	}

	public void reverseDRHeapMover() {
		HeapMover mover = new HeapMover();
		DRHeapMover(mover, head, 0);
	}

	private void DRHeapMover(HeapMover mover, Node right, int count) {
		if (right == null)
			return;
		DRHeapMover(mover, right.next, count + 1);
		if (count >= size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}
		mover.left = mover.left.next;
	}

	public int kthFromLast(int idx) throws Exception {
		Node slow = head;
		Node fast = head;
		for (int i = 1; i <= idx; i++)
			fast = fast.next;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;
	}

	public void fold() {
		HeapMover mover = new HeapMover();
		fold(mover, head, 0);
	}

	private void fold(HeapMover mover, Node right, int count) {
		if (right == null)
			return;
		fold(mover, right.next, count + 1);
		Node ahead = null;
		if (count > size / 2) {
			ahead = mover.left.next;
			mover.left.next = right;
			right.next = ahead;

		}
		if (count == size / 2) {
			tail = right;
			tail.next = null;
		}
		mover.left = ahead;
	}

	public int mid() {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}

	private Node midNode() {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public void kreverse(int k) throws Exception {
		LinkedList prv = null;
		while (this.size != 0) {
			LinkedList cur = new LinkedList();
			for (int i = 1; i <= k; i++) {
				cur.addFirst(this.removeFirst());
			}
			if (prv == null) {
				prv = cur;
			} else {
				prv.tail.next = cur.head;
				prv.tail = cur.tail;
				prv.size += cur.size;
			}

		}
		this.head = prv.head;
		this.tail = prv.tail;
		this.size = prv.size;
	}

	public LinkedList mergeTwoSortedLL(LinkedList other) {
		Node ttemp = this.head;
		Node otemp = other.head;
		LinkedList sorted=new LinkedList();
		while (ttemp != null && otemp != null) {
           if(ttemp.data<otemp.data)
           {
        	   sorted.addLast(ttemp.data);
        	   ttemp=ttemp.next;
           }
           else
           {
        	   sorted.addLast(otemp.data);
        	   otemp=otemp.next;
           }
		}
		while(ttemp!=null)
		{
			sorted.addLast(ttemp.data);
			ttemp=ttemp.next;
		}
		while(otemp!=null)
		{
			sorted.addLast(otemp.data);
			otemp=otemp.next;
		}
		return sorted;
	}
	public void mergeSort()
	{
		if(this.size==1)
			return;
		Node mid=this.midNode();
		Node midn=mid.next;
		LinkedList fh=new LinkedList();
		fh.head=this.head;
		fh.tail=mid;
		fh.tail.next=null;
		fh.size=(this.size+1)/2;
		LinkedList sh=new LinkedList();
		sh.head=midn;
		sh.tail=this.tail;
		sh.tail.next=null;
		sh.size=this.size/2;
		fh.mergeSort();
		sh.mergeSort();
		LinkedList list=fh.mergeTwoSortedLL(sh);
		this.head=list.head;
		this.tail=list.tail;
		this.size=list.size;
	}
   public void createdummyLL()
   {
	   Node n1=new Node();
	   n1.data=10;
	   Node n2=new Node();
	   n2.data=20;
	   Node n3=new Node();
	   n3.data=30;
	   Node n4=new Node();
	   n4.data=40;
	   
	   Node n5=new Node();
	   n5.data=50;
	   Node n6=new Node();
	   n6.data=60;
	   n1.next=n2;
	   n2.next=n3;
	   n3.next=n4;
	   n4.next=n5;
	   n5.next=n6;
	   n6.next=n3;
	   this.head=n1;
	   this.tail=null;
   }
	//removing cylce in ll
   public void removeLoop()
   {
	   Node slow=this.head;
	   Node fast=this.head;
	   while(fast!=null&&fast.next!=null)
	   {
		   slow=slow.next;
		   fast=fast.next.next;
		   if(slow==fast)
			   break;
	   }
	   if(slow==fast)
	   {
		   Node start=this.head;
		   while(start.next!=slow.next)
		   {
			   start=start.next;
			   slow=slow.next;
		   }
	   }
	   slow.next=null;
   }
	
	// Remove duplicates in sorted LL

	public void removeDuplicatesSortedLL() {

		Node prv = this.head;
		Node cur = this.head.next;

		while (cur != null) {

			if (cur.data == prv.data) {

				if (cur.next == null) {
					this.tail = prv;
					this.tail.next = null;
					cur = null;
				}

				else {
					cur = cur.next;
					prv.next = cur;
				}

				this.size--;
			}

			else {
				prv = cur;
				cur = cur.next;
			}
		}

	}

	// odd on left and even on right with maintaining order

	public void oddEven() throws Exception {

		Node cur = this.head;
		LinkedList ol = new LinkedList();
		LinkedList el = new LinkedList();

		while (cur != null) {
			if (cur.data % 2 == 0)
				el.addLast(cur.data);
			else
				ol.addLast(cur.data);

			cur = cur.next;
		}

		if (ol.size == this.size) {
			this.head = ol.head;
			this.tail = ol.tail;
		}

		else if (el.size == this.size) {
			this.tail = el.tail;
			this.head = el.head;
		}

		else {
			ol.tail.next = el.head;
			this.head = ol.head;
			this.tail = el.tail;
		}

	}

	// swap elements

	public void swapElements(int item1, int item2) throws Exception {

		Node temp = this.head;
		Node item1_pos = null;
		Node item2_pos = null;

		while (temp != null) {
			if (item2 == temp.data) {
				item2_pos = temp;
				break;
			}
			temp = temp.next;
		}

		temp = this.head;

		while (temp != null) {
			if (item1 == temp.data) {
				item1_pos = temp;
				break;
			}
			temp = temp.next;
		}

		if (item1_pos == null || item2_pos == null)
			throw new Exception("Element not present");

		int tmp = item1_pos.data;
		item1_pos.data = item2_pos.data;
		item2_pos.data = tmp;

	}

	// Append k elements from last to front of LL

	public void kAppend(int k) throws Exception {

		k = k % this.size;

		for (int i = 1; i <= k; i++) {
			this.addFirst(this.removeLast());
		}

	}
	
}
