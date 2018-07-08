package txr.io.hash;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class App {

	public enum Type{
		
		//分别是16字节，20，32
		MD5("MD5",1),SHA1("SHA-1",2),SHA2("SHA-256",3);
		
		String value;
		int n;
		
		Type(String value,int n){
			this.value =value;
			this.n=n;
		}
		
		public String getValue() {
			return value;
		}
		
		public int getN() {
			return n;
		}
	}
	
	public static void main(String[] args) {
		
		//不同的输入，获得固定长度的输出；相同的数据得到的散列值相同
		try {
//			System.out.println(hash("hello",Type.MD5));
//			System.out.println(hash("hlo",Type.MD5));
//			System.out.println(hash("hello",Type.SHA1));
//			System.out.println(hash("hello",Type.SHA2));
			
			System.out.println(hash(new File("p10.jpg"),Type.MD5));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param file
	 * @param type
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	private static String hash(File file,Type type ) throws NoSuchAlgorithmException {
		
		//File-->byte[]data
		ByteArrayOutputStream out =new ByteArrayOutputStream();
		
		try (FileInputStream in=new FileInputStream(file)){
			
			byte[] buf=new byte[1024*4];
			int size;
			while(-1 != (size=in.read(buf))) {
				out.write(buf,0,size);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//获得文件中的所有数据
		byte[] data=out.toByteArray();
		
		//获得摘要信息
		byte[] result=MessageDigest.getInstance(type.getValue()).digest(data);
		
		//返回摘要信息的十六进制格式
		return new BigInteger(1,result).toString(16);
	}

	/**
	 * 
	 * @param text
	 * 			要处理的文本格式数据
	 * @param type
	 * 			散列算法的名称（枚举）
	 * @return
	 * @throws NoSuchAlgorithmException
	 * 			算法名错误
	 */
	private static String hash(String text, Type type) throws NoSuchAlgorithmException {
		
		byte[] data=text.getBytes();
		
		//获得摘要信息
		byte[] result= MessageDigest.getInstance(type.getValue()).digest(data);
		System.out.println(Arrays.toString(result));
		
		//把十进制的数值转换成十六进制的形式
		return new BigInteger(1,result).toString(16);
		
		//return String.valueOf(result.length);
	}
}
