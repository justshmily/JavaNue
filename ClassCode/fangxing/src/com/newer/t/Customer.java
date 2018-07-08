package com.newer.t;

public class Customer implements Runnable {
	private Bag bag=null;
	public Customer(Bag bag){
		this.bag=bag;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			Food food=bag.get();
			long millis =(long) (Math.random()*10000);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
