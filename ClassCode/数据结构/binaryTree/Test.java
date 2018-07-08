package binaryTree;

public class Test {

	public static void main(String[] args) {
		
		BinaryTree tree=new BinaryTree();
		
		tree.add(30);
		tree.add(15);
		tree.add(54);
		tree.add(32);
		tree.add(8);
		tree.add(22);
		tree.add(19);
		tree.previous();
		
		tree.add(25);
		System.out.print("\n添加后数的");
		tree.previous();
		
		tree.remove(25);
		System.out.print("删除后数的");
		tree.previous();
		
		tree.previous();
		tree.middle();
		tree.back();
		
		tree.reverseTree();
		System.out.print("\n反转后数的");
		tree.previous();
	}

}
