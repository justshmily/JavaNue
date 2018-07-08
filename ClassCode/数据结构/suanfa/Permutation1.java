package sort;

import java.util.Scanner;

public class Permutation1 {

	private static int count=0;
	private static int n;
	private static int[] list;
	
	public Permutation1(int n) {
		this.n=n;
		list = new int[n];
		for(int i = 0;i < n;i++) {
			list[i] = (int) (Math.random()*20);
			System.out.print(list[i]+" ");
		}
		pailie(0);
		System.out.println("一共"+count+"种全排列");
	}
	public static void pailie(int i) {
		if(i >= n) {
			output();
			return;
		}
		for(int j = i+1; j < n; j++) {
			if(!same(i,j))
				continue;
			swap(i, j);
			pailie(i+1);
			swap(i, j);
		}
		pailie(i+1);
	}
	
	public static boolean same(int i, int j){  
	  for (int k = i; k < j; k++) {  
		  if(list[j]==list[k]){  
			  return false;  
		  }  
	  }  
	  return true;  
	} 
	
	public static void swap(int i, int j) {
		list[i] ^= list[j];
		list[j] ^= list[i];
		list[i] ^= list[j];
	}
	
	public static void output(){
		count++;
		for(int i = 0;i < n;i++) {
			System.out.print(list[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Permutation1 p=new Permutation1(3);
	}
}
