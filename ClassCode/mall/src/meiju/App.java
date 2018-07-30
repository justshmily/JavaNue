package csust.txr.meiju;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		
		Game game=new Game();
		//game.getPorker().display();
		System.out.println();
		game.shuffle();		
		game.getPorker().display();
		
		Card[] card1=game.deliver(3);
		Card[] card2=game.deliver(3);
		Card[] card3=game.deliver(3);
		System.out.println(Arrays.toString(card1));
		System.out.println(Arrays.toString(card2));
		System.out.println(Arrays.toString(card3));

	}

}
