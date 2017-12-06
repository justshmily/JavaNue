package csust.txr.exception1;

import java.util.Scanner;

public class App {

	public void work() {
		User bob=new User("Bob");
		try {
			bob.setAge(12);
		} catch (AgeOldException e) {
			handleAgeException(e.getMessage(),bob);
		} catch (AgeYoungException e) {
			handleAgeException(e.getMessage(), bob);
		}finally {
			bob.show();
		}
	}
	private void handleAgeException(String message,User user) {
		System.out.println(message);
		System.out.print("请重新输入年龄（18~60）");
		Scanner input=new Scanner(System.in);
		int age=input.nextInt();
		try {
			user.setAge(age);
		} catch (AgeOldException e) {
			handleAgeException(e.getMessage(),user);
		} catch (AgeYoungException e) {
			handleAgeException(e.getMessage(),user);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app=new App();
		app.work();
	}

}
