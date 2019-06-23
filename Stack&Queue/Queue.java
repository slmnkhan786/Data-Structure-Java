package L9_sep16;

import java.util.*;

public class Queue {
	protected int[] data;
	protected int f;
	protected int size;
	

	public Queue() {
		this.data = new int[5];
		this.f = 0;
		this.size=0;
	}

	public Queue(int cap) {
		this.data = new int[cap];
		this.f = 0;
		this.size=0;
	}

	public void enqueue(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Queue is full");
		}
		
		this.data[(this.f+this.size)%data.length] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		int num=this.data[this.f];
		this.f=(this.f+1)%data.length;
		 this.size--;
		 return num;
		
	}

	public int getFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is full");
		}
		return this.data[this.f];
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if(size==0)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		return this.size == this.data.length;
	}

	public void display() {
		if(this.isEmpty())
		{
		System.out.println("Queue is Empty");
		return
	}
       for(int i=0;i<size;i++)
        {
	  System.out.println(this.data[(i+this.f)%data.length]);
        }
}

	

	
}
