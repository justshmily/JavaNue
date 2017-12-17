package link;

public interface AdtList {

	/**
	 * 判断是否为空
	 * @return
	 */
	boolean isEmpty();
	/**
	 * 清空
	 */
	void clear();
	/**
	 * 添加一个元素
	 */
	void add(String s);
	/**
	 * 指定位置添加
	 * @param s
	 * @param index
	 */
	void add(String s,int index);
	/**
	 * 获得一个元素
	 * @param index
	 * @return
	 */
	String get(int index);
	/**
	 * 删除一个元素
	 * @param index
	 * @return
	 */
	String remove(int index);
	/**
	 * 得到元素的隔个数
	 * @return
	 */
	int size();
}
