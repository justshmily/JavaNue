package stack;

public class Stack {

	private String[] data=new String[9];
	private int top=-1;
	
	public void push(String s) {
		data[++top]=s;
	}
	
	public String pop() {
		String s=data[top--];
		return s;
	}
	
	public String peek() {
		return data[top];
	}
	public int size() {
		return top+1;
	}
	public void clear() {
		top=-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	
}
