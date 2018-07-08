package hash2;

public class App {

	public static void main(String[] args) {

		AvlTreeImp1 avl=new AvlTreeImp1();
		avl.insert(14);
		avl.insert(5);
		avl.insert(9);
		avl.insert(25);
		avl.insert(7);
		
		avl.printTree();
	}

}
