package txr.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class ByteIO {

	public static void main(String[] args) {
		
		//read();
		//copy("com/b","com/a");
		copyFolder("com","c");
		
	}

	private static void copyFolder(String src, String dest) {
		
		File file1=new File(src);  
        File[] fs=file1.listFiles();  
        File file2=new File(dest);  
        
        if(!file2.exists()){  
            file2.mkdirs();  
        }  
        for (File f : fs) {  
            if(f.isFile()){  
                copy(f.getPath(),dest+"/"+f.getName()); //调用文件拷贝的方法  
            }else if(f.isDirectory()){  
                copyFolder(f.getPath(),dest+"/"+f.getName());  
            }  
        }  
        
        System.out.println("文件夹复制结束");
	}

	//参数为文件名，不带后缀
	private static void copy(String src,String dest) {
		
//		try (FileInputStream in=new FileInputStream(src);
//				FileOutputStream out=new FileOutputStream(dest))
		
		try (BufferedInputStream in=new BufferedInputStream(new FileInputStream(src),1024*32);
				BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(dest),1024*32)){
			
			byte[] buf=new byte[1024*16];
			int size;
			
			while(-1 != (size=in.read(buf))) {
				out.write(buf,0,size);
			}
			System.out.println("复制结束");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void read() {
		try (FileInputStream in=new FileInputStream("data.txt")){
			
			byte[] buf=new byte[32];
			int size=in.read(buf);
			System.out.println(Arrays.toString(buf));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
