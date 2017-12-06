package csust.txr.poker;

import java.lang.reflect.Array;

public class Game {

	private Porker porker;
	
	public Game() {
		porker=new Porker();
	}
	
	public Porker getPorker() {
		return porker;
	}
	
	/**
	 * 洗牌
	 */
	public void shuffle() {
		Card[] cards=porker.getCards();
		for(int i=cards.length-1;i>0;i--) {
			//0<=r<1
			int r=(int)(Math.random()*i);
			
			//交换r和i
			Card t=cards[i];
			cards[i]=cards[r];
			cards[r]=t;
		}
	}
	
	/**
	 * 发牌
	 */
	int mark;
	public Card[] deliver(int number) {
		//新的容器
		Card[] c=new Card[number];
		//填满新的容器
		for(int i=0;i<number;i++) {
			
			c[i]=porker.getCards()[mark++];
		}
		return c;
	}
	
	
}
