package csust.txr.meiju;

/**
 *
 * 花色
 */
public enum Suit {
	
	DIAMONDS("方块"),CLUBS("梅花"),HEARTS("红心"),SPADES("黑桃");
	//这个分号平时可以不写，带属性时要写
	
	private String name;
	
	Suit(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
}
