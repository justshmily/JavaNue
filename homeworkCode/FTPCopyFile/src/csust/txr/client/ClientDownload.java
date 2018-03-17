package csust.txr.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 从服务器下载文件
 * 
 * @author 15295
 *
 */
public class ClientDownload implements Runnable {

	private Socket socket = null;

	// 文件下载目录
	private String folder = null;
	
	//文件名
	private String fileName="myfile.txt";

	// 下载文件的指令，如: get emp.txt
	private String cmd = null;
	
	/**
	 * 
	 * @param socket
	 * @param folder   文件下载目录
	 * @param cmd   下载文件的指令，如： get aa.txt
	 */
	public ClientDownload(Socket socket, String folder, String cmd) {
		this.socket = socket;
		this.folder = folder;
		this.cmd = cmd;
		
		/*
		 * 如果目录不存在，则创建
		 */
		File f = new File(folder);
		if (!f.exists()) {
			f.mkdirs();
		}

	}
	
	@Override
	public void run() {
		download();
	}

	/**
	 * 从服务器接收消息
	 */
	public void download() {

		// 输出流（客户端-服务器）
		OutputStream out = null;
		PrintWriter pw = null;

		// 输入流（服务器->客户端）
		InputStream in = null;
		try {
			out = socket.getOutputStream();
			pw = new PrintWriter(out, true);
			
			// 向服务器发送下载文件的指令
			pw.println(cmd);
			System.out.println("发送下载文件指令完成,并开始下载文件....");
			System.out.println("文件目录："+folder+",文件名："+fileName);

			in = socket.getInputStream();
			DataInputStream ds = new DataInputStream(in);

			// 获得服务器的文件名
			//String fname = ds.readUTF();
			File f = new File(folder, fileName);

			// 将文件写入本地
			FileOutputStream fOut = new FileOutputStream(f, false);
			DataOutputStream dataOut = new DataOutputStream(fOut);

			// 获得读取到流中的字节数
			int len = ds.available();

			//初始化缓冲区大小
			len = len == 0 ? 1024 : len;
			byte[] b = new byte[len];
			int avalLen=0;
			while ((avalLen=ds.read(b)) >0) {
				dataOut.write(b, 0, avalLen);
			} 
			dataOut.close();
			ds.close();
			socket.close();
			System.out.println("文件下载完成");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 为下载的文件命名
	 * @param fileName
	 */
	public void setFileName(String fileName){
		this.fileName=fileName;
	}
}
