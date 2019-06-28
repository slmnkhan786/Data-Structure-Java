package Tree;

import java.util.*;

public class BSTClient {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		BinarySearchTree bst = new BinarySearchTree(arr);
		bst.display();
		System.out.println(bst.find(20));
		System.out.println(bst.max());
		bst.add(55);
		bst.add(27);
		bst.display();
		bst.remove(40);
		bst.display();

	}

}
