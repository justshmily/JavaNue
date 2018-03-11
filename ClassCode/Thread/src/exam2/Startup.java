package exam2;

/**
 * 取钱，涉及线程同步
 * 
 * @author 15295
 *
 */
public class Startup {

	public static void main(String[] args) {
		
		//现有金额
		int now=5000;
		
		T1 tx=new T1(now,4000);
		
		Thread t1=new Thread(tx);
		Thread t2=new Thread(tx);
		
		//设置优先级，但运行时不一定按优先级执行，还有其它因素影响，设置的作用不大
		//t1.setPriority(Thread.MIN_PRIORITY);
		//t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		
	}

}
