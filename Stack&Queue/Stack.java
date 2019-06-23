package L9_sep16;

import java.util.*;

public class Stack {
	protected int[] data;
	protected int tos;

	public Stack() {
		this.data = new int[5];
		this.tos = -1;
	}

	public Stack(int cap) {
		this.data = new int[cap];
		this.tos = -1;
	}

	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Stack is full");
		}
		this.tos++;
		this.data[tos] = item;
	}

	public int pop() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Stack is empty");
		}
		int num = this.data[tos];
		this.tos--;
		return num;
		
	}

	public int peek() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Stack is full");
		}
		return this.data[tos];
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		if (this.tos == -1)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		return this.size() == this.data.length;
	}

	public void display() {
		
		if (this.size() == 0) {
			System.out.println("Stack is Empty");
			return;
		}
		
  for(int i=this.size()-1;i>=0;i--)
  {
	  System.out.println(this.data[i]);
  }
	}
}
