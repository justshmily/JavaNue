package queue;

/**
 * 队列  FIFO
 *
 */
public class Queue {

	String[] data;
	int head=0;
	int tail=0;
	int size=9;
	
	public Queue() {
		data=new String [size];
	}
	public Queue(int size) {
		data=new String [size];
	}
	public void setSize(int size) {
		this.size=size;
	}
	//enqueue
	public void add(String s) {
		if(tail-head==size)
			System.out.println("duiman");
		data[tail++]=s;
	}
	
	public String poll() {
		return data[head++];
	}
	
	public String peek() {
		return data[head];
	}
	
	public int size() {
		if(!isEmpty())
			return tail-head;
		else return 0;
	}
	
	public void clear() {
		tail=0;
		head=0;
	}
	
	public boolean isEmpty() {
		return head==tail;
	}
	
}
