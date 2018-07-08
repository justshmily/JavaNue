package com.newer.type2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	private Object source;
	private Object target;

	public FileCopy(String source, String target) {
		this.source = source;
		this.target = target;
	}

	public FileCopy(File source, File target) {
		this.source = source;
		this.target = target;
	}

	public FileCopy(InputStream source, OutputStream target) {
		this.source = source;
		this.target = target;
	}

	public void copy() {
		String sou=null;
		String targ=null;
		if (source instanceof String) {
			sou = (String) source;
		}
		if (target instanceof String) {
			targ = (String) target;
		}
		try {
			InputStream in=new FileInputStream(sou);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
