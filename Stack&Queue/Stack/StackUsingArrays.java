package Stack;

public class StackUsingArrays {

	protected int[] data;
	protected int top;
	protected static int defaultSize = 10;

	public StackUsingArrays() {
		this(defaultSize);
	}

	public StackUsingArrays(int capacity) {
		this.data = new int[capacity];
		this.top = -1;
	}

	public int size() {
		return this.top + 1;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void push(int val) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Stack is Full");
		}
		this.top++;
		this.data[top] = val;
	}

	public int pop() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Stack is Empty");
		}
		int rv = this.data[this.top];
		this.data[this.top] = 0;
		this.top--;
		return rv;
	}
}
