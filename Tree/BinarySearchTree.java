package Tree;

public class BinarySearchTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;

	public BinarySearchTree(int[] arr) {
		this.root = constructBST(arr, 0, arr.length - 1);
	}

	private Node constructBST(int[] arr, int lo, int hi) {

		if (lo > hi)
			return null;

		int mid = (lo + hi) / 2;

		Node nn = new Node();

		nn.data = arr[mid];
		nn.left = constructBST(arr, lo, mid - 1);
		nn.right = constructBST(arr, mid + 1, hi);

		return nn;
	}

	public void display() {
		display(this.root);
	}

	//display bst
	private void display(Node node) {

		if (node == null)
			return;

		String ans = "";

		if (node.left == null)
			ans += ".";
		else
			ans += node.left.data;

		ans += "->";
		ans += node.data + "<-";

		if (node.right == null)
			ans += ".";
		else
			ans += node.right.data;

		System.out.println(ans);

		display(node.left);
		display(node.right);

	}

	//find item
	public boolean find(int item) {
		return this.find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (node.data > item)
			return find(node.left, item);

		else if (node.data < item)
			return find(node.right, item);

		else
			return true;

	}

	//find max in bst
	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {

		if (node.right == null)
			return node.data;

		return max(node.right);

	}

	public void add(int item) {
		this.add(this.root, item);
	}

	//add item in bst
	private void add(Node node, int item) {

		if (node.data < item) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else
				add(node.right, item);
		}

		else {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else
				add(node.left, item);
		}

	}

}
