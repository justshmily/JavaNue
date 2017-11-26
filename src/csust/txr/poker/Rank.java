package csust.txr.poker;

/**
 * 大小
 * @author 谭笑然
 *
 */
public enum Rank {

	THREE("3",3),FOUR("4",4),FIVE("5",5),SIX("6",6),SEVEN("7",7),
	EIGHT("8",8),NINE("9",9),TEN("10",10),JACK("J",11),QUEEN("Q",12),
	KIN("K",13),ACE("A",14),DEUCE("2",15);
	
	private String name;
	private int level;
	
	Rank(String name,int level){
		this.name=name;
		this.level=level;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
}
