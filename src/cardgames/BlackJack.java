package cardgames;

import java.util.Scanner;
/*BlackJack contains the methods and files for each game*/
public class BlackJack {
	Scanner kb = new Scanner(System.in);
	private Shoe shoe;
	private Table table;
	/*Initiates a new game and creates and loads the table with players as specified by BlackJackConfig*/
	public void play() {
		boolean continuePlay = true;
		char choice = 'y';
		shoe = new Shoe(BlackJackConfig.getNumberOfDecks());
		table = new Table(BlackJackConfig.getNumberofPlayers());
		while (continuePlay && check()) {
			round();
			pollPay();
			checkBankrupt();
			if (check()) {
				System.out.print("How about we go another round? (y/n) >>");
				choice = kb.next().toLowerCase().charAt(0);
				if (choice == 'n') {
					continuePlay = false;
				}
			}
		}
	}
	/*round runs through the logic for each round of play*/
	void round() {
		boolean dealerBlackJack = false;
		for (Seat seat : table.getTable()) {
			if (seat instanceof Player) {
				pollBets((Player) seat);
			}
		}
		for (int i = 0; i < 2; i++) {
			for (Seat seat : table.getTable()) {
				dealCards(seat);
			}
		}
		if (table.getTable().get(table.getTable().size() - 1) instanceof Dealer) {
			dealerBlackJack = check4BlackJack((Dealer) table.getTable().get(table.getTable().size() - 1));

		}
		if (dealerBlackJack) {
			System.out.println("Oh no! The dealer has a Black Jack!");
		} else {
			for (Seat seat : table.getTable()) {
				turn(seat);
			}
		}
		if (table.getTable().get(table.getTable().size() - 1) instanceof Dealer) {
			((Dealer) table.getTable().get(table.getTable().size() - 1)).displayFullHand();
		}
	}
	/*Collects bet amounts from each player*/
	void pollBets(Player player) {
		int bet;
		do {
			System.out.print("Player " + player.getNumber() + ", place a bet between " + BlackJackConfig.getMinimumBid()
					+ " and " + BlackJackConfig.getMaximumBid() + ": ");
			bet = kb.nextInt();
			if (bet < BlackJackConfig.getMinimumBid()) {
				System.out.println("That bet is too low. Please enter a higher ammount.");
			} else if (bet > BlackJackConfig.getMaximumBid()) {
				System.out.println("That bet is too high. Please enter a lower ammount.");
			}
		} while (bet < BlackJackConfig.getMinimumBid() || bet > BlackJackConfig.getMaximumBid());
		player.setBet(bet);
	}
	/*distributes cards to each player and the dealer, removing them from the shoe*/
	void dealCards(Seat seat) {
		seat.setHand(shoe.getCard(0));
		if (seat.getTotal() > 21) {
			seat.setAce();
		}
		if (seat instanceof Player && seat.getHand().size() > 2) {
			System.out.println("You got a " + shoe.getCard(0) + ", for a new total of " + seat.getTotal());
		}
		shoe.removeCard(0);
	}
	/*Checks for the case of the dealer getting a black jack right off the bat*/
	boolean check4BlackJack(Dealer dealer) {
		if (dealer.getTotal() == 21) {
			return true;
		} else {
			return false;
		}
	}
	/*checks for winners and pays out according to the bets placed*/
	void pollPay() {
		int dealerHand = table.getTable().get(table.getTable().size() - 1).getTotal();
		for (Seat seat : table.getTable()) {
			if (seat instanceof Player) {
				int playerHand = ((Player) seat).getTotal();
				if (playerHand == dealerHand) {
					System.out.println(
							"You and the dealer tied, player " + ((Player) seat).getNumber() + "! It is a push!");
					System.out.println("You have a current balance of $" + ((Player) seat).getBalance());
				} else if (playerHand < 22 && (playerHand > dealerHand || dealerHand > 21)) {
					System.out.print("Congradulations, player " + ((Player) seat).getNumber() + ", you won $"
							+ ((Player) seat).getBet());
					((Player) seat).setBalance(((Player) seat).getBalance() + ((Player) seat).getBet());
					System.out.println(" and have a total balance of $" + ((Player) seat).getBalance());
				} else if (playerHand > 21 || playerHand < dealerHand) {
					System.out.print(
							"Sorry, player " + ((Player) seat).getNumber() + ", you lost $" + ((Player) seat).getBet());
					((Player) seat).setBalance(((Player) seat).getBalance() - ((Player) seat).getBet());
					System.out.println(" and have a total balance of $" + ((Player) seat).getBalance());
				} else {
					System.out.println("pollPlay error");
				}
				((Player) seat).setBet(0);
			}
			seat.resetHand();
		}
	}
	/*polls each player for how they want to handle each turn*/
	void turn(Seat seat) {
		char choice = '0';
		if (seat instanceof Player) {
			if (seat.getTotal() == 21) {
				System.out
						.println("Congradulations player " + ((Player) seat).getNumber() + ", you have a Black Jack!");
			} else {
				System.out.println("Player " + ((Player) seat).getNumber() + ", it is your turn.");
				table.getTable().get(table.getTable().size() - 1).displayHand();
				do {
					System.out.println("You have: ");
					seat.displayHand();
					System.out.print("Do you want to (h)it or (s)tay? >>");
					choice = kb.next().toLowerCase().charAt(0);
					if (choice == 'h') {
						dealCards(seat);
					} else if (choice != 's') {
						System.out.println("That is not a valid reponse. Please pick again.");
					}
					if (seat.getTotal() > 21) {
						System.out.println("Oh no! " + seat.getTotal() + ". You busted!");
					}
				} while (choice != 's' && seat.getTotal() < 21);
			}
		}
		if (seat instanceof Dealer) {
			do {
				if (seat.getTotal() < 17) {
					dealCards(seat);
				}
				if (seat.getTotal() > 21) {
					seat.setAce();
					if (seat.getTotal() > 21) {
						System.out.println("The dealer busted! Hopefully, you didn't.");
					}
				}
			} while (seat.getTotal() < 17 && seat.getTotal() < 21);
		}
	}
	/*checks each player to see if they have gone bankrupt, removing them from the game if they are*/
	private void checkBankrupt() {
		for (Seat seat : table.getTable()) {
			if (seat instanceof Player) {
				if (((Player) seat).getBalance() <= 0) {
					System.out.println("Sorry player " + ((Player) seat).getNumber()
							+ ", you are bankrupt! Hope you don't loose any kneecaps over this.");
					table.getTable().remove(table.getTable().indexOf(seat));
					checkBankrupt();
					break;
				}
			}
		}
	}
	/*checks to see if any players remain in the game*/
	private boolean check() {
		if (table.getTable().size() <= 1) {
			return false;
		} else {
			return true;
		}
	}
}
