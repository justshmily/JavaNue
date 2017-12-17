package link;

/**
 * 双向链表
 * 
 * @author 谭笑然
 *
 */
public class Link implements AdtList{

	private int size;
	
	//头
	Node head;
	
	//尾
	Node tail;
	
	public Link() {
		size=0;
		head=new Node(null,null,null);
		tail=new Node(null,null,null);
		head.next=tail;
		tail.prev=head;
	}
	
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void clear() {
		size=0;
		//head.next=null;
		//tail.prev=null;
		head.next=tail;
		tail.prev=head;
	}

	@Override
	public void add(String data) {
//		if(head.next==null) {
//			Node node=new Node(data,head,tail);
//			head.next=node;
//			tail.prev=node;
//		}else {
//			//非空
			Node node=new Node(data, tail.prev, tail);
			tail.prev.next=node;
			tail.prev=node;
//		}
		size++;
	}

	@Override
	public void add(String data, int index) {
		if(index>=size) {
			throw new IndexOutOfBoundsException();
		}
		//目标位置节点
		Node target=getNode(index);
		Node node=new Node(data, target.prev, target);
		target.prev.next=node;
		target.prev=node;
		size++;
	}
	
	public Node getNode(int index) {
		if(index>=size)
			return null;
		
		Node node=head.next;
		for(int i=0;i<index;i++) {
			node =node.next;
		}
		
		return node;
	}

	@Override
	public String get(int index) {
		return getNode(index).data;
	}

	@Override
	public String remove(int index) {
		if(index>size) {
			throw new IndexOutOfBoundsException();
		}
		Node node=getNode(index);
		node.next.prev=node.prev;
		node.prev.next=node.next;
		size--;
		return node.data;
	}

	@Override
	public int size() {
		return size;
	}

}
