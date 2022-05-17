package indian_poker;

public final class Card {
	
	

	private final int number;
	
	Card(int number){
		this.number = number;
	}
	
	@Override
	public String toString() {
		return String.valueOf(number);
	}
	
	public GameResult isBiggerThan(Card card) {
		
		if(this.number > card.number)
			return GameResult.WIN;
		else if(this.number == card.number)
			return GameResult.TIE;
		else if(this. number < card.number)
			return GameResult.LOSE;
		
		return GameResult.TIE;
		
	}

	
	
	public final int getNumber() {
		return number;
	}
	
	
}
