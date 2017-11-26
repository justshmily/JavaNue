package csust.txr.poker;

/**
 *
 * 花色
 */
public enum Suit {
	
	DIAMONDS("♦"),CLUBS("♣"),HEARTS("♥"),SPADES("♠");
	//这个分号平时可以不写，带属性时要写
	
	private String name;
	
	Suit(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
}
