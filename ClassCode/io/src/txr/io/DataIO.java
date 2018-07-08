package txr.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIO {

	public static void main(String[] args) {
		
		//write();
		
		read();
	}

	private static void read() {
		
		try (DataInputStream in=new DataInputStream(
				new FileInputStream("data.txt"))){
			
			int a=in.readInt();
			Boolean b=in.readBoolean();
			double c=in.readDouble();
			String d=in.readUTF();
			
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void write() {
		
		//try-with-resource
		try (DataOutputStream out=new DataOutputStream(
				new FileOutputStream("data.txt"))){
			
			out.writeInt(123);
			out.writeBoolean(true);
			out.writeDouble(3.14);
			out.writeUTF("haha");
			
			System.out.println("ok");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
