package csust.txr.exception2;

public class InvalidNameException extends Exception {

	public InvalidNameException(String name) {
		super("账号名无效："+name);
	}

}
