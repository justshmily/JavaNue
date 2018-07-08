package heap;

import java.util.Arrays;

public class Heap implements IHeap{

	//物理结构
	//完全二叉树
	int[] data=new int[17];
	
	int current=1;
	
	@Override
	public void add(int n) {
		if(current==1) {
			data[current]=n;
		}else {
			int next=current;
			while((next/2)!=0&&n>data[next/2]) {
				data[next]=data[next/2];
				next=next/2;
			}
			data[next]=n;
		}
		current++;
	}

	@Override
	public void remove() {
		int next=1;
		while((next*2)!=current&&(data[current-1]<data[next*2]||data[current-1]<data[next*2+1])) {
			if(data[next*2+1]>data[next*2]&&data[current-1]<data[next*2+1]) {
				data[next]=data[next*2+1];
				next=next*2+1;
			}else if(data[current-1]<data[next*2]&&data[current-1]<data[next*2]){
				data[next]=data[next*2];
				next=next*2;
			}
		}
		data[next]=data[--current];
		data[current]=0;
	}
	
	public void sort() {
		for(int i=0;i<current;i++) {
			change(current-i);
		}
	}
	
	public void change(int cur) {
		int now=cur;
		int next=1;
		int temp=data[1];
		System.out.println(temp);
		while((next*2)!=now&&(data[now-1]<data[next*2]||data[now-1]<data[next*2+1])) {
			if(data[next*2+1]>data[next*2]&&data[now-1]<data[next*2+1]) {
				data[next]=data[next*2+1];
				next=next*2+1;
			}else if(data[now-1]<data[next*2]&&data[now-1]<data[next*2+1]){
				data[next]=data[next*2];
				next=next*2;
			}
		}
		data[next]=data[--now];
		data[now]=temp;
	}

	public void display() {
		System.out.println(Arrays.toString(data));
	}
	
	public static void main(String[] args) {
		Heap heap=new Heap();
		
		heap.add(8);
		heap.add(18);
		heap.add(4);
		heap.add(6);
		heap.add(9);
		heap.add(22);
		heap.add(45);
		heap.add(17);
		
		heap.display();
		for(int i=0;i<8;i++) {
			heap.remove();
//			heap.change(9-i);
			heap.display();
		}
	}
}
