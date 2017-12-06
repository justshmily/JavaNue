package csust.txr.weibo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	
	/**
	 * 消息内容
	 */
	
	private String content;
	/**
	 * 作者
	 */
	private User author;
	
	/**
	 * 消息发出的时间
	 */
	private Date time;
	
	/**
	 * 
	 * @param content  消息内容
	 */
	public Message(String content) {
		this.content = content;
		time = new Date();
	}
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTime() {
		SimpleDateFormat format =
				new SimpleDateFormat("MM/dd HH:mm");
		return format.format(time);
	}

	@Override
	public String toString() {
		return String.format("[%s]在%s时发送消息:%s", author.getName(),this.getTime(),content);
	}
	
	
}

