package link;

public class Node {

	String data;
	Node next;
	Node prev;
	
	public Node(String data, Node head, Node tail) {
		this.data=data;
		this.next=tail;
		this.prev=head;
	}
}
