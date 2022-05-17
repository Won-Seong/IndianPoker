package indian_poker;
import java.util.Scanner;

public abstract class Player {

	protected int chip;
	protected Card card;

	Player() {
		chip = 20;
		card = null;
	}

	public final int getChip() {
		return chip;
	}

	public final void modifyChip(int chip) {
		this.chip += chip;
	}

	public final Card getCard() {
		return card;
	}

	public final void setCard(Card card) {
		this.card = card;
	}
	
	public abstract int betChip(Card card, Scanner scanner);
	
	

}
