package csust.txr.weibo;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		
		//集合类9(标准库封装好的类)
		//长度自动增长的数组
		//容器
		//<>元素的类型，只能是引用类型，不能是基本类型(8类)
		
		ArrayList<User> list=new ArrayList<>();
		
		User u1=new User("alice");
		list.add(u1);
		list.add(u1);
		list.add(new User("bob"));
		System.out.println(list.size());
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
	}
}
