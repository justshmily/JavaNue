package salebun;

/**
 * 放馒头的容器
 * 
 * @author 15295
 *
 */
public class Bag {

	Bun[] buns=new Bun[6];
	int index=0;
	
	/**
	 * 放馒头
	 * 
	 * @param bun
	 */
	public synchronized void put(Bun bun) {
		if(buns.length==index) {
			System.out.println(Thread.currentThread().getName()+":框已经装满了，等待那馒头");
			//等待，释放锁
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		buns[index]=bun;
		System.out.println(Thread.currentThread().getName()+"生产了馒头："+bun);
		
		index++;
		
		notify();
	}
	
	/**
	 * 拿馒头
	 * 
	 * @return
	 */
	public synchronized Bun get() {
		while(index==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		notify();

		index--;
		System.out.println(Thread.currentThread().getName() + " 拿了馒头：" + buns[index]);
		return buns[index];
	}
}
