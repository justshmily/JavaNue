package csust.txr.exception2;

public class IInvalidPasswordException extends Exception {

	public IInvalidPasswordException(String password) {
		super("密码无效");
	}

}
