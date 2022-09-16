package Stack;

public class StackClient {

	public static void main(String[] args) throws Exception {

		DynamicStack stack = new DynamicStack();

		try {
			for (int i = 1; i <= 12; i++) {
				stack.push(10 * i);
				System.out.println(stack.size());

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " " + stack.size());
		}

	}

}
