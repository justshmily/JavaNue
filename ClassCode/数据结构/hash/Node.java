package hash;

public class Node {

	Node prev;
	Node next;
	int data;
	public Node() {
		
	}
	public Node(int data,Node prev,Node next) {
		this.data=data;
		this.prev=prev;
		this.next=next;
	}
}
