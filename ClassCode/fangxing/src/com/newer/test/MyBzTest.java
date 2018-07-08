package com.newer.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.newer.bz.MyBz;

public class MyBzTest {
	static MyBz bz=null;
	@BeforeClass
	public static void  init(){
		bz=new MyBz();
	}
	
	
	@Test
	public void login(){
		boolean b=bz.login("zhangsan", "lisi");
		System.out.println(b);
	}

}
