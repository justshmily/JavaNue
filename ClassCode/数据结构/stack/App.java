package stack;

public class App {

	public static void main(String[] args) {
		Stack stack=new Stack();
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		stack.push("00");
		stack.push("01");
		stack.push("10");
		stack.push("11");
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
	}
}
