package hash1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树
 * 
 * @author 谭笑然
 *
 */
public class BinarySearchTree {

	// 根
	Node root = null;

	// 节点数
	int size = 0;

	/**
	 * 是否为空树
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * 清空树
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	public void add(int e) {
		if (root == null) {
			root = new Node(e);
		} else {
			add(e, root);
		}
		size++;
	}

	private void add(int e, Node parent) {
		Node node = new Node(e);

		// 存在根节点
		if (e < parent.data) {
			// 左
			if (parent.left == null) {
				parent.left = node;
			} else {
				// 递归
				add(e, parent.left);
			}

		} else {
			// 右
			if (parent.right == null) {
				parent.right = node;
			} else {
				add(e, parent.right);
			}
		}
	}

	public boolean contain(int e) {
		return contain(e, root);
	}

	public boolean contain(int e, Node parent) {
		if (parent.data == e) {
			return true;
		}

		if (e < parent.data) {
			if (parent.left == null) {
				return false;
			} else {
				return contain(e, parent.left);
			}
		} else {
			return parent.right == null ? false : contain(e, parent.right);
		}
	}

	/**
	 * 
	 * @return 返回最大值或null(树为null时)
	 */
	public Node getMax() {
		return getMax(root);
	}

	private Node getMax(Node node) {
		if (node == null)
			return null;
		return node.right==null?node:getMax(node.right);
	}

	public Node getMin() {
		if (root == null){
			return null;
		}
		Node node = root;
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public void previous() {
		if(isEmpty())
			System.out.println("null");
		else {
			previous(root);
		}
	}
	public void previous(Node node) {
		System.out.print(node.data+" ");
		if(node.left!=null)
			previous(node.left);
		if(node.right!=null)
			previous(node.right);
	}
	
	public void middle() {
		if(isEmpty())
			System.out.println("null");
		else {
			middle(root);
		}
	}
	
	public void middle(Node node) {
		if(node.left!=null)
			middle(node.left);
		System.out.print(node.data+" ");
		if(node.right!=null)
			middle(node.right);
	}
	
	public void back() {
		if(isEmpty())
			System.out.println("null");
		else {
			back(root);
		}
	}
	
	public void back(Node node) {
		if(node.left!=null)
			back(node.left);
		if(node.right!=null)
			back(node.right);
		System.out.print(node.data+" ");
	}
	
	/** 
     *  
     * @param root 树根节点 
     * 层序遍历二叉树，用队列实现，先将根节点入队列，只要队列不为空，然后出队列，并访问，
     * 接着讲访问节点的左右子树依次入队列 
     */  
    public void level(){  
        if(isEmpty()) {
        	System.out.println("树空");
        	return;  
        }
        Queue<Node> q=new LinkedList<Node>();  
        q.add(root);  
        while(!q.isEmpty()){  
            Node temp =  q.poll();  
            System.out.print(temp.data+" ");  
            if(temp.left!=null)
            	q.add(temp.left);  
            if(temp.right!=null)
            	q.add(temp.right);  
        }  
    }
    
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

	public void remove(int e) {
		if(contain(e,root)) {
			BinarySearchTree bi=new BinarySearchTree();
			
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
	}
}
