package salebun;

/**
 * 销售馒头
 * 
 * @author 15295
 *
 */
public class Customer implements Runnable{

	Bag bag=null;
	
	public Customer(Bag bag) {
		this.bag=bag;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Bun b=bag.get();
			
			long millis=(long)(Math.random()*10000);
			
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
