package sort;

public class Week {


	public static void main(String[] args) {
//		int[] a=new int[9];
//		a[0]=a[1]=1;
//		
//		for(int i=2;i<9;i++) {
//			a[i]=a[i-1]+a[i-2];
//		}
//		for(int i=0;i<9;i++)
//			System.out.println(a[i]);
		
		int n=9;
		//System.out.println(f(40));
		System.out.println(g(5));
	
		
	}

	static int g(int n) {

		if(n==1)
			return 1;
		else 
			return n*g(n-1);
	}

	public static int f(int n) {
		if(n<=0)
			return 0;
			else if(n==1&&n==2)
			return 1;
		else 
			return f(n-1)+f(n-2);
	}
}