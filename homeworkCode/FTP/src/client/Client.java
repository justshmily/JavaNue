package com.newer.chat.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 
 * @author 谭笑然
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Client() {
		this(IP, PORT);
	}

	public void talk() {

		OutputStream out = null;
		InputStream in = null;

		DataInputStream din = null;
		DataOutputStream dout = null;

		// 向服务器发消息
		PrintWriter pw = null;
		// 从服务器接收消息
		BufferedReader br = null;
		// 从控制台获得输入的消息
		BufferedReader brc = null;

		try {
			out = socket.getOutputStream();
			in = socket.getInputStream();

			// din=new DataInputStream(in);
			// dout=new DataOutputStream(out);

			pw = new PrintWriter(out, true);
			br = new BufferedReader(new InputStreamReader(in));

			brc = new BufferedReader(new InputStreamReader(System.in));

			// 从控制台不断获得输入，并将消息发送至服务器
			String msg = null;
			while ((msg = brc.readLine()) != null) {
				pw.println(msg);

				String list=null;
				while((list=br.readLine())!=null){
					System.out.println(list);
				}

				if ("bye".equals(msg)) {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (brc != null) {
				try {
					brc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		Client c = new Client();
		c.talk();

	}
}
