package tcp1;

import java.io.IOException;
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

	public Client(String ip,int port) {
		try {
			socket=new Socket(ip,port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Client() {
		this(IP,PORT);
	}
	
	public static void main(String[] args) {
		Client client=new Client("localhost",8888);
	}
}
