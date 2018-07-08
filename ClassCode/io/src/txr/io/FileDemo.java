package txr.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) {
		
		File  src= new File("F:/Java/src/src");
		
		long size=FileUtil.length(src);
		
		File data=new File("com");
//		System.out.println("文件共有行数："+FileUtil.getLine(src));
		
//		System.out.printf("%d字节",size);
//		System.out.println(FileUtil.fileSize(src));
//		System.out.println(FileUtil.folderSize(src));
		
//		System.out.println("文件大小"+FileUtil.getFileInfo(src).length);
//		System.out.println("文件数量"+FileUtil.getFileInfo(src).fileSize);
//		System.out.println("文件夹数量"+FileUtil.getFileInfo(src).folderSize);
		
//		FileUtil.rm(src);
		
		//文件的名字构成的数组
//		String[] names =src.list();
//		for(String name:names) {
//			System.out.println(name);
//		}
		
//		File[] files =src.listFiles();
//		for(File f:files) {
//			if(!f.isHidden())
//				System.out.println(f);
//		}

//		//path 名称：绝对路径（指定了根目录）/相对路径
//		File f1=new File("abc.txt");
//		
//		System.out.println(f1.exists());
//		
//		if(!f1.exists()) {
//			//创建一个文件
//			try {
//				f1.createNewFile();
//				//可能不执行
//				System.out.println("创建成功");
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.out.println("创建失败");
//			}
//		}
//		
//		File f2=new File("img/abc/def");
//		if(!f2.exists()) {
//			//f2.mkdir();		//单一
//			f2.mkdirs();		//嵌套结构
//		}
//		
//		File path=new File("com/mi");
//		File file=new File(path,"index.html");
//		
//		System.out.println(path.isDirectory());
//		System.out.println(path.isFile());
//		
//		System.out.println(file.isDirectory());
//		System.out.println(file.isFile());
//		
//		//是否是隐藏文件  .git.info
//		System.out.println(file.isHidden());
//		
//		System.out.println(file.getParentFile());
//		System.out.println(file.length());
//		System.out.println(file.lastModified());	//最后修改时间
//		System.out.println(new Date(file.lastModified()).toLocaleString());
//		
//		System.out.println(path.length());
//		
//		if(!path.exists()) {
//			path.mkdirs();
//		}
//		
//		if(!file.exists()) {
//			try {
//				file.createNewFile();
//				System.out.printf("%s 创建成功\n",file.getName());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
