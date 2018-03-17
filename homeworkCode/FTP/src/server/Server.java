package com.newer.chat.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 * 
 * @author 谭笑然
 *
 */
public class Server {
	private ServerSocket ss;
	private static int PORT = 9999;
	private static String InitAddr = "d:/ftp";

	String s = null;

	public Server(int port) {
		try {
			ss = new ServerSocket(port);
			System.out.println("服务器已启动," + ss);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Server() {
		this(PORT);
	}

	/**
	 * 侦听是否有客户端连接
	 */
	public void listener() {
		// 侦听
		while (true) {
			Socket sc=null;
			try {
				sc = ss.accept();
				System.out.println("连接成功,"+sc);
			
				//与客户端通信
				InputStream in=sc.getInputStream();
				OutputStream out=sc.getOutputStream();
				
				//InputStream->Reader
				InputStreamReader reader=new InputStreamReader(in);
				BufferedReader br=new BufferedReader(reader);
				
				PrintWriter pw=new PrintWriter(out, true);
				
				String content=null;
				while((content=br.readLine())!=null){
					System.out.println("从客户端接收到的信息："+content);
					
					//将消息回发给客户端
					if ("DIR".equals(content)) {
						String output = "";
						File file = new File(InitAddr);
						String[] dirStructure = new String[10];
						dirStructure = file.list();
						for (int i = 0; i < dirStructure.length; i++) {
							output += dirStructure[i] + "\n";
						}
						s = output;
						pw.println(s);
					}else if (content.startsWith("GET")) {
						content = content.substring(3);
						content = content.trim();
						copy(InitAddr+"/"+content,content);
						pw.println("成功获得");
					} else if(content.startsWith("PUT")) {
						content = content.substring(3);
						content = content.trim();
						copy(content,InitAddr+"/"+content);
						pw.println("上传成功");
					}else if("bye".equals(content)){
						break;
					}
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(sc!=null){
					try {
						sc.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		}
	}
	
	/**
	 * 文件的复制
	 * 
	 * @param src
	 * @param dest
	 */
	private static void copy(String src, String dest) {

		// try (BufferedInputStream in = new BufferedInputStream(new
		// FileInputStream(src), 1024 * 1024 * 4);
		// BufferedOutputStream out = new BufferedOutputStream(new
		// FileOutputStream(dest), 1024 * 1024 * 4)) {
		try (FileInputStream in = new FileInputStream(src); 
				FileOutputStream out = new FileOutputStream(dest)) {
			byte[] buf = new byte[1024 * 16];
			int size;
			while (-1 != (size = in.read(buf))) {
				out.write(buf, 0, size);
			}
			System.out.println("复制结束");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		Server server=new Server();
		server.listener();
	}


}
