package Tree;

public class BTClient {

	public static void main(String[] args) {
		// 50 true 40 true 30 false false true 60 false false true 70 false false
		//		 18 true 10 true 4 false false true 6 false false true 8 true 5 false false true 5 false false
		
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
		bt.levelOrder();
		bt.levelOrderZZ();
		bt.rightView();
		bt.leftView();
		bt.topView();
		bt.bottomView();
		System.out.println(bt.rootToLeafPath(60));
		bt.lowestCommonAncester(50,60);
		System.out.println(bt.sumOfNodes());
		System.out.println(bt.sumTree());
	}

}
