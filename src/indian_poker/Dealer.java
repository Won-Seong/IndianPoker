package indian_poker;

public final class Dealer {
	
	private Deck deck;
	
	
	Dealer(){
		deck = new Deck();
	}
	
	public void shuffle() {
		deck.shuffle();
	}
	
	public Card dealCard() {
		return deck.draw_card();
	}
	
}
