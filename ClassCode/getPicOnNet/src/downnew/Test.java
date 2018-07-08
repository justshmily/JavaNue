package downnew;

import org.apache.log4j.Logger;

public class Test {
	
	private static Logger log=Logger.getLogger(Test.class);

	public static void main(String[] args) {
		
		String url = "http://news.sina.com.cn/";
		ToDoc test = new ToDoc(url);
		log.info("下载网页"+url);
		test.getHttpinfo();
		log.info("下载新闻");
		test.getNewsInfo();
	}

}
