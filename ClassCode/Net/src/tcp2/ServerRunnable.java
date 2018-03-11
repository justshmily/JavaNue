package tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerRunnable implements Runnable{

	private List<Socket> sks;
	private Socket sk=null;
	
	private BufferedReader br=null;
	
	public ServerRunnable(List<Socket> sks, Socket sk) {
		this.sks=sks;
		this.sk=sk;
		
		try {
			br=new BufferedReader(new InputStreamReader(this.sk.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		sendMsg();
	}

	/**
	 * 向客户端发送消息
	 */
	private void sendMsg() {
		String msg=null;
		while ((msg = rcvMsg()) != null) {
			
			//遍历每个客户端，分别构建输出流，并进行发送
			for(Socket socket:sks) {
				OutputStream out=null;
				PrintWriter pw=null;
				
				try {
					out=socket.getOutputStream();
					pw=new PrintWriter(out,true);
					
					// 发消息
					pw.println(
							this.sk.getInetAddress().getHostAddress() + ":" + 
					msg + "(在线人数:" + this.sks.size() + ")");

				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					//连接不能进行关闭
				}
			}
		}
	}

	/**
	 * 接收客户端发送的消息
	 * 
	 * @return
	 */
	private String rcvMsg() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			
			// 如果出异常，则说明客户端已关闭
			// 在集合中将该客户端移除
			this.sks.remove(this.sk);
		}
		return null;
	}

}
