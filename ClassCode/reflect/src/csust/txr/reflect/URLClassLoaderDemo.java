package csust.txr.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 15295
 *
 */
public class URLClassLoaderDemo {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		URL[] urls= {new URL("file://D:/ftp/classes/")};
		//类加载器
		URLClassLoader classLoader=new URLClassLoader(urls);
		
		//类对象
		Class clazz=classLoader.loadClass("csust.txr.reflect.User");//包名+类名
		
		//创建csust.txr.reflect.User类的实例
		//obj相当于User user=new User();
		Object obj=clazz.newInstance();
		
		//调用
		//相当于user.eat();
		Method method=clazz.getMethod("eat", null);//获得方法实例
		Object rtn=method.invoke(obj, null);// 第一个参数：方法所属的实例 ;第二个参数：方法的实参
	}

}
