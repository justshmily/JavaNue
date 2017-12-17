package list;

public class List implements AdtList{

	private static int Init_size=10;
	/**
	 * 数据
	 */
	private String [] data;
	/**
	 * 大小
	 */
	private int size;
	
	public List() {
		data=new String[Init_size];
	}
	
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void clear() {
		size=0;
	}

	@Override
	public void add(String s) {
		addCapacity();
		data[size++]=s;
	}

	private void addCapacity() {
		if(size==data.length) {
			//扩容
			String[] newData=new String[size+Init_size];
			for(int i=0;i<data.length;i++) {
				newData[i]=data[i];
			}
			data=newData;
		}
	}

	@Override
	public void add(String s, int index) {
		addCapacity();
		for(int i=size-1;i>=index;i--) {
			data[i+1]=data[i];
		}
		data[index]=s;
		size++;
	}

	@Override
	public String get(int index) {
		if(index>size)
			throw new IndexOutOfBoundsException();
		return data[index];
	}

	@Override
	public String remove(int index) {
		String n=data[index];
		for(int i=index+1;i<size;i++) {
			data[i-1]=data[i];
		}
		size--;
		return n;
	}

	@Override
	public int size() {
		return size;
	}
	
	public void show() {
		for(int i=0;i<size;i++) {
			System.out.print(data[i]+" ");
			if((i+1)%5==0)
				System.out.println();
		}
		System.out.println();
	}
}
