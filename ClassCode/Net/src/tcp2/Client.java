package tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 
 * @author 15295
 *
 */
public class Client {

	private static String IP = "localhost";
	private static int PORT = 9999;
	private Socket socket = null;

	public Client(String ip, int port) {
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Client() {
		this(IP, PORT);
	}

	public void talk(){
		//Client->Server
		OutputStream out=null;
		
		//控制台->Client
		InputStreamReader ir=null;
		BufferedReader br=null;
		
		//分两个线程
		//一个线程用来发送消息
		//另一个线程用来接收消息
		
		//1、接收消息的线程
		new Thread(new ClientRunnable(socket)).start();
		
		
		//2、负责发送消息
		try {
			out=socket.getOutputStream();
			
			PrintWriter pw=new PrintWriter(out,true);
			
			ir=new InputStreamReader(System.in);
			br=new BufferedReader(ir);
			String msg=null;
			while((msg=br.readLine())!=null){
				//向服务器发送消息
				pw.println(msg);
				if("bye".equals(msg)){
					break;
				}
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ir!=null){
				try {
					ir.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		Client client = new Client("localhost", 8888);
		client.talk();
	}
}
