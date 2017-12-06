package txr.odel;
/**
 * 单例
 * 
 * @author 谭笑然
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Singleleton {

	//类变量
	private static Singleleton instance;
	
	//成员变量
	List<String> users;
	
	//成员变量/实例变量
	Singleleton n;
	
	//成员变量
	
	//1  构造方法私有
	private Singleleton() {
		users=new ArrayList<>();
		users.add("alice");
		users.add("bob");
	}
	
	//2 通过类方法获得唯一的实例
	public static Singleleton getInstance() {
		if(instance==null) {
			instance=new Singleleton();
		}
		return instance;
	}
	
	public List<String> getUsers() {
		return users;
	}
	
	public void add(String user) {
		users.add(user);
	}
	public static void main(String[] args) {
//		Singleleton sig=Singleleton.getInstance();
//		Singleleton sig2=Singleleton.getInstance();
//		
//		System.out.println(sig==sig2);  //相等
		
		List<String> l1=Singleleton.getInstance().getUsers();
		System.out.println(l1);
	}
}
