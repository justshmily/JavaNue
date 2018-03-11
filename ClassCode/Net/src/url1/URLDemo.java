package url1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	public static void main(String[] args) throws IOException {
		
		//1、构建URL
		URL url=new URL("http://news.sina.com.cn/");
		
		//2、创建URLConnection实例
		URLConnection uc=url.openConnection();
		
		//3、获得输入流
		InputStream in=uc.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(in,"utf-8"));
		
		//将html文档保存至本地
		File file=new File("d:/ftp/sinal.html");
		
		//这里使用了OutputStreamWriter,以便设置字符编码
		OutputStream out=new FileOutputStream(file);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
		
		String msg=null;
		while((msg=br.readLine())!=null) {
			System.out.println(msg);
			bw.write(msg+"\n");
		}
		
		//4、关闭流
		bw.close();
		br.close();
		in.close();
	}

}
