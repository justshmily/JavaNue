package csust.txr.reflect;

public class ClassDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		// 获取Class实例

		// 1、
		User user = new User();
		Class clazz1 = user.getClass();

		// 2、
		Class clazz2 = User.class;

		// 3、
		Class clazz3 = Class.forName("csust.txr.reflect.User");

		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);

		// 包装类
		System.out.println(Integer.class);
		System.out.println(Integer.TYPE);
	}

}
