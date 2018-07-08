package sort;

import java.util.Arrays;

public class Permutation2 {
	
	int[] a;
	StringBuffer r = new StringBuffer();
	int count = 0;

	public Permutation2(int[] a) {
		this.a = a;
	}

	public void backtrack(int k) {
		if (k >= a.length) {
			count++;
			r.append(Arrays.toString(a) + "\n");
			return;
		}
		for (int i = k; i < a.length; i++) {
			if(isSame(k,i)) 
				continue;
			swap(i, k);
			backtrack(k + 1);
			swap(i, k);
		}
	}

	private boolean isSame(int k, int i) {
		for(int j = k; j < i; j++)
			if(a[i]==a[j])
				return true;
		return false;
	}

	private void swap(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int[] a = {1,2,2,1};
		Permutation2 p = new Permutation2(a);
		p.backtrack(0);
		System.out.println(p.r);
		System.out.println(p.count);
	}
}
