package csust.txr.weibo;

public class App {

	public static void main(String[] args) {
		
		User u1=new User("lala");
		User u2=new User("neinei");
		User u3=new User("haha");
		User u4=new User("oo");
		User u5=new User("enen");
		
		u1.addFollowing(u2);
		u1.addFollowing(u3);
		u1.addFollowing(u4);
		u2.addFollowing(u4);
		u2.addFollowing(u1);
		u2.addFollowing(u5);
		u1.showInfo();
		u2.showInfo();
		u5.showInfo();
		u3.showInfo();
		
		u1.removeFollowing(u3);
		u1.showInfo();
		u3.showInfo();
		
		Message m1= new Message("xinwen");
		u1.sendMessage(m1);
		u1.showInfo();
		
		u1.sendMessage(new Message("lllllahha"));
		u1.showInfo();
	}

}
