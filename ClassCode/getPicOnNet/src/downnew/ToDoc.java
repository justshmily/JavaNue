package downnew;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class ToDoc {

	private String url;
	private List<String> paths;
	private Document doc = null;
	private List<NewsInfo> newsInfo;

	public ToDoc(String url) {
		this.url = url;
	}

	public void getHttpinfo() {
		try {
			// 用于接下来解析网页中图片的地址
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(doc.toString());
		try {
			// 即将写入的网页文件
			File file = new File("d:/ftp/index.html");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			OutputStream out = new FileOutputStream(file);
			BufferedWriter bw = null;
			InputStream in = null;
			BufferedReader br = null;
			try {
				bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
				// 将网页的内容写进文件
				URLConnection connect = null;
				try {
					connect = new URL(url).openConnection();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					in = connect.getInputStream();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				br = new BufferedReader(new InputStreamReader(in, "utf-8"));
				String info = null;
				try {
					while ((info = br.readLine()) != null) {
						bw.write(info+"\n");
						System.out.println(info);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------------------------------");
		Elements eles = doc.select("img");
		paths = new ArrayList<>();
		for (Element element : eles) {
			String path = element.attr("data-src");
			System.out.println(path.trim());
			paths.add(path);
		}
		for (Element element : eles) {
			String path = element.attr("src");
			System.out.println(path.trim());
			paths.add(path);
		}
		for (String string : paths) {
			System.out.println(string);
		}
		System.out.println(paths.size());

		// 构建下载图片的线程池并下载图片
		ExecutorService poll = Executors.newCachedThreadPool();
		for (String string : paths) {
			poll.submit(new DownPic(string));
		}
	}

	/**
	 * 该方法用于将包含关键字"中国共产党"的新闻抓取到本地
	 */
	public void getNewsInfo() {
		newsInfo = new ArrayList<>();
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExecutorService poll = Executors.newCachedThreadPool();
		// 利用检索每个文本的关键字中国共产党，获取连接并下载
		int number = 0;
		Elements elesa = doc.select("a");
		for (Element element : elesa) {
			String text = element.text();
			if (text.indexOf("中国共产党") != -1) {
				String path = element.attr("href");
				System.out.println(path);
				number++;
				poll.submit(new DownNews(path, newsInfo));
			}
		}

		Elements elestxt = doc.select(".txt");
		for (Element element : elestxt) {
			String text = element.text();
			if (text.indexOf("中国共产党") != -1) {
				String path = element.select("a").attr("href");
				number++;
				poll.submit(new DownNews(path, newsInfo));
			}
		}
		System.out.println(number);
		while (true) {
			if (newsInfo.size() == number) {
				// 将列表生成json文件
				Gson gson = new Gson();
				String json = gson.toJson(newsInfo);
				FileWriter fw = null;
				try {
					fw = new FileWriter("Trump_infos.json");
					fw.write(json);
					System.out.println("json文件写入完成");
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			} else
				continue;
		}
		poll.shutdown();
	}
}
