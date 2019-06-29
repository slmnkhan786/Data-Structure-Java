package Tree;

public class AVLTree {

	private class Node {
		int data;
		Node left;
		Node right;
		int height;
	}

	private Node root;

	// insert node in AVL Tree

	public void insert(int item) {
		this.root = insert(this.root, item);
	}

	private Node insert(Node node, int item) {
		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}

		if (node.data >= item) {
			node.left = insert(node.left, item);
		} else if (node.data < item) {
			node.right = insert(node.right, item);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		int bf = bf(node);

		// case LL
		if (bf > 1 && item < node.left.data) {
			return rightRotate(node);
		}

		// case RR
		if (bf < -1 && item > node.right.data) {
			return leftRotate(node);
		}

		// case LR
		if (bf > 1 && item > node.left.data) {
			
			node.left = leftRotate(node.left);
			return rightRotate(node);

		}

		// case RL
		if (bf < -1 && item < node.right.data) {
			
			node.right = rightRotate(node.right);
			return leftRotate(node);

		}

		return node;
	}

	// right rotation

	private Node rightRotate(Node node) {

		Node b = node.left;
		Node t = node.left.right;

		b.right = node;
		node.left = t;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;

	}

	// left rotation

	private Node leftRotate(Node node) {

		Node b = node.right;
		Node t = node.right.left;

		b.left = node;
		node.right = t;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;

	}

	// height

	private int height(Node node) {
		if (node == null)
			return -1;

		return node.height;

	}

	// balancing factor

	private int bf(Node node) {
		if (node == null)
			return 0;

		return height(node.left) - height(node.right);
	}

	// display AVL Tree

	public void display() {
		display(this.root);
	}

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

}
