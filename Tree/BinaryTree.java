package Tree;

import java.util.*;

public class BinaryTree {
	private static final Boolean True = null;
	private static final Boolean False = null;
	static Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	BinaryTree() {
		this.root = takeInput(null, false);
	}

	// Creating Binary Tree
	private Node takeInput(Node parent, Boolean ilc) {
		if (parent == null)
			System.out.println("Enter the root node data : ");
		else {
			if (ilc)
				System.out.println("Enter the left child of " + parent.data);
			else
				System.out.println("Enter the right child of " + parent.data);
		}
		int data = sc.nextInt();
		Node nn = new Node();
		nn.data = data;

		System.out.println(nn.data + " has left child ?");
		boolean lc = sc.nextBoolean();
		if (lc)
			nn.left = takeInput(nn, true);

		System.out.println(nn.data + " has right child ?");
		boolean rc = sc.nextBoolean();
		if (rc)
			nn.right = takeInput(nn, false);
		return nn;

	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node == null)
			return;
		String str = "";
		if (node.left == null)
			str += "END" + "=>";
		else
			str += node.left.data + "=>";
		str += node.data;

		if (node.right == null)
			str += "<=" + "END";
		else
			str += "<=" + node.right.data;
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	// Height of a Tree
	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		int lh = height(node.left);
		int rh = height(node.right);

		return Math.max(lh, rh) + 1;
	}

	// Max element in Tree
	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int max = node.data;
		int lm = max(node.left);
		int rm = max(node.right);
		return Math.max(max, Math.max(lm, rm));
	}

	// Size of Tree
	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		int ls = size(node.left);
		int rs = size(node.right);
		return ls + rs + 1;
	}

	// Find element in tree
	public boolean find(int item) {
		return find(item, this.root);
	}

	private boolean find(int item, Node node) {
		if (node == null)
			return false;
		if (node.data == item)
			return true;
		boolean lr = find(item, node.left);
		boolean rr = find(item, node.right);
		if (lr || rr)
			return true;
		return false;
	}

	// Preorder traversal
	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node == null)
			return;
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	// Postorder traversal
	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
	}

	// Inorder traversal
	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}

	// level order Traversal
	public void levelOrder() {
		levelOrder(this.root);
	}

	private void levelOrder(Node node) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(node);
		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			if (rn != null) {
				System.out.print(rn.data + " ");
				if (rn.left != null)
					queue.addLast(rn.left);
				if (rn.right != null)
					queue.addLast(rn.right);
			}
		}
	}

	// level order Traversal Zigzag
	
	public void levelOrderZZ() {
		levelOrderZZ(this.root);
	}

	private void levelOrderZZ(Node node) {
		int count = 0;
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		queue.addLast(node);
		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			if (rn != null) {
				System.out.print(rn.data + " ");
				if (count % 2 != 0) {
					if (rn.left != null)
						helper.addLast(rn.left);
					if (rn.right != null)
						helper.addLast(rn.right);
				} else {
					if (rn.right != null)
						helper.addLast(rn.right);
					if (rn.left != null)
						helper.addLast(rn.left);
				}
			}
			if (queue.isEmpty()) {
				queue = helper;
				helper = new LinkedList<>();
				count++;
			}
		}
	}
	
	// Tree right view

	public void rightView() {
		this.rightView(this.root);
	}

	private void rightView(Node parent) {

		LinkedList<Node> helper = new LinkedList<>();
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(parent);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();

			if (rn.left != null)
				helper.addLast(rn.left);

			if (rn.right != null)
				helper.addLast(rn.right);

			if (queue.isEmpty()) {
				System.out.println(rn.data);
				queue = helper;
				helper = new LinkedList<>();
			}

		}
	}
	
	
	//Tree top view
	
	public void topView() {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		this.topView(this.root, 0, map);

		TreeMap<Integer, ArrayList<Integer>> map1 = new TreeMap<>(map);

		for (Integer key : map1.keySet())
			System.out.print(map1.get(key).get(0) + " ");
		System.out.println();

	}

	private void topView(Node parent, int idx, HashMap<Integer, ArrayList<Integer>> map) {

		if (parent == null)
			return;

		if (map.containsKey(idx)) {
			ArrayList<Integer> list = map.get(idx);
			list.add(parent.data);
			map.put(idx, list);
		} else {
			ArrayList<Integer> list = new ArrayList<>();
			;
			list.add(parent.data);
			map.put(idx, list);
		}

		topView(parent.left, idx - 1, map);
		topView(parent.right, idx + 1, map);

	}
	
	//Tree bottom view
	
		public void bottomView() {
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			
			this.bottomView(this.root, 0, map);

			TreeMap<Integer, ArrayList<Integer>> map1 = new TreeMap<>(map);

			for (Integer key : map1.keySet())
				System.out.print(map1.get(key).get(map1.get(key).size()-1) + " ");
			System.out.println();

		}

		private void bottomView(Node parent, int idx, HashMap<Integer, ArrayList<Integer>> map) {

			if (parent == null)
				return;

			if (map.containsKey(idx)) {
				ArrayList<Integer> list = map.get(idx);
				list.add(parent.data);
				map.put(idx, list);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				;
				list.add(parent.data);
				map.put(idx, list);
			}

			topView(parent.left, idx - 1, map);
			topView(parent.right, idx + 1, map);

		}
}
