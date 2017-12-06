package csust.txr.exception1;

public class User {
	private String name;
	private int age;
	
	public User(String name,int age) {
		this.name=name;
		this.age=age;
	}

	public User(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgeOldException,AgeYoungException{
		if(age<18)
			throw new AgeYoungException(age);
		if(age>60)
			throw new AgeOldException(age);
		this.age = age;
	}
	
	public void show() {
		System.out.println(name+"的年龄是"+age);
	}
}
