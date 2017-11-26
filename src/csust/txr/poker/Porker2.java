package csust.txr.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Porker2 {
	ArrayList<Card> cards;
	
	public Porker2() {
		cards=new ArrayList<>();
		for(Suit suit:Suit.values()){
			for(Rank rank:Rank.values()) {
				cards.add(new Card(rank,suit));
			}
		}
	}
	
	public void show() {
		int i=0;
		for(Card card:cards) {
			System.out.print(card+"\t");
			if(i++%13==12)
				System.out.println();
		}
	}
	
	private void shuffle() {
		Collections.shuffle(cards);
	}
	
	public static void main(String args[]) {
		Porker2 porker2=new Porker2();
		
		System.out.println(porker2.cards.size());
		porker2.show();
		
		porker2.shuffle();
		
		List<Card> list1=porker2.cards.subList(0,13);
		System.out.println(list1);
		Collections.sort(list1);
		System.out.println(list1);
	}
}
