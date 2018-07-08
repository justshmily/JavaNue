package hash;
/**
 * 散列表（别名 键值对，字典）
 * 
 * @author 谭笑然
 *
 */
public class HashTable {

	String[] keys;
	int[] values;
	
	public HashTable() {
		keys=new String[10];
		values=new int[10];
	}
	
	/**
	 * 放入散列表
	 * 
	 * @param key	键
	 * @param v		值
	 */
	public void put(String key,int v) {
		int index=hash(key);
		//线性探测（冲突探测）
		while(keys[index]!=null) {
			index++;
			if(index==10)
				index=0;
		}
//		if(keys[index]!=null) {
//			Node node=new(v,keys[index],tail);
//		}
		keys[index]=key;
		values[index]=v;
	}
	
	private int hash(String key) {
		int n=0;
		for(char c:key.toCharArray()) {
			n+=c;
		}
		System.out.println(n);
		return n%10;
	}

	/**
	 * 由键获得值	时间复杂度O（C）几乎为1
	 * 
	 * @param key	键（索引）
	 * @return
	 */
	public int get(String key) {
		int index=hash(key);
		while(keys[index]!=key) {
			index++;
			if(index==10)
				index=0;
		}
		return values[index];
	}
	
	public static void main(String[] args) {
		HashTable ha=new HashTable();
		ha.put("aa", 11);
		ha.put("aob", 21);
		ha.put("boa", 54);
		ha.put("dd", 67);
		System.out.println("------------------");
		System.out.println(ha.get("aa"));
		System.out.println(ha.get("bb"));
		System.out.println(ha.get("cc"));
		System.out.println(ha.get("dd"));
	}
}
