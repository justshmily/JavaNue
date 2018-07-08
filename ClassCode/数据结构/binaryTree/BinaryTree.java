package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node root = null;

	int size=0;
	
	/**
	 * 判断数是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * 添加
	 * 
	 * @param e
	 */
	public void add(int e) {
		if(root==null) {
			root=new Node(e);
		}
		else {
			add(root,e);
		}
	}

	private void add(Node node, int e) {
		
		if(e<node.data) {
			if(node.left==null) {
				node.left=new Node(e);
			}else {
				add(node.left ,e);
			}
		}else {
			if(node.right==null) {
				node.right=new Node(e);
			}else {
				add(node.right ,e);
			}
		}
	}
	
	/**
	 * 删除
	 * 
	 * @param e
	 */
	public void remove(int e) {
		if(!contain(e,root)) {
			System.out.println(e+"不存在");
		}
		
		BinaryTree bi=new BinaryTree();
		
        Queue<Node> q=new LinkedList<Node>();  
        q.add(this.root);  
        while(!q.isEmpty()){  
            Node temp =  q.poll(); 
            if(temp.data!=e)
            	bi.add(temp.data);
            if(temp.left!=null)
            	q.add(temp.left);  
            if(temp.right!=null)
            	q.add(temp.right);  
        }
        this.root=bi.root;
	}

	/**
	 * 判断数据是否存在
	 * 
	 * @param e
	 * @return
	 */
	public boolean contain(int e) {
		return contain(e, root);
	}

	public boolean contain(int e, Node node) {
		if (node.data == e) {
			return true;
		}

		if (e < node.data) {
			return node.left == null ? false : contain(e,node.left);
		} else {
			return node.right ==null ? false : contain(e, node.right);
		}
	}
	
	
	/**
	 * 先序遍历
	 */
	public void previous() {
		System.out.print("先序遍历：");
		if(isEmpty())
			System.out.println("null");
		else {
			previous(root);
		}
		System.out.println();
	}
	
	public void previous(Node node) {
		System.out.print(node.data+" ");
		if(node.left!=null)
			previous(node.left);
		if(node.right!=null)
			previous(node.right);
	}
	
	
	/**
	 * 中序遍历
	 */
	public void middle() {
		System.out.print("中序遍历：");
		if(isEmpty())
			System.out.println("null");
		else {
			middle(root);
		}
		System.out.println();
	}
	
	public void middle(Node node) {
		if(node.left!=null)
			middle(node.left);
		System.out.print(node.data+" ");
		if(node.right!=null)
			middle(node.right);
	}
	
	/**
	 * 后序遍历
	 */
	public void back() {
		System.out.print("后序遍历：");
		if(isEmpty())
			System.out.println("null");
		else {
			back(root);
		}
		System.out.println();
	}
	
	public void back(Node node) {
		if(node.left!=null)
			back(node.left);
		if(node.right!=null)
			back(node.right);
		System.out.print(node.data+" ");
	}
	
	/**
	 * 翻转
	 */
    public void reverseTree() {
    	reverseTree(root);
    }

	private void reverseTree(Node node) {
		if(node!=null) {
			Node temp=node.left;
			node.left=node.right;
			node.right=temp;
			reverseTree(node.left);
			reverseTree(node.right);
		}
	}

}
