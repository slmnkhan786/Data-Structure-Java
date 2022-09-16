package Stack;

public class DynamicStack extends StackUsingArrays {

	public DynamicStack() {
		this(defaultSize);
	}

	public DynamicStack(int capacity) {
		super(capacity);
	}

	@Override
	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			int arr[] = new int[this.data.length * 2];
			for (int i = 0; i < this.data.length; i++)
				arr[i] = this.data[i];
			this.data = arr;
		}
		super.push(item);
	}

}
