package csust.txr.poker;

public enum Gender {

	//MALE,FMALE

	MALE(1,'男'),FMALE(2,'女');
	
	private int n;
	private char zi;
	
	/**
	 * @param n
	 * @param zi
	 */
	private Gender(int n, char zi) {
		this.n = n;
		this.zi = zi;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public char getZi() {
		return zi;
	}

	public void setZi(char zi) {
		this.zi = zi;
	}
	
}
