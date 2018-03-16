package type1;

import java.util.Date;

public class ActionImpl<T> implements Action<T> {

	T t=null;
	
	public ActionImpl(T t) {
		this.t=t;
	}
	
	@Override
	public T getAction() {
		return t;
	}
	
	public static void main(String[] args) {
		String str="hello word";
		Action<String> action=new ActionImpl<>(str);
		String str2=action.getAction();
		System.out.println(str2);
		
		Date d=new Date();
		Action<Date> action2=new ActionImpl<>(d);
		Date d_=action2.getAction();
	}
}
