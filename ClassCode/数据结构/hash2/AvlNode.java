package hash2;

public class AvlNode {

	int data;
	
	AvlNode left;
	
	AvlNode right;
	
	int deep;
	
	public AvlNode(int data,int deep){
		this.data=data;
		this.deep=deep;
	}
	
	public AvlNode(int data,AvlNode left,AvlNode right,int deep) {
		this.data=data;
		this.left=left;
		this.right=right;
		this.deep=deep;
	}
}
