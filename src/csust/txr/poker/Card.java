package csust.txr.poker;

public class Card implements Comparable<Card>{
	
	/**
	 * 大小
	 */
	private Rank rank;
	
	/**
	 * 花色
	 */
	private Suit suit;
	
	public Card(Rank rank,Suit suit) {
		this.rank=rank;
		this.suit=suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public String toString() {
		return String.format("%s%s",suit.getName(),rank.getName());
	}

	@Override
	public int compareTo(Card o) {
		int r=suit.compareTo(o.suit);
		return r!=0?r:(rank.getLevel()-o.rank.getLevel());
	}
	
}
