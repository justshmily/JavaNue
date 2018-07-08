package downnew;

public class NewsInfo {

	private String title;
	private String from;
	private String date;
	private String urladdr;
	private String text;
	
	public NewsInfo(String title, String from, String date, String urladdr, String text) {
		super();
		this.title = title;
		this.from = from;
		this.date = date;
		this.urladdr = urladdr;
		this.text = text;
	}
	
	public NewsInfo(){}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String geturladdr() {
		return urladdr;
	}

	public void seturladdr(String urladdr) {
		this.urladdr = urladdr;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
