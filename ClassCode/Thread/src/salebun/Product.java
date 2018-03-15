package salebun;

/**
 * 生产馒头
 * 
 * @author 15295
 *
 */
public class Product implements Runnable{

	Bag bag=null;
	
	public Product(Bag bag) {
		this.bag=bag;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Bun b=new Bun(String.valueOf(i));
			bag.put(b);
			
			long millis=(long) (Math.random()*10000);
			
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
