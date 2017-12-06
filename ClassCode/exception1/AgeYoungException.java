package csust.txr.exception1;

public class AgeYoungException extends Exception {

	public AgeYoungException(int age) {

		super("输入的年龄太小："+age);
	}

}
