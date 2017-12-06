package com.newer.graph;

public class App {

	public static void main(String[] args) {

		// 方法的重载
		Point p1 = new Point();
		Point p2 = new Point(3);
		Point p3 = new Point(5, 7);

		System.out.println(p1.display());
		System.out.println(p2.display());
		System.out.println(p3.display());

		Line l1 = new Line(p2, p3);
		System.out.println(l1.display());

		// p2.setX(99);
		// p3.setX(99);
		// System.out.println(l1.display());

		Line l2 = new Line(0, 0, 4, 7);
		System.out.println(l2.display() + l2.getLength());

		l2.getStart().setX(1);
		l2.getStart().setY(7);
		System.out.println(l2.display() + l2.getLength());

		Circle c1 = new Circle(9);
		System.out.println(c1.display());

		Circle c2 = new Circle(new Point(3, 4), 7);
		System.out.println(c2.display());

		Circle c3 = new Circle(3, 4, 7);
		System.out.println(c3.display());
		System.out.println(c3.getPerimeter());
		System.out.println(c3.getArea());
				

	}
}
