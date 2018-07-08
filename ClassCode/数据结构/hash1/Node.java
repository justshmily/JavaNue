package hash1;

public class Node {

	//数据
	int data;
	//左子树
	Node left;
	//右子树
	Node right;
	
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
