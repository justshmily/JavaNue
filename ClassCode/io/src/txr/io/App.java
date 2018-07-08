package txr.io;

import java.io.FileReader;
import java.io.FileWriter;

public class App {

	public static void main(String[] args) {
		
//		try (KaisaWriter out=new KaisaWriter(
//				new FileWriter("k.txt"))){
//			
//			out.write("hello");
//			
//			System.out.println("ok");
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		try (KaisaReader in=new KaisaReader(
				new FileReader("k.txt"))){
			
			int size;
			while(-2!=(size=in.read())) {
				System.out.print((char)size);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
