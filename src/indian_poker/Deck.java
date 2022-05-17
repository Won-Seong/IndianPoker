package indian_poker;
import java.util.List;
import java.util.Vector;

public final class Deck {
	
	private List<Card> cards = new Vector<Card>(21);
	
	Deck(){
		
		for(int i = 1 ; i <=10 ; i++) {
			cards.add(new Card(i));
			cards.add(new Card(i));
		}
		
	}
	
	public void shuffle() {
		
		for(int i = 0 ; i < 40 ; i++) {
			cards.add(cards.remove((int)(Math.random() * 19)));
		}
		
	}
	
	public Card draw_card() {
		return cards.remove(cards.size() - 1);
	}
	
	
}
