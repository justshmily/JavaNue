package sort;

import java.util.ArrayList;
import java.util.List;
/*
 * 回溯法
 * 列出集合1-n的所有k组合（有k个数的子集合）n,k为正
 */
class GenerateP3 {

	private static int n;
	private static int k;
	private static int count;
	private static int arr[];
	private static List<Integer> list=new ArrayList<>();
	
	public GenerateP3(int n,int k) {
		this.n=n;
		this.k=k;
		arr = new int[n];
		for (int i = 0; i< n; i++) {
			arr[i] = i+1;
		}
		generate(0);
		System.out.println(count+"种组合");
	}
	private static void generate(int index) {
		if (index<= arr.length&&list.size()==k) {
			System.out.println(list);
			count++;
		}
		for (int i = index; i<arr.length; i++) {
			list.add(arr[i]);
			generate(i + 1);
			list.remove(list.size() - 1);
		}
	}
}


public class Permutation3 {
	 
    public static void main(String[] args) {
        GenerateP3 generateP3 = new GenerateP3(3,2);
    }
 
}