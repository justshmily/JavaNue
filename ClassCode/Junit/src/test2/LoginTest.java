package test2;

import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {

	private static Login lg=null;
	
	@BeforeClass
	public static void  init(){
		lg=new Login();
	}
	
	@Test
	public void login(){
		boolean b=lg.login("zhangsan", "lisi");
		System.out.println(b);
		 b=lg.login("root", "root");
			System.out.println(b);
	}
}
