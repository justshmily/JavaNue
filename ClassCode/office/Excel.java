package com.newer.office;

public class Excel extends Doc {

	Excel() {
	}

	Excel(String title) {
		super(title);
	}

	@Override
	public void edit() {
		System.out.printf("编辑 excel: %s\n", title);
	}

}
