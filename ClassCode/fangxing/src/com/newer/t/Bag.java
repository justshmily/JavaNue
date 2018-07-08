package com.newer.t;

public class Bag {

	Food[] foods = new Food[6];
	int index = 0;

	/**
	 * 放馒头
	 * 
	 * @param food
	 */
	public synchronized void put(Food food) {
		if (foods.length == index) {
			System.out.println(Thread.currentThread().getName() + ":框已经装满了,等待拿馒头");
			// 等待，释放锁
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		foods[index] = food;
		System.out.println(Thread.currentThread().getName() + " 生产了馒头：" + food);

		index++;

		notify();

	}

	/**
	 * 拿馒头
	 * 
	 * @return
	 */
	public synchronized Food get() {
		while (index == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		notify();

		index--;
		System.out.println(Thread.currentThread().getName() + " 拿了馒头：" + foods[index]);
		return foods[index];
	}
}
