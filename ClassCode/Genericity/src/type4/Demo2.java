package type4;

import java.util.ArrayList;
import java.util.List;

/**
 * 下限
 * 
 * @author 15295
 *
 */
public class Demo2{

	/**
	 * 下限
	 * @param data
	 */
	public void prt(List<? super Food> data) {
		for(Object object:data) {
			System.out.println(object);
		}
	}
	
	public static void main(String[] args) {
		Demo2 demo2=new Demo2();
		
		List<? super Food> data=new ArrayList<>();
		demo2.prt(data);
	}

}
