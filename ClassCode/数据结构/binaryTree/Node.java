package binaryTree;

public class Node {

	Node left;
	Node right;
	
	int data;
	
	public Node(int data) {
		super();
		this.data=data;
		left=null;
		right=null;
	}
	public Node(int data,Node left,Node right) {
		super();
		this.data=data;
		this.left=left;
		this.right=right;
	}
}
