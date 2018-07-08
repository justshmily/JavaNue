package com.newer.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TypeDemo {

	public static void main(String[] args) {
		List lst=new ArrayList();
		lst.add("abc");
		lst.add(new Integer(1));
//		
//		for (int i = 0; i < lst.size(); i++) {
//			Integer x=(Integer)lst.get(i);
//			String y=(String)lst.get(i);
//		}
		
		for (Object object : lst) {
			
		}
		Map map;
		
		//·ºÐÍ
		List<String> lst2=new ArrayList<>();
		lst2.add("f");
		lst2.add("b");
		for (String str : lst2) {
			
		}

	}

}
