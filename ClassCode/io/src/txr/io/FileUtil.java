package txr.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;

/**
 * 文件操作的工具类
 * 
 * @author 15295
 *
 */
public class FileUtil {
	
	//内部类
	static class FileInfo{
		long length;
		long fileSize;
		long folderSize;
	}
	
	public static FileInfo getFileInfo(File path) {
		FileInfo info=new FileInfo();
		if(path.isFile()){
			info.length=path.length();
			info.fileSize=1;
			info.folderSize=0;
			return info;
		}
		
		info.length=0;
		info.fileSize=0;
		info.folderSize=0;
		
		//遍历内部的文件
		File[] files=path.listFiles();
		for(File file : files) {
			if (file.isFile()) {
				//文件
				info.length+=file.length();
				info.fileSize++;
			} else {
				//文件夹
				info.folderSize++;
				FileInfo info2= getFileInfo(file);
				info.length+=info2.length;
				info.fileSize+=info2.fileSize;
				info.folderSize+=info2.folderSize;
			}
		}
		
		return info;
	}
	
	/**
	 * 删除一个文件夹
	 * 
	 * @param path
	 */
	public static void rm(File path) {
		if (path.isDirectory()) {  
            File[] files = path.listFiles();  
            if (files.length==0) {  
            	path.delete();  
            }  
            for (File file : files) {  
                if (file.isFile()) {  
                	file.delete();  
                }else{  
                    rm(file);  
                    file.delete();  
                }  
            } 
            path.delete();  
        }else{  
        	path.delete();  
        }  
	}
	
	static class JavaFileFilter implements FileFilter{

		@Override
		public boolean accept(File pathname) {
			
			//return pathname.isDirectory()
			//		||(pathname.isFile()&&pathname.getName().startsWith("a"));
			
			return pathname.isDirectory()
					||(pathname.isFile()&&pathname.getName().endsWith(".java"));
		}
		
	}
	
	/**
	 * 获取文件的数量
	 * 
	 * @param path
	 * @return
	 */
	public static long fileSize(File path) {
		int size=0;
		File[] files=path.listFiles(new JavaFileFilter());
		for(File file : files) {
			if(file.isFile())
				size++;
			else
				size+=fileSize(file);
		}
		return size;
	}
	
	/**
	 * 获取文件夹的数量
	 * 
	 * @param path
	 * @return
	 */
	public static long folderSize(File path) {
		int sum=0;
		
		File[] files=path.listFiles();
		for(File file :files) {
			if(file.isDirectory()) {
				sum++;
				sum+=folderSize(file);
			}
		}
		return sum;
	}

	/**
	 * 递归统计文件夹的大小
	 * 
	 * @param path
	 * 				文件夹
	 * @return  long   文件夹的大小，单位是字节
	 */
	public static long length(File path) {
		if(path.isFile())
			return path.length();
		
		long sum=0;
		
		//遍历内部的文件
		File[] files=path.listFiles();
		for(File file : files) {
			if (file.isFile()) {
				//文件
				sum+=file.length();
			} else {
				//文件夹
				sum+=length(file);
			}
		}
		return sum;
	}
	
	public static long getLine(File path) {
		if(path.isFile())
			return readLine(path);
		
		long sum=0;
		
		//遍历内部的文件
		File[] files=path.listFiles();
		for(File file : files) {
			if (file.isFile()) {
				//文件
				sum+=readLine(file);
			} else {
				//文件夹
				sum+=getLine(file);
			}
		}
		return sum;
	}
	private static long readLine(File file) {

		long counter=0;
		try (BufferedReader in=new BufferedReader(new FileReader(file))){
			
			String line;
			
			while(null!=(line=in.readLine())) {
				counter++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			return counter;
		}
	}
	
}
