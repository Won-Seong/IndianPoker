package indian_poker;
import java.util.Scanner;

public final class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Dealer dealer = new Dealer();
		Gamer gamer = new Gamer();
		Computer computer = new Computer();
		boolean firstBet = true; // true is Gamer first, false is computer first

		System.out.println("Shuffle deck.");
		dealer.shuffle();
		System.out.println("Game start!\n");

		while (gamer.getChip() > 0 && computer.getChip() > 0) {
			int tableChip = 0;
			int gamerBetChip;
			int comBetChip;
			System.out.println("Dealer deal the cards.");
			gamer.setCard(dealer.dealCard());
			computer.setCard(dealer.dealCard());

			System.out.println("You and your opponent bet a chip each.\n");

			gamer.modifyChip(-1);
			computer.modifyChip(-1);
			tableChip += 2;

			System.out.println("Your status is : " + gamer.toString());
			System.out.println("Opponent status is : " + computer.toString() + "\n");

			if (firstBet == true) {
				System.out.println("You bet first.");
				gamerBetChip = gamer.betChip(computer.getCard(),scanner);
				if(gamerBetChip == 0) {
					comBetChip = computer.betChip(gamer.getCard(),scanner);
					gamerBetChip = gamer.betChip(computer.getCard(), comBetChip,scanner);
				}
				else {
					comBetChip = computer.betChip(gamer.getCard(), gamerBetChip);
					if(comBetChip != -1)
						System.out.println("Opponent did call");
				}
			} else {
				System.out.println("Computer bet first.");
				comBetChip = computer.betChip(gamer.getCard(),scanner);
				gamerBetChip = gamer.betChip(computer.getCard(), comBetChip,scanner);
			}
			
			System.out.println("");

			if (gamerBetChip == -1) {
				System.out.println("You died. Opponent get the chips.");
				computer.modifyChip(tableChip + comBetChip);
				System.out.println("Your card : " + gamer.getCard().getNumber());
				System.out.println("Opponent card : " + computer.getCard().getNumber() + "\n");
				System.out.println("Next game.");
				System.out.println("=================================================================\n");
				continue;
			} else if (comBetChip == -1) {
				System.out.println("Opponent died. You get the chips.");
				gamer.modifyChip(tableChip + gamerBetChip);
				System.out.println("Your card : " + gamer.getCard().getNumber());
				System.out.println("Opponent card : " + computer.getCard().getNumber() + "\n");
				System.out.println("Next game.");
				System.out.println("=================================================================\n");
				continue;
			}
			
			tableChip += gamerBetChip + comBetChip;

			System.out.println("\nBetting is over, cards open.");
			System.out.println("Your card : " + gamer.getCard().getNumber());
			System.out.println("Opponent card : " + computer.getCard().getNumber() + "\n");

			GameResult result = gamer.getCard().isBiggerThan(computer.getCard());

			switch (result) {
			case WIN:
				System.out.println("You win! you get the chips.");
				gamer.modifyChip(tableChip);
				firstBet = false;
				break;
			case TIE:
				System.out.println("Two number is tie! chips return.");
				gamer.modifyChip(tableChip / 2);
				computer.modifyChip(tableChip / 2);
				break;
			case LOSE:
				System.out.println("You lose! your opponent get the chips.");
				computer.modifyChip(tableChip);
				firstBet = true;
				break;

			default:
				break;
			}

			System.out.println("\nNext game.");
			System.out.println("=================================================================\n");

		}
		scanner.close();

	}

}
