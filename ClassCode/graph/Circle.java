package com.newer.graph;

public class Circle extends Graph {

	/**
	 * 圆心
	 */
	private Point o = null;

	/**
	 * 半径
	 */
	private int r;

	/**
	 * 原点为圆心，半径为 R
	 * 
	 * @param r
	 */
	public Circle(int r) {
		o = new Point();
		this.r = r;
	}

	/**
	 * 创建圆
	 * 
	 * @param o
	 *            圆心
	 * @param r
	 *            半径
	 */
	public Circle(Point o, int r) {
		this.o = o;
		this.r = r;
	}

	/**
	 * 创建圆
	 * 
	 * @param x
	 *            圆心 X 坐标
	 * @param y
	 *            圆心 Y 坐标
	 * @param r
	 *            半径
	 */
	public Circle(int x, int y, int r) {
		o = new Point(x, y);
		this.r = r;
	}

	public String display() {
		return String.format("圆（圆心：%s，半径：%d）", o.display(), r);
	}

	@Override
	public double getPerimeter() {
		return 2 * r * Math.PI;
	}

	@Override
	public double getArea() {
		return r * r * Math.PI;
	}

}
