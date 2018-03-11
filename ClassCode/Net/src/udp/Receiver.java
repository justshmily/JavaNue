package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收方
 * 
 * @author 15295
 *
 */
public class Receiver {

	private DatagramSocket ds=null;
	private DatagramPacket dp=null;
	
	public Receiver() {
		try {
			ds=new DatagramSocket(8888);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void recvMsg() {
		byte[] buf=new byte[64000];
		dp=new DatagramPacket(buf,buf.length);
		//接收数据
		try {
			ds.receive(dp);
			byte[] data=dp.getData();
			
			System.out.println("接收到的数据：" + new String(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Receiver rv = new Receiver();
		while (true) {
			rv.recvMsg();
		}
	}
}
