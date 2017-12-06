package com.newer.graph;

/**
 * 定义点
 * 
 * @author wtao
 *
 */
public class Point extends Object {

	/**
	 * X 坐标
	 */
	private int x;

	/**
	 * Y 坐标
	 */
	private int y;

	/**
	 * 没有参数的构造方法，没有定义带参数的它存在，否则不存在
	 */
	public Point() {
		// 对象的初始化
		x = 0;
		y = 0;
	}

	/**
	 * 
	 * @param x
	 */
	public Point(int x) {
		this(x, x);
	}

	/**
	 * 构造方法
	 * 
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 显示
	 * 
	 * @return
	 */
	public String display() {
		String text = String.format("点(%d, %d)", x, y);
		return text;
	}

}
