package list;

public class App {

	public static void main(String[] args) {
		List list=new List();
		System.out.println(list.size());
		list.add("lll");
		list.add("hhhh");
		list.add("www");
		System.out.println(list.isEmpty());
		list.show();
		list.remove(1);
		list.show();
		list.add("mmmm",1);
		list.show();
		System.out.println(list.get(2));
	}
}
