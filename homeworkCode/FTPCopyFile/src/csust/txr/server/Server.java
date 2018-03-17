package csust.txr.server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 文件下载服务器
 * 
 * @author 15295
 *
 */
public class Server {

	private ServerSocket serverSocket;
	
	//服务器端的目录
	private String addr="d:ftp";
	
	//端口号
	private int port=8888;
	
	public Server() {
		try {
			serverSocket=new ServerSocket(port);
			System.out.println("启动服务器：" + serverSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param port  端口
	 * @param directory  服务器端文件目录
	 */ 
	public Server(int port,String directory){
		this.port=port;
		this.addr=directory;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("启动服务器：" + serverSocket);
	}
	
	/**
	 * 用来侦听客户端连接
	 */
	public void listener() {
		while(true) {
			Socket socket;
			try {
				socket = serverSocket.accept();
				System.out.println("连接客户端：" + socket);
				
				//交给线程处理
				File folder=new File(addr);
				ServerDo ftpDo=new ServerDo(socket,folder);
				Thread t=new Thread(ftpDo);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Server server=new Server();
		server.listener();
	}
}
