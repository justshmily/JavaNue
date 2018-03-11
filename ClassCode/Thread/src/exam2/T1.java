package exam2;

/**
 * 取钱线程
 * 
 * @author 15295
 *
 */
public class T1 implements Runnable {

	//现有金额
	int now;
	
	//取款金额
	int getMoney;
	
	public T1(int now,int getMoney) {
		this.now=now;
		this.getMoney = getMoney;
	}
	
	@Override
	public void run() {
		
		getMoney(this.getMoney);
	}

	private void getMoney(int getMoney) {
		
		//同步代码块，如果放在方法上面，则为同步方法
				synchronized (this) {
					if (this.now < getMoney) {
						System.out.println(Thread.currentThread().getName() + ":余额不足，" + this.now);
					} else {
						this.now -= getMoney;
						System.out.println(Thread.currentThread().getName() + ": 当前取款" + getMoney + ",余额：" + this.now);
					}
				}
	}

	
}
