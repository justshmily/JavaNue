package txr.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TextIO {

	public static void main(String[] args) {
		
		//数据的写
		//write();
		
		//数据的读
		//read();
		
		readLine();
	}

	private static void readLine() {
		
		try (BufferedReader in=new BufferedReader(new FileReader("data.txt"))){
			
			int counter=0;
			String line;
			
			while(null!=(line=in.readLine())) {
				counter++;
				System.out.printf("%04d %s\n",counter,line);
			}
			System.out.println("ok "+counter);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("over");
	}

	private static void read() {
		
//		try (FileReader in=new FileReader("data.txt"))
		try (BufferedReader in=new BufferedReader(new FileReader("data.txt"),32*1024)) {
			
			//一次读一个字符，要类型转换，默认整形编码
			//char a=(char) in.read();
			
			//读一个访问一次磁盘，效率低
//			int c;
//			while(-1!=(c=in.read())) {
//				System.out.println((char)c);
//			}
			
			//先用一个数组缓存，覆盖
			char[] buf=new char[6];
			int size;
			//StringBuffer/StringBuilder
			StringBuilder builder=new StringBuilder();
			while(-1 != (size=in.read(buf))) {
				builder.append(buf,0,size);
			}
			System.out.println(builder.toString());
			
		} catch (Exception e) {
			
		}
		
	}

	private static void write() {
		String text="hello,你好";
		System.out.println(text.length());
		
		File file=new File("data.txt");

		//老版本的写法
		
//		FileWriter out=null;
//		try {
//			out=new FileWriter(file);
//			out.write("abc");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			if(out!=null) {
//				try {
//					out.close();
//				} catch (IOException e2) {
//					out=null;
//				}
//			}
//		}
		
		
//		BufferedWriter writer=null;
//		writer.write("abc");
//		writer.write("def");
//		writer.write("gh");
//		writer.flush();
//		writer.close();
		
		
		//使用输出流，写数据
		//参数true（追加），默认false(覆盖）
		try (FileWriter out =new FileWriter(file,true)){
			out.write(text);
			System.out.println("ok");
			
			//1.7开始默认这两个功能执行，流的刷新和关闭
			//out.flush();
			//out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//使用缓冲，默认满8K写或关闭时写
		try (BufferedWriter out =new BufferedWriter(new FileWriter(file,true),1024*16)){
			out.write(text);
			out.flush();
			
			out.write(text);
			out.flush();
			
			out.write(text);
			out.flush();
			
			System.out.println("ok");
			
			//1.7开始默认这两个功能执行，流的刷新和关闭
			//out.flush();
			//out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
