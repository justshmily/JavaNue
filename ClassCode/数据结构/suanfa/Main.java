package sort;

public class Main {

	private static double c;
	private static int n;
	private static double[] w;
	private static double[] p;
	private static int[] x;
	private static int[] bestx;
	private static int[] th;
	private static double bestp;
	private static double cp;
	private static double cw;
	
	public static void main(String[] args) {
		init();
		long startTime=System.currentTimeMillis();
		sort(0,n-1);	
		System.out.println(java.util.Arrays.toString(th));
		knapsack(0);
		System.out.println(java.util.Arrays.toString(bestx));
		System.out.println(bestp);
		long endTime=System.currentTimeMillis(); 
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}
	
	private static void init() {
		n=5;
		c=100;
		bestp=0;
		cp=0;
		cw=0;
		w=new double[n];
		p=new double[n];
		x=new int[n];
		th=new int[n];
		bestx = new int[n];
		for(int i = 0;i<n;i++) {
			w[i]=Math.floor(Math.random()*50+1);
			p[i]=Math.floor(Math.random()*50+1);
		}
		for(int i =0;i<n;i++){
			th[i] = i;
		}
		
		System.out.println(java.util.Arrays.toString(w));	
		System.out.println(java.util.Arrays.toString(p));
	}

	private static void sort(int left,int right) {
		if(left<right){
			int i=left;
			int j=right+1;
			double x  = p[th[i]]/w[th[i]];
			while(true){
				while(p[th[++i]]/w[th[i]]>x&&i<right);
				while(p[th[--j]]/w[th[j]]<x);
				if(i>=j){
					break;
				}
				swap(i,j);
			}
			swap(left,j);
			sort(left,j-1);
			sort(j+1,right);
		}
	}

    private static void swap(int i, int j) {
		int t = th[i];
		th[i] = th[j];
		th[j] = t;
	}
	
	public static void knapsack(int t) {
		if(t>=n) {
			if(cp>bestp) {
				bestp=cp;
				for(int i= 0;i<n;i++) {
					bestx[i] = x[i];
				}
			}
			return ;
		}
		if(cw+w[th[t]]<=c){
			x[th[t]] = 1;
			cw+=w[th[t]];
			cp+=p[th[t]];
			knapsack(t+1);
			cw-=w[th[t]];
			cp-=p[th[t]];
		}
		if(bound(t+1)){
			x[th[t]] = 0;
			knapsack(t+1);
		}
	}

	private static boolean bound(int t) {
		double np=0;
		double nw=cw;
		while(t<n&&w[th[t]]+nw<c) {
			nw +=w[th[t]];
			np +=p[th[t]];
			t++;
		}
		if(t<n) {
			np+=p[th[t]]/w[th[t]]*(c-nw);
		}
		if(cp+np<bestp) {
			return false;
		}
		return true;
	}
}
