package url2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 远程网页保存、图片下载
 * 
 * @author 15295
 *
 */
public class DownloadHtml {

	// 创建HttpClient实例
	HttpClient httpClient = HttpClients.createDefault();

	/**
	 * 下载HTML页面
	 * 
	 * @param url
	 * @param file
	 *            下载后的保存文件
	 */
	public void downloadHTML(String url, File file) {

		// 创建请求的方式，post,get,这里使用get方式
		HttpGet get = new HttpGet(url);

		// 为了连接关闭需要
		get.setHeader(HttpHeaders.CONNECTION, "close");

		// 通过httpClient发请求，得到响应对象
		try {
			// HttpReaponse为服务器返回的响应对象
			HttpResponse response = httpClient.execute(get);

			// 得到响应的状态码，200表示响应成功
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				// 获得页面内容
				HttpEntity en = response.getEntity();
				// 也可得到字节流
				// InputStream in=en.getContent();

				// 将页面内容对象转换为字符串，即html源码
				String htmlContent = EntityUtils.toString(en, "utf-8");
				System.out.println(htmlContent);

				// 通过apache的FileUtils工具类，将获得的html源码保存至本地。
				FileUtils.writeStringToFile(file, htmlContent, "utf-8");
			} else {
				System.out.println("请求出了问题");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			get.releaseConnection();
		}

	}

	/**
	 * 下载图片
	 * 
	 * @param picURL
	 *            图片url地址，是List集合
	 * @param folder
	 *            图片下载后的存放目录
	 */
	public void downloadPic(List<String> picURL, File folder) {
		// 文件夹不存在就创建
		if (!folder.exists()) {
			folder.mkdirs();
		}

		// 使用线程池来下载图片
		// 创建可缓冲的线程池
		ExecutorService es = Executors.newCachedThreadPool();
		for (String str : picURL) {
			// 使用线程执行任务：完成具体的下载功能
			es.execute(new Runnable() {
				public void run() {
					// 创建请求方式：post、get，这里使用get方式
					// 如果是post，则使用HttpPost

					HttpGet get = new HttpGet(str);

					// 远程图片的输入流
					InputStream in = null;
					// 图片写入本地的输出流
					OutputStream out = null;

					try {
						HttpResponse res = httpClient.execute(get);
						HttpEntity entiry = res.getEntity();
						in = entiry.getContent();

						// 获得文件名，这里使用apache的StringUtils工具类截取字符串
						String picName = StringUtils.substringAfterLast(str, "/");
						out = new FileOutputStream(new File(folder, picName));

						// 使用apache的IOUtils工具类实现文件复制（远程服务器资源->本地磁盘）
						IOUtils.copy(in, out);

						System.out.println(Thread.currentThread() + "下载图片完成");

					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							try {
								out.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (in != null) {
							try {
								in.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				}
			});
		}

		// 阻止新来的任务提交，将闲置的线程进行中断
		es.shutdown();
	}

	public static void main(String[] args) {

		DownloadHtml down = new DownloadHtml();
		// 下载html，注意：保证e:/temp/目录要存在
		down.downloadHTML("http://news.sina.com.cn/", new File("d:/ftp/sina.html"));

		// 下载图片
		File folder = new File("d:/ftp/pic");
		// 创建具有同步功能的集合
		List<String> picURL = Collections.synchronizedList(new ArrayList<String>());
		// 模拟多图片
		picURL.add("http://n.sinaimg.cn/news/transform/20170224/Pecj-fyavvth7632021.jpg");
		picURL.add("http://n.sinaimg.cn/news/transform/20170216/LHE0-fyarrcf4205926.jpg");
		picURL.add("http://n.sinaimg.cn/news/transform/w326h183/20180307/NKZY-fxipenp3379262.jpg");
		picURL.add("http://n.sinaimg.cn/news/transform/w260h170/20180227/W5nW-fyrwsqi9136939.jpg");
		down.downloadPic(picURL, folder);
	}

}
