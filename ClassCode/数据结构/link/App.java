package link;

public class App {

	public static void main(String[] args) {
		Link link=new Link();
		System.out.println(link.size());
		link.add("00");
		link.add("01");
		link.add("10");
		link.add("11");
		System.out.println(link.size());
		System.out.println(link.get(0));
		System.out.println(link.get(1));
		System.out.println(link.get(2));
		System.out.println(link.remove(1));
		System.out.println(link.get(0));
		System.out.println(link.get(2));
	}
}
