package queue;

public class Yuesefu {

	int n,k,m;
	public Yuesefu(int n,int k,int m) {
		this.n=n;
		this.k=k;
		this.m=m;
	}
	public void yuesefu() {
		int size=n;
		int[] arr =new int[n];
		boolean[] live= new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
			live[i]=true;
		}
		int tag=0;
		for(int i=k-1;i<n;i++) {
			tag++;
			if(tag==m) {
				live[i]=false;
				size--;
				tag=0;
			}
			if(size==1)
				break;
		}
		while(size!=1) {
			for(int i=0;i<n;i++) {
				if(live[i]) {
					if(tag==m) {
						live[i]=false;
						size--;
						tag=0;
					}
				}
				if(size==1) {
					break;
				}
			}if(size==1) {
				break;
			}
			System.out.println("kk");
		}
		for(int i=0;i<n;i++) {
			if(live[i]) {
				System.out.println(i+1);
				break;
			}
		}
	}
	public static void main(String[] args) {
		Yuesefu y=new Yuesefu(9,3,4);
		y.yuesefu();
		System.out.println("kk");
	}
}
