package com.newer.t;

public class Startup {

	public static void main(String[] args) {
		Bag bag = new Bag();

		// �������߳�
		new Thread(new Product(bag)).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(new Customer(bag)).start();

	}

}
