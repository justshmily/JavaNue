package com.tanxiaoran.yewu;

public class Coustomer {

	private String name;
	
	public Coustomer() {
		
	}
	/**
	 * @param name
	 */
	public Coustomer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void service() {
		System.out.println(name+"先生/女士正在服务中....");
	}
}
