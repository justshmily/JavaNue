package downnew;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class DownPic implements Runnable {

	private String url;
	// 创建httpclient实例
	private HttpClient httpClient = HttpClients.createDefault();

	public DownPic(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		// 创建连接请求的方式，这里用Get方式
		HttpGet get = new HttpGet(this.url);

		// 远程图片的输入流
		InputStream in = null;
		OutputStream out = null;
		HttpResponse response;
		try {
			response = httpClient.execute(get);
			// 响应成功则获取内容实体
			HttpEntity entity = response.getEntity();
			in = entity.getContent();
			// 获取文件名，这里使用StringUtils工具类截取字符串
			String picName = StringUtils.substringAfterLast(url, "/");
			File file = new File("d:/ftp/pic");
			out = new FileOutputStream(new File(file, picName));
			// 使用Apache的IOUtils工具类实现文件复制(远程服务器资源->本地磁盘)
			IOUtils.copy(in, out);
			System.out.println(Thread.currentThread() + "图片下载完成");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
