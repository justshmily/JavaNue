package csust.txr.yanghui;

import java.util.Scanner;

public class Yanghui {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("#");
		int n=sc.nextInt();
		sc.close();
		
		int[][] m=new int[n+1][];
		for(int i=0;i<m.length;i++) {
			//创建一维数组
			m[i]=new int[i+1];
			
			m[i][0]=m[i][i]=1;
			
			if(i>1) {
				for(int j=1;j<m[i].length-1;j++) {
					m[i][j]=m[i-1][j]+m[i-1][j-1];
				}
			}
		}
		
		for(int[] t:m) {
			for(int e:t) {
				System.out.print(e+"\t");
			}
			System.out.println();
		}
		
	}
}
