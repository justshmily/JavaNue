package com.newer.graph;

/**
 * 定义线
 * 
 * @author wtao
 *
 */
public class Line {

	// 访问修饰符

	/**
	 * 线段的起点
	 */
	private Point start;

	/**
	 * 线段的终点
	 */
	private Point end;

	// private double length;

	/**
	 * 创建一个线段
	 * 
	 * @param start
	 *            起点
	 * @param end
	 *            终点
	 */
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * 创建一条线段
	 * 
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public Line(int startX, int startY, int endX, int endY) {
		start = new Point(startX, startY);
		end = new Point(endX, endY);
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public String display() {
		String text = String.format("线段：%s - %s", start.display(), end.display());

		return text;
	}

	/**
	 * 获得（计算）线段的长度
	 * 
	 * @return double 长度
	 */
	public double getLength() {
		int dx = start.getX() - end.getX();
		int dy = start.getY() - end.getY();
		return Math.sqrt(dx * dx + dy * dy);
	}

}
