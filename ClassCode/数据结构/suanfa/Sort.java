package sort;

import java.util.Random;
/*
 * 将集合进行全排列  按字典序从小到大输出
 */
public class Sort {
	
	public static int NUM=1111;
	public static int[] randomNumber= new int[NUM];
	public static int[] randomNumber2= new int[NUM];
	public static int[] tempNumber= new int[NUM];
	
	public static void main(String[] args) {
		createNumber();
		System.out.println("本次排序为"+NUM+"个0-"+NUM+"之间的正整数");
		
		//printf(randomNumber);
		long st=System.currentTimeMillis();
		quickSort(0,NUM-1);
		long et=System.currentTimeMillis();
		System.out.println("快速排序用时："+(et-st)+"毫秒");
		//printf(randomNumber);

		st=System.currentTimeMillis();
		mergeSort(0,NUM-1);
		et=System.currentTimeMillis();
		System.out.println("快速排序用时："+(et-st)+"毫秒");
		//printf(randomNumber2);
	}
	
	//产生NUM个随机数
	public static void createNumber() {
		Random random=new Random();
		int n=0;
		for(int i=0;i<NUM;i++) {
			n=random.nextInt(NUM);//产生0-NUM之间的随机数
			randomNumber[i]=n;
			randomNumber2[i]=n;
		}
	}
	
	//输出数组
	public static void printf(int[] a) {
		int count=0;
		for(int i:a) {
			System.out.print(i+" ");;
			count++;
			if(count==20) {
				count=0;
				System.out.println();
			}
		}
	}
	
	//快速排序
	public static void quickSort(int a,int b) {
		if(a>=b) {
			return;
		}
		int left=a;
		int right =b;
		int key=randomNumber[left];
		while(left<right) {
			while(randomNumber[right]>=key&&left<right) {
				right--;
			}
			randomNumber[left]=randomNumber[right];
			while(randomNumber[left]<=key&&left<right) {
				left++;
			}
			randomNumber[right]=randomNumber[left];
		}
		randomNumber[left]=key;
		quickSort(a,left);
		quickSort(left+1,b);
	}
	
	//归并排序 合并
	public static void merge(int left,int mid,int right) {
		int i=left;
		int j=mid+1;
		int k=left;
		while(i<=mid&&j<=right) {
			if(randomNumber2[i]<randomNumber2[j]) {
				tempNumber[k++]=randomNumber2[i++];
			}else {
				tempNumber[k++]=randomNumber2[j++];
			}
		}
		while(i<=mid) {
			tempNumber[k++]=randomNumber2[i++];
		}
		while(j<=right) {
			tempNumber[k++]=randomNumber2[j++];
		}
		for(int t=left;t<=right;t++) {
			randomNumber2[t]=tempNumber[t];
		}
	}
	
	//归并排序
	public static void mergeSort(int left,int right) {
		if(left>=right) {
			return;
		}
		int mid=(left+right)/2;
		mergeSort(left,mid);
		mergeSort(mid+1,right);
		merge(left,mid,right);
	}

}

