package csust.txr.reflect;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 自定义类加载器 1、重写ClassLoader 2、重写findClass 3、在findClass方法中调用defineClass()方法
 * 
 * @author 15295
 *
 */
public class MyClassLoader extends ClassLoader {

	// 对应class
	private File classFile;

	public MyClassLoader(File classFile) {
		this.classFile = classFile;
	}

	public MyClassLoader(URL url) {
		// 将URL->File
		try {
			this.classFile = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		InputStream in = null;
		BufferedInputStream bi = null;

		int len = 0;
		byte[] b = null;
		if (this.classFile != null) {
			len = (int) classFile.length();
			b = new byte[len];
		} else {
			throw new ClassNotFoundException("字节码文件读取不正确[为null]");
		}
		try {
			in = new FileInputStream(classFile);
			bi = new BufferedInputStream(in);

			bi.read(b, 0, len);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bi != null) {
				try {
					bi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return this.defineClass(name, b, 0, b.length);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// 加载 d:/ftp/classes 目录下的class文件
		File classFile = new File("D:/ftp/classes/com/newer/user/User.class");
		MyClassLoader cl = new MyClassLoader(classFile);

		// 创建User类的实例
		// 1、得到Class对象
		Class clazz = cl.loadClass("com.newer.user.User");

		// 2、创建User类的实例
		Object obj = clazz.newInstance();

		System.out.println("obj:" + obj);
	}
}
