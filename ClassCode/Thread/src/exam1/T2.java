package exam1;

/**
 * 洗杯线程
 * 
 * @author 15295
 *
 */
public class T2 implements Runnable {

	@Override
	public void run() {
		
		//然烧水线程先执行
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread() + " 开始洗第" + (i+1) + "个杯子");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + " 第" + (i+1) + "个杯子洗完");
		}
	}

}
