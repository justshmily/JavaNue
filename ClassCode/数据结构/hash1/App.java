package hash1;

public class App {

	public static void main(String[] args) {

		BinarySearchTree tree=new BinarySearchTree();
		System.out.println(tree.isEmpty());
		
		tree.add(27);
		tree.add(19);
		tree.add(38);
		tree.add(40);
		tree.add(23);
		tree.add(9);
		tree.add(30);
		tree.add(1);
		tree.add(35);
		
//		System.out.println(tree.size);
//		System.out.println(tree.isEmpty());
//		System.out.println(tree.contain(25));
//		System.out.println(tree.contain(11));
		
		//tree.clear();
//		System.out.println(tree.getMax().data);
//		System.out.println(tree.getMin().data);
//		
//		System.out.println("先序：");
//		tree.previous();
//		System.out.println("\n中序：");
//		tree.middle();
//		System.out.println("\n后序：");
//		tree.back();
		System.out.println("\n层序：");
		tree.level();
//		System.out.println("\n翻转：");
//		tree.reverseTree();
//		tree.middle();
		tree.remove(9);
		tree.level();
	}

}
