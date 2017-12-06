package csust.txr.weibo;

import java.util.ArrayList;

/**
 * 
 * @author 谭笑然
 *
 */
public class User {
	
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 状态
	 */
	private ArrayList<Message> messages=new ArrayList<>();
	
	/**
	 * 关注
	 */
	private ArrayList<User> following=new ArrayList<>();
	
	/**
	 * 粉丝
	 */
	private ArrayList<User> followers=new ArrayList<>();
	private ArrayList<Message> me=new ArrayList<>();
	

	public User(String name) {
		this.name=name;
	}


	public String getName() {
		return name;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public ArrayList<User> getFollowing() {
		return following;
	}

	public void setFollowing(ArrayList<User> following) {
		this.following = following;
	}

	public ArrayList<User> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<User> followers) {
		this.followers = followers;
	}


	//重写（子类覆盖父类中的同名方法）
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	/**
	 * 关注一个用户
	 * @param user 被关注的用户
	 */
	public void addFollowing(User user) {
		//你关注参数对象 user
		following.add(user);
		//你成了关注的对象的粉丝
		user.followers.add(this);
	}
	
	/**
	 * 取消关注
	 * @param user
	 */
	public void removeFollowing(User user) {
		following.remove(user);
		user.followers.remove(this);
	}
	
	/**
	 * 获得关注人数
	 * @return
	 */
	public int getFollowingSize() {
		return following.size();
	}
	
	/**
	 * 获得粉丝数
	 * @return
	 */
	public int getFollowersSize() {
		return followers.size();
	}
	
	public void showInfo() {
		System.out.println(name);
		System.out.println("------------");
		System.out.printf("关注：%d\t%s\n",
				following.size(),following);
		System.out.printf("粉丝：%d\t%s\n",
				followers.size(),followers);
		System.out.printf("消息：%d\t%s\n",
				messages.size(),messages);
		System.out.println("------------");

	}
	
	public void sendMessage(Message message) {
		message.setAuthor(this);
		messages.add(message);
	}
}
