package hash1;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		
		System.out.println(getHash("hh"));
	}

	private static String getHash(String msg) {
		
//		hashtable<K,V>
//		hashSet<E>
		
		//信息摘要
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			
			//String msg="hh";
			
			//16字节的输出
			byte[] output=md.digest(msg.getBytes());
			System.out.println(output.length);
			//System.out.println(Arrays.toString(output));
			
			//十六进制
			String hax=new BigInteger(1,output).toString(16);
			//System.out.println(hax);
			
			return hax;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return msg;
	}
}
