package csust.txr.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassDemo2 {

	public static void main(String[] args) {
	
		Class clazz=User.class;
		
		//1、构造方法（公共的）
		Constructor<User>[] cst=clazz.getConstructors();
		for(Constructor<User> c:cst) {
			System.out.println(c);
			System.out.println("--------------------------");
		}
		System.out.println("******************************");
		//公共与私有的构造方法
		cst=clazz.getDeclaredConstructors();
		for(Constructor<User> c:cst) {
			System.out.println(c);
			System.out.println("--------------------------");
		}
		System.out.println("******************************");
		
		//2、方法
		//公共的方法，包括继承下来的方法
		Method[] ms=clazz.getMethods();
		for (Method m : ms) {
			System.out.println(m);
			System.out.println("-----------------------------------------");
		}
		System.out.println("****************************************");
		
		//本类的所有成员方法*公共与私有
		ms=clazz.getDeclaredMethods();
		for (Method m : ms) {
			System.out.println(m);
			System.out.println("-----------------------------------------");
		}
		System.out.println("****************************************");
		
	}

}
