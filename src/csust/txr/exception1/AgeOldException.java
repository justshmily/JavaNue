package csust.txr.exception1;

public class AgeOldException extends Exception {

	public AgeOldException(int age) {
		super("输入的年龄太大："+age);
	}
	
}
