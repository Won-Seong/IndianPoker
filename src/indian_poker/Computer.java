package indian_poker;
import java.util.Scanner;
public final class Computer extends Player {

	int braveDegree = (int) Math.random() * 10 + 1;

	@Override
	public String toString() {
		return "Computer [chip=" + chip + ", card=" + card + "]";
	}

	@Override
	public int betChip(Card card, Scanner scanner) {
		// TODO Auto-generated method stub
		int betToChip;

		double probability = Math.random() * 100;

		if (probability >= card.getNumber() * 10 - braveDegree) {
			betToChip = (int) Math.random() * 4 + (5 - (card.getNumber() / 2));
		} else {
			betToChip = (int) Math.random() * 3 + 1;
			if (braveDegree >= 6)
				betToChip++;
			else if (braveDegree < 4 && betToChip >= 2)
				betToChip--;
		}
		
		if(betToChip >= chip) {
			betToChip = chip;
			chip = 0;
			return betToChip;
		} else {
			chip -= betToChip;
			return betToChip;
		}
			
			
	}

	public int betChip(Card card, int gamer_chip) {
		int betToChip;
		double probability = Math.random() * 100;

		if (probability >= card.getNumber() * 10 - braveDegree) {
			betToChip = gamer_chip;
		} else {
			return -1;
		}
		
		if(betToChip >= chip) {
			betToChip = chip;
			chip = 0;
			return betToChip;
		} else {
			chip -= betToChip;
			return betToChip;
		}
	}

}
