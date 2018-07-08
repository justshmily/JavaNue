package com.newer.demo;

public class App {

	// 视图
	CalcUI calcUI;

	// 模型
	Model model;

	// 分离、连接 视图与模型
	// MVC、MVP
	// 观察者模式

	public App() {
		calcUI = new CalcUI();
		model = new Model();
	}

	public void run() {
		calcUI.setVisible(true);
	}

	public static void main(String[] args) {
		App app = new App();
		app.run();
	}
}
