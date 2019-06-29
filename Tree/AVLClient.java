package Tree;

public class AVLClient {

	public static void main(String[] args) {
		
		AVLTree avl = new AVLTree();
		avl.insert(20);
		avl.insert(25);
		avl.insert(30);
		avl.insert(10);
		avl.insert(5);
		avl.insert(15);
		avl.insert(27);
		avl.insert(19);
		avl.insert(16);
		avl.display();

	}

}
