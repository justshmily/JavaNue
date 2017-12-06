package com.newer.office;

public abstract class Doc {

	protected String title;
	protected long size;
	protected long time;

	public Doc() {
		title = "无标题";
	}
	
	public Doc(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 具体方法
	 */
	public void open() {
		System.out.println("open " + title);
	}

	/**
	 * 抽象方法
	 */
	public abstract void edit();

}
