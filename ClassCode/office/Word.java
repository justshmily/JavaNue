package com.newer.office;

public class Word extends Doc {

	Word() {
		super();
	}

	Word(String title) {
		super(title);
	}

	@Override
	public void edit() {
		System.out.printf("编辑 word: %s\n", title);
	}

}
