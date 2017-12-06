package com.tanxiaoran.yewu;

public class Test {

	public static void main(String[] args) {
		VIPCoustomer zsan=new VIPCoustomer("张三",3);
		System.out.println("服务信息：");
		zsan.service();
		System.out.println("投诉信息：");
		zsan.tousu();
	}
}
