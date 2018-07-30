package csust.txr.meiju;

/**
 * 扑克
 * @author 谭笑然
 *
 */
public class Porker {
	
	public static final int SIZE=52;
	
	private Card[] cards=new Card[SIZE];
	
	//创建一副扑克
	public Porker() {
		int i=0;
		//for-each，外循环花色，内循环大小
		for(Suit suit:Suit.values()){
			for(Rank rank:Rank.values()) {
				cards[i++]=new Card(rank,suit);
			}
		}
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	/**
	 * 打印扑克
	 */
	public void display() {
		int i=0;
		for(Card cards:cards) {
			System.out.print(cards.toString()+"\t");
			if(i++%13==12)
				System.out.println();
		}
	}
}
