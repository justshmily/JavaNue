package type4;

/**
 * 上限
 * 
 * @author 15295
 *
 */
public class Demo1 <T extends Food>{

	public static void main(String[] args) {
		Demo1<Apple> demo=new Demo1<>();
		
		//错误，因为Football不是Food的子类
		//Demo1<Football> demo1=new Demo1<>();
	}

}
