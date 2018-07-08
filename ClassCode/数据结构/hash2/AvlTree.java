package hash2;

/**
 * 平衡二分搜索树
 * 
 * @author 谭笑然
 *
 */
public interface AvlTree {

	void add(int n);
	
	AvlNode remove(int n);
	
	AvlNode find(int n);
	
	void midOrder();
	
	void reverse();
	
	boolean isEmpty();
	
	void clear();
	
}
