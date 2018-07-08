package com.newer.t;

public class Bag {

	Food[] foods = new Food[6];
	int index = 0;

	/**
	 * ����ͷ
	 * 
	 * @param food
	 */
	public synchronized void put(Food food) {
		if (foods.length == index) {
			System.out.println(Thread.currentThread().getName() + ":���Ѿ�װ����,�ȴ�����ͷ");
			// �ȴ����ͷ���
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		foods[index] = food;
		System.out.println(Thread.currentThread().getName() + " ��������ͷ��" + food);

		index++;

		notify();

	}

	/**
	 * ����ͷ
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
		System.out.println(Thread.currentThread().getName() + " ������ͷ��" + foods[index]);
		return foods[index];
	}
}
