package sort;

import java.util.Scanner;

public class Knakpack {

	private static double c;
	private static int n;
	private static double[] w;
	private static double[] p;
	private static double[] prep;
	private static double cw;
	private static double cp;
	private static int[] x;
	private static int[] order;
	private static int[] bestx;
	private static double bestp;
	
	public static void main(String[] args) {
		input();
		long st=System.currentTimeMillis();
		getPrep();
		quickSort(0,n-1);
		knapsack(0);
		System.out.println(java.util.Arrays.toString(bestx));
		System.out.println("最优价值："+bestp);
		System.out.println("求解用时："+(System.currentTimeMillis()-st)+"毫秒");
	}
	
	public static void input(){
		cw=0;
		cp=0;
		bestp=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入背包容量：");
		c=sc.nextDouble();
		System.out.print("请输入物品数量：");
		n=sc.nextInt();
		sc.close();
		w=new double[n];
		p=new double[n];
		prep=new double[n];
		x=new int[n];
		order=new int[n];
		bestx=new int[n];
		for(int i=0;i<n;i++){
			w[i]=Math.ceil(Math.random()*50);
			p[i]=Math.ceil(Math.random()*50);
		}
		//System.out.println(java.util.Arrays.toString(w));
		//System.out.println(java.util.Arrays.toString(p));
	}
	
	public static void getPrep() {
		for(int i=0;i<n;i++) {
			prep[i]=p[i]/w[i];
			order[i]=i;
		}	
	}
	
	public static void quickSort(int left,int right) {
		if(left<right){
			int i=left;
			int j=right+1;
			double x  = prep[i];
			while(true){
				while(prep[++i]>x&&i<right);
				while(prep[--j]<x);
				if(i>=j){
					break;
				}
				swapOrder(i,j);
			}
			swapOrder(left,j);
			quickSort(left,j-1);
			quickSort(j+1,right);
		}
	}
	
	public static void swapOrder(int i,int j) {
		int t=order[i];
		order[i]=order[j];
		order[j]=t;
		double pre=prep[i];
		prep[i]=prep[j];
		prep[j]=pre;
		
	}
	
	public static void knapsack(int t) {
		if(t>=n) {
			if(cp>bestp) {
				bestp=cp;
				for(int i= 0;i<n;i++) {
					bestx [i]=x[i];
				}
			}
			return ;
		}
		if(cw+w[order[t]]<=c){
			x[order[t]] = 1;
			cw+=w[order[t]];
			cp+=p[order[t]];
			knapsack(t+1);
			cw-=w[order[t]];
			cp-=p[order[t]];
		}
		if(bound(t+1)){
			x[order[t]] = 0;
			knapsack(t+1);
		}
	}

	private static boolean bound(int t) {
		double bp=0;
		double bw=cw;
		while(t<n&&w[order[t]]+bw<c) {
			bw +=w[order[t]];
			bp +=p[order[t]];
			t++;
		}
		if(t<n) {
			bp+=prep[t]*(c-bw);
		}
		if(cp+bp<bestp) {
			return false;
		}
		return true;
	}
}
