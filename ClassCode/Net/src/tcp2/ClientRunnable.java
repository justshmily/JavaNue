package tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 用来接收消息
 * 
 * @author 15295
 *
 */
public class ClientRunnable implements Runnable {
	
	private Socket socket=null;

	public ClientRunnable(Socket socket) {
		this.socket=socket;
		
	}

	@Override
	public void run() {
		rcvMsg();
		
	}

	private void rcvMsg() {
		
		InputStream in = null;
		BufferedReader br = null;
		try {
			in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(in));
			String msg=null;
			while ((msg=br.readLine()) != null) {
				System.out.println(msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
