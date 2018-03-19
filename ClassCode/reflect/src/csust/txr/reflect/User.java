package csust.txr.reflect;

public class User {

	private String username;
	private String realname;
	private int height;
	public  String x;
	
	private User(String username,String realname){
		this(username);
		this.realname=realname;
	}
	public User(){
		this("无名氏");
		System.out.println("调用了不带参数的构造方法");
	}
	public User(String username){
		this.username=username;
		System.out.println("调用了带参数的构造方法");
	}
	
	public void eat(){
		System.out.println(this.username+" 在吃饭");
	}
	private void prtInfo(){
		prtInfo(this.username,this.realname);
	}
	
	public void prtInfo(String username,String realname){
		System.out.println("username:"+username+",realname:"+realname);
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
