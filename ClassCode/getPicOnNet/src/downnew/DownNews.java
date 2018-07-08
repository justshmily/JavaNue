package downnew;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownNews implements Runnable {

	private String url;
	private List<NewsInfo> newsInfo;
	
	public DownNews(String url,List<NewsInfo> Trump_infos) {
		this.url=url;
		this.newsInfo=newsInfo;
	} 
	
	@Override
	public void run() {
		Document doc=null;
		try {
			doc=Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String title=doc.select("title").first().text();
		String from=null;
		Elements eles=doc.select("meta");
		for (Element element : eles) {
			if(element.attr("property").equals("article:author")){
				from=element.attr("content");
			}
		}
		String date=null;
		eles=doc.select("meta");
		for (Element element : eles) {
			if(element.attr("name").equals("weibo: article:update_at")){
				date=element.attr("content");
			}
		}
		String urladd=this.url;
		
		String text=null;
		eles=doc.select("div");
		for (Element element : eles) {
			if(element.attr("class").equals("article")&&element.attr("id").equals("article")){
				text=element.text();
			}
		}
		newsInfo.add(new NewsInfo(title,from,date,urladd,text));
		System.out.println(Thread.currentThread()+"线程下载完成");
	}
	
}
