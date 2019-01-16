package Tree;

public class BTClient {

	public static void main(String[] args) {
		// 50 true 40 true 30 false false true 60 false false true 70 false false
		BinaryTree bt = new BinaryTree();
		bt.display();
		System.out.println(bt.height());
		System.out.println(bt.max());
		System.out.println(bt.size());
		System.out.println(bt.find(30));
		System.out.println(bt.find(100));
		bt.preOrder();
		bt.postOrder();
		bt.inOrder();
		//bt.levelOrder();
		bt.levelOrderZZ();
	}

}
