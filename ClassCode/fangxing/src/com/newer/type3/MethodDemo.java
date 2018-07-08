package com.newer.type3;

import java.io.File;

/**
 * ·ºÐÍ·½·¨
 * @author QuanLijian
 *
 */
public class MethodDemo {

	public <T> T getObj(T t){
		return t;
	}
	
	public static void main(String[] args) {
		MethodDemo demo=new MethodDemo();
		
		String a="hello";
		String str=demo.getObj(a);
		
		File file=demo.getObj(new File("d:/temp/a.txt"));
	}
	
	
}
