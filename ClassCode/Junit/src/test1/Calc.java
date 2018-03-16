package test1;

public class Calc {

	public int add(int i,int j) {
		return i+j;
	}
	
	public int div(int i,int j) {
		return i/j;
	}
	public static void main(String[] args) {

		Calc c=new Calc();
		int r=c.add(10, 10);
		System.out.println(r);
	}

}
