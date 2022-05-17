package indian_poker;

import java.util.Scanner;

public class Gamer extends Player {

	@Override
	public String toString() {
		return "Gamer [chip=" + chip + "]";
	}

	@Override
	public int betChip(Card card, Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Opponent's card number is : " + card.getNumber());
		int chipToBet;

		do {
			System.out.println("How many do you bet? You have " + chip + " chips. if you want to check, bet zero.");
			chipToBet = scanner.nextInt();
			if (chipToBet > chip) {
				System.out.println("You can't bet more than your own!");
			} else if (chipToBet < 0) {
				System.out.println("You can't bet less than zero!");
			}
		} while (chipToBet > chip || chipToBet < 0);

		scanner.nextLine();
		System.out.println("\nYou bet " + chipToBet);
		chip -= chipToBet;

		return chipToBet;
	}

	public int betChip(Card card, int OpponentBetChip, Scanner scanner) {
		System.out.println("Opponent's card number is : " + card.getNumber());
		System.out.println("Opponent bet " + OpponentBetChip);
		int chipToBet;
		do {
			System.out.println("You wanna call or die? You have " + chip + " chips.(call, die)");
			String str = scanner.nextLine();
			if (str.equals("call") && chip >= OpponentBetChip)
				chipToBet = OpponentBetChip;
			else if (str.equals("call") && chip < OpponentBetChip)
				chipToBet = chip;
			else if (str.equals("die")) {
				chipToBet = -1;
				return chipToBet;
			} else {
				System.out.println("You should say only call or die.");
				continue;
			}
			break;
		} while (true);

		chip -= chipToBet;
		return chipToBet;
	}

}
