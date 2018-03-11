package tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务器
 * 
 * @author 15295
 *
 */
public class Server {

	private ServerSocket ss;
	private static int PORT = 9999;
	
	//存放所有客户端
	private List<Socket> sks=new ArrayList<>();

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
				
				//将侦听到的客户端交由线程处理
				sks.add(sc);
				Thread t=new Thread(new ServerRunnable(sks,sc));
				t.start();
				
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
