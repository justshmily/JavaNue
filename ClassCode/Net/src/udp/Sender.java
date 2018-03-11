package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 发送方
 * 
 * @author 15295
 *
 */
public class Sender {

	//DatagramSocket 负责接收和发送数据，不产生IO流
	private DatagramSocket ds=null;
	private DatagramPacket dp=null;
	
	public Sender() {
		try {
			ds=new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	//发送数据
	public void send(String data) {
		byte[] buf=data.getBytes();
		
		InetAddress add=null;
		try {
			add=InetAddress.getByName("127.0.0.1");
			
			dp=new DatagramPacket(buf, buf.length,add,8888);
			ds.send(dp);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Sender sender=new Sender();
		while(true) {
			sender.send(new Date().toString());
			Thread.sleep(3000);
			System.out.println("发送完成");
		}
	}
	
}
