package sort;

import java.util.Scanner;

public class Compare {

	private static double c;
	
	private static int n;
	
	private static double[] w;
	
	private static double[] p;
	
	private static int[] x;
	
	private static String bestx=""; 
	
	private static double bestp = 0;
	
	public static void main(String[] args) {
		input();
		knapsack(0);
		System.out.println(bestx);
		System.out.println(bestp);
	}
	
	public static void input(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入背包容量：");
		c=sc.nextDouble();
		System.out.println("请输入物品数量：");
		n=sc.nextInt();
		sc.close();
		w=new double[n];
		p=new double[n];
		x=new int[n];
		for(int i=0;i<n;i++){
			w[i]=Math.random()*100.0;
			p[i]=Math.random()*100.0;
		}
	}
	
	public static void knapsack(int t) {
		//n是物品数量，也控制着递归深度
		//t>=n 表示搜索到一个叶节点，然后判断当前总价值是否最优
		if(t>=n) {
			bestx="";
			double cp = 0;
			for(int i= 0;i<n;i++) {
				if(x[i]==1) {
					cp+=p[i];
				}
			}
			if(cp>bestp) {
				bestp=cp;
				for(int i= 0;i<n;i++) {
					bestx = bestx+x[i];
				}
			}
			return ;
		}
		for(int i = 1 ;i>=0;i--) {
			x[t] = i;
			if(bound(t)) {
				knapsack(t+1);
			}
		}
	}

	private static boolean bound(int t) {
		double cw = 0;
		double cp = 0;
		for(int i=0;i<=t;i++) {
			if(x[i]==1) {
				cw += w[i];
				cp += p[i];
			}
		}
		if(cw>c) {
			return false;
		}
		double np=0;
		for(int i = t+1;i<n;i++) {
			np+=p[i];
		}
		if(cp+np<bestp) {
			return false;
		}
		return true;
	}
}
