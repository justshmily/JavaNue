package com.newer.type2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.chainsaw.Main;

public class FileCopy2<T> {
	private T from;// 源文件
	private T to;// 目标文件

	public FileCopy2(T from, T to) {
		this.from = from;
		this.to = to;
	}

	public void copy() {
		// 得到源文件类型
		String fromType = from.getClass().getName();
		String toType = to.getClass().getName();

		File source = null;
		File target = null;

		if ("java.lang.String".equals(fromType) && "java.lang.String".equals(toType)) {
			source = new File((String) from);
			target = new File((String) to);

		} else if ("java.io.File".equals(fromType) && "java.io.File".equals(toType)) {
			source = (File) from;
			target = (File) to;
		}

		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(target);
			
			byte[] b=new byte[1024];
			int len=0;
			while((len=in.read(b))>0){
				out.write(b, 0, len);
			}
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
	public static void main(String[] args) {
		String from="e:/temp/log/info.log";
		String to="e:/temp/log/info2.log";
		FileCopy2<String> fc=new FileCopy2<String>(from, to);
		//fc.copy();
		
		File from2=new File(from);
		File to2=new File(to);
		FileCopy2<File> fc2=new FileCopy2<File>(from2,to2);
		fc2.copy();
		System.out.println("over");
		
	}

}
