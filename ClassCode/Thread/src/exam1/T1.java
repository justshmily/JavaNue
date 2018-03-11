package exam1;

/**
 * 烧水线程
 * 
 * @author 15295
 *
 */
public class T1 implements Runnable {

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread()+"开始烧水了...");
		
		//暂停，让洗杯线程有机会执行
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread()+"水已经烧好了");
	}

}
