package queue;

public class App {

	public static void main(String[] args) {
		Queue queue=new Queue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		queue.add("00");
		queue.add("01");
		queue.add("10");
		queue.add("11");
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
	}
}
