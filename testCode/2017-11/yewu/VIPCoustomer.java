package com.tanxiaoran.yewu;

public class VIPCoustomer extends Coustomer {
	
	private int level;
	
	
	/**
	 * @param level
	 */
	public VIPCoustomer(int level) {
		super();
		this.level = level;
	}

	public VIPCoustomer(String name,int level) {
		super(name);
		this.level = level;
	}

	public void tousu() {
		System.out.println("VIP"+level+"级别"+getName()+"先生/女士投诉中....");
	}
}
