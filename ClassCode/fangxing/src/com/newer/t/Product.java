package com.newer.t;

public class Product implements Runnable {
	Bag bag = null;

	public Product(Bag bag) {
		this.bag = bag;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Food f = new Food(String.valueOf(i));
			bag.put(f);

			long millis = (long) (Math.random() * 10000);

			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
