package csust.txr.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * 服务器端的处理
 * 
 * @author 15295
 *
 */
public class ServerDo implements Runnable {

	private Socket socket;
	private File folder = null;

	public ServerDo(Socket socket, File folder) {
		this.socket = socket;
		this.folder = folder;
	}

	/**
	 * 处理客户端的请求
	 * 
	 * @param socket
	 */
	public void dealClient(Socket socket) {
		// 获得输入流（客户端->服务器端）
		InputStream in = null;
		InputStreamReader reader = null;
		BufferedReader br = null;

		// 获得输出流(服务器端->客户端）
		OutputStream out = null;
		OutputStreamWriter writer = null;
		PrintWriter w = null;

		try {
			in=socket.getInputStream();
			reader=new InputStreamReader(in);
			br=new BufferedReader(reader);
			
			out = socket.getOutputStream();
			writer = new OutputStreamWriter(out);
			w = new PrintWriter(writer, true);
			
			String msg=null;
			while((msg=br.readLine())!=null) {
				//去掉空格
				msg=msg.trim();
				
				//统一按大写来处理
				msg=msg.toUpperCase();
				
				// 根据客户端发送的指令，调用相应用的业务逻辑执行相应的功能
				System.out.println("从客户端收到的命令:" + msg);

				// 如果是DIR指令，则用来列出目录下所有的文件
				if("DIR".equals(msg)) {
					File[] fs=folder.listFiles();
					StringBuffer sb=new StringBuffer();
					if(fs!=null&&fs.length>0) {
						for(File f:fs) {
							sb.append(f.getName() + "\t" + f.getAbsolutePath()
							+ "\t" + f.lastModified() + "\n");
						}
						DataOutputStream dout=new DataOutputStream(out);
						//发送目录下的所有文件清单给客户端
						dout.writeUTF(sb.toString());
						dout.flush();
					}
				}else if(msg.startsWith("GET")) {
					// 如果是GET指令，则实现文件从服务器端下载
					// 客户端发送的命令为： GET aaa.txt
					
					// 得到文件名
					String[] arrs=msg.split("GET");
					String fileName=null;
					if(arrs!=null&&arrs.length>1) {
						fileName = arrs[1];
						fileName = fileName.trim();
					}
					
					//构造需要下载的File对象、构造数据输入流
					File f=new File(folder,fileName);
					FileInputStream fi=new FileInputStream(f);
					DataInputStream ds=new DataInputStream(fi);
					
					//构造数据输出流，用于将文件发送给客户端
					out=socket.getOutputStream();
					DataOutputStream dout=new DataOutputStream(out);
					
					//将文件写给客户端
					System.out.println("开始将文件写入客户端...");
					int len=ds.available();
					len = len > 1024 ? 1024 : len;
					byte[] b = new byte[len];
					int avaLen=0;
					while((avaLen=ds.read(b))>0) {
						dout.write(b, 0, avaLen);
					}
					dout.flush();
					dout.close();
					ds.close();
					closeSocket(socket);
					System.out.println("写文件至客户端完成");
				}else if("BYE".equalsIgnoreCase(msg)) {
					// 如果是BYE指令，则断开客户端的连接
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeSocket(Socket socket2) {
		if(socket!=null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {

		dealClient(socket);
	}

}
