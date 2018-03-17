package csust.txr.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 从服务器端接收消息
 * 
 * @author 15295
 *
 */
public class ClientRcvMsg implements Runnable {

	private Socket socket = null;

	public ClientRcvMsg(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		recive();
	}

	private void recive() {
		// 输入流（服务器->客户端）
		InputStream in = null;
		
		try {
			in = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(in,"UTF-8");//UTF-8编码，否则遇到中文文件名会出现乱码。
			BufferedReader br = new BufferedReader(ir);
			
			//显示服务器端信息
			String cmd = null;
			try {
				while ((cmd = br.readLine()) != null) {
					cmd = cmd.trim();
					System.out.println(cmd);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
