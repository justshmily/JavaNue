package com.newer.office;

public class Office {

	/**
	 * 工厂方法
	 * 
	 * @param type
	 * @param title
	 * @return
	 */
	public static Doc create(DocType type, String title) {
		Doc doc = null;
		switch (type) {
		case WORD:
			doc = new Word(title);
			break;
		case EXCEL:
			doc = new Excel(title);
			break;
		case PPT:
			doc = new Ppt(title);
			break;
		}
		return doc;
	}

	/**
	 * 创建文档
	 * 
	 * @param type
	 * @return Doc
	 */
	public static Doc create(DocType type) {
		Doc doc = null;
		switch (type) {
		case WORD:
			doc = new Word();
			break;
		case EXCEL:
			doc = new Excel();
			break;
		case PPT:
			doc = new Ppt();
			break;
		}
		return doc;
	}
}
