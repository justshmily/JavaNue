package csust.txr.exception2;

public class App {

	UserServices service=null;
	
	void run() {
		String page="welcome";
		service =new UserServices();
		User user=null;
		try {
			//登录
			user=service.login("bob","123");
			user.sayHello();
		} catch (InvalidNameException e) {
			System.out.println(e.getMessage());
			page="name";
		} catch (IInvalidPasswordException e) {
			System.out.println(e.getMessage());
			page="password";
		}finally {
			System.out.println("页面跳转"+page); 
		}
	}
	public static void main(String[] args) {
		
		App app=new App();
		app.run();
	}

}
