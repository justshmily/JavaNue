package txr.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class ByteArray {

	public static void main(String[] args) {

		//编码
		//encode();
		
		//解码
		decode();
	}

	private static void decode() {
		
		try (BufferedInputStream in =new BufferedInputStream(
				new FileInputStream("p.txt"));
				BufferedOutputStream out=new BufferedOutputStream(
						new FileOutputStream("img/p.jpg"))){
			
			ByteArrayOutputStream baos=new ByteArrayOutputStream(1024*4);
			
			byte[] buf=new byte[1024*4];
			int size;
			while(-1 != (size=in.read(buf))) {
				//写入
				baos.write(buf, 0, size);
			}
			
			//获得所有数据
			byte[] data=baos.toByteArray();
			
			byte[] s=Base64.getDecoder().decode(data);
			out.write(s);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void encode() {
		
		//读取文件
		try (BufferedInputStream in =new BufferedInputStream(
				new FileInputStream("img/p10.jpg"));
				BufferedOutputStream out=new BufferedOutputStream(
						new FileOutputStream("p.txt"))){
			
			//内存数组，长度会自动增长
			ByteArrayOutputStream baos=new ByteArrayOutputStream(1024*4);
			
			byte[] buf=new byte[1024*4];
			int size;
			while(-1 != (size=in.read(buf))) {
				//写入
				baos.write(buf, 0, size);
			}
			
			//获得所有数据
			byte[] data=baos.toByteArray();
			
			//编码
			String result=Base64.getEncoder().encodeToString(data);
			byte[] r=Base64.getEncoder().encode(data);
			
			//System.out.println(result);
			
			//解码
			//byte[] s=Base64.getDecoder().decode(data);
			
			//写入文档
			out.write(r);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
