package csust.txr.exception2;

public class UserServices {
	public User login(String name,String password) throws InvalidNameException, IInvalidPasswordException {
		User user=null;
		if(!name.equals("bob"))
			throw new InvalidNameException(name);
		
		if(!password.equals("123"))
			throw new IInvalidPasswordException(password);
		
		user=new User(name,password);
		return user;
	}
	
}
