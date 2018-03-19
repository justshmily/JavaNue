package csust.txr.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 创建对象，调用方法
 * 
 * @author 15295
 *
 */
public class ClassDemo3 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		// 1、得到Class对象
		Class clazz = Class.forName("csust.txr.reflect.User");

		// 2、创建实例
		// 2.1、调用不带参数的构造方法
		Object obj = clazz.newInstance();
		// 2.2、调用带参数的构造方法
		Constructor<User> ct = clazz.getConstructor(String.class);
		Object obj2 = ct.newInstance("拉拉");

		// 传统做法：
		// User user=new User()
		// User user2=new User("张弛")
		
		//3、调用方法
		//3.1、得到方法所对应的Method实例
		Method m=clazz.getMethod("prtInfo", String.class,String.class);
		//3.2、调用prtInfo()方法
		Object rtn=m.invoke(obj2, "lala","拉拉");
		
		 //传统调用：user2.prtInfo("zhangci","张驰")
		
		//4、使用属性（为属性赋值，获取属性的值）
	    //4.1获取Field实例
		Field field=clazz.getDeclaredField("username");
		//4.2、赋值
		field.setAccessible(true);//取消访问权限检查
		field.set(obj2, "hh");
		//取值
		Object value=field.get(obj2);
		System.out.println(field+" value:"+value);

	    System.out.println("obj1:"+field.get(obj));
	}
}
