package test1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 编写测试案例
 * 
 * @author 15295
 *
 */
public class CalcTest {

	private static Calc calc=null;
	
	@BeforeClass
	public static void init() {
		System.out.println("BeforeClass....");
		calc=new Calc();
	}
	
	@Test
	public void add(){
		int c=calc.add(10, 10);
		System.out.println(c);
	}
	
	@Test
	public void div(){
		
		int c=calc.div(10, 1);
		System.out.println(c);
	}
	
	@Test
	public void assertTest(){
		//断言
		int c=calc.add(10, 10);
		Assert.assertEquals(20, c);
		
	}
	
	
	@AfterClass
	public static void end(){
		System.out.println("After....");
	}
	
	@Before
	public void a(){
		System.out.println("Before...");
	}
	@After
	public void b(){
		System.out.println("After.....");
	}

	
	
}
