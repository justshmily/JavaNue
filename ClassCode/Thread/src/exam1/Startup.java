package exam1;

/**
 * 泡茶
 * 
 * @author 15295
 *
 */
public class Startup {

	public static void main(String[] args) {
		
		Thread t1=new Thread(new T1());
		Thread t2=new Thread(new T2());
		
		System.out.println("想喝茶");
		
		//烧水
		t1.start();
		
		//洗杯子
		t2.start();
		
		//保证扫水、洗杯子的线程先执行完
//		try {
//			Thread.sleep(12000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//或使用合并的方式
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("可以泡茶了");
	}

}
