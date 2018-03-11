package tcp1;

import java.io.IOException;
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
			try {
				Socket sc = ss.accept();
				System.out.println("有客户端连接进来，" + sc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Server server=new Server(8888);
		server.listener();
	}
}
