package com.newer.office;

public class Ppt extends Doc {

	// 默认 包可见
	Ppt() {
	}

	Ppt(String title) {
		super(title);
	}

	@Override
	public void edit() {
		System.out.printf("编辑 ppt: %s\n", title);
	}

}
