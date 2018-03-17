package csust.txr.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket = null;
	private String hostname = "localhost";
	private int port = 8888;

	// 文件保存目录
	private String folder = "d:/ftp2";

	public Client() {
		this.socket = createSocket(hostname, port);
	}

	public Client(String hostname, int port) {
		this.socket = createSocket(hostname, port);
	}

	/**
	 * 从控制台获得输入，并向服务器发送请求
	 */
	public void sender() {
		// 输入流（控制台->客户端）
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);

		// 输出流(客户端->服务器）
		OutputStream out = null;
		PrintWriter pw = null;

		try {
			out = socket.getOutputStream();
			pw=new PrintWriter(out,true);
			//获得控制台输入
			
			String cmd=null;
			while((cmd=br.readLine())!=null) {
				cmd=cmd.trim();
				pw.println(cmd);
				
				//为了方面后面处理，先统一改成小写
				cmd=cmd.toLowerCase();
				
				if(cmd.equalsIgnoreCase("dir")) {
					//显示服务器端的文件
					ClientRcvMsg rcv=new ClientRcvMsg(socket);
					Thread t=new Thread(rcv);
					t.start();
				}else if (cmd.startsWith("get")) {
					/*获得文件名*/					
					String[] arrs = cmd.split("get");
					String fileName = null;
					if (arrs != null && arrs.length > 1) {
						fileName = arrs[1];
						fileName = fileName.trim();
					}
					fileName=fileName==null?"myfile.txt":fileName;
					
					// 如果是下载文件，则重新建一个连接，并启动一个线程执行
					Socket socket = createSocket("localhost", 8888);
					ClientDownload download = new ClientDownload(socket,folder,cmd);
					//设置文件名
					download.setFileName(fileName);
					Thread t = new Thread(download);
					t.start();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建一个新的客户端连接
	 * 
	 * @param hostname
	 * @param port
	 * @return
	 */
	private Socket createSocket(String hostname, int port) {
		Socket socket = null;
		try {
			socket = new Socket(hostname, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return socket;
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.sender();
	}
}
