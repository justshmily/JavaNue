package com.newer.type;

import java.util.Date;

public class ActionImpl<T> implements IAction<T> {
	T t=null;
	public ActionImpl(T t){
		this.t=t;
	}
	
	@Override
	public T getAction() {
		return t;
	}
	
	public static void main(String[] args) {
		
		String str="hello word";
		IAction<String> action=new ActionImpl<>(str);
		String str_=action.getAction();
		
		Date d=new Date();
		IAction<Date> action2=new ActionImpl<>(d);
		Date d_=action2.getAction();
		
		
	}

}
