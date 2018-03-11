package tcp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 * 
 * @author 15295
 *
 */
public class Server {

	private ServerSocket ss;
	private static int PORT = 9999;

	public Server(int port) {
		try {
			ss = new ServerSocket(port);
			System.out.println("服务器已启动，" + ss);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Server() {
		this(PORT);
	}

	/**
	 * 侦听是否有客户端连接
	 */
	public void listener() {
		while (true) {
			Socket sc=null;
			try {
				sc = ss.accept();
				System.out.println("有客户端连接进来，" + sc);
				
				//与客户端通信
				InputStream in=sc.getInputStream();
				OutputStream out=sc.getOutputStream();
				
				//InputStream->Reader
				InputStreamReader reader=new InputStreamReader(in);
				BufferedReader br =new BufferedReader(reader);
				
				PrintWriter pw=new PrintWriter(out,true);
				
				String content=null;
				while((content=br.readLine())!=null) {
					System.err.println("从客户端接收到的消息，"+content);
					
					//将消息回发给客户端
					pw.println("您好："+sc.getInetAddress()+"-"+content);
					
					if("bye".equals(content)) {
						break;
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(sc!=null) {
					try {
						sc.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Server server=new Server(8888);
		server.listener();
	}
}
