package cardgames;

import java.util.Scanner;
/*holds settings and acts as a reference for other parts of the program*/
public class BlackJackConfig {
	private static int NumberofPlayers = 2;
	private static int StartingCash = 1500;
	private static int MinimumBid = 5;
	private static int MaximumBid = 500;
	private static int WinningAmmount = 10_000;
	private static int NumberOfDecks = 5;

	static Scanner kb = new Scanner(System.in);

	public void menu() {
		int choice=0;
		do {
			System.out.println("---- Game Options ----");
			System.out.println(" 1. Number of Players:\t" + getNumberofPlayers());
			System.out.println(" 2. Number of Decks:\t" + getNumberOfDecks());
			System.out.println(" 3. Starting Cash:\t" + getStartingCash());
			System.out.println(" 4. Minimum Bid:  \t" + getMinimumBid());
			System.out.println(" 5. Maximum Bid:  \t" + getMaximumBid());
			System.out.println(" 6. Winning Ammount:\t" + getWinningAmmount());
			System.out.println(" 7. Return to Main Menu");

			System.out.print("\n>>");
			if (kb.hasNextInt() && (choice < 1 || choice > 7)){
				choice = kb.nextInt();
			}else {
				System.out.println("That is not a valid option. Please select a number from the options available.");
			}
			kb.nextLine();
			
			switch (choice) {
			case 1:
				System.out.print("Set the number of players: ");
				setNumberofPlayers(kb.nextInt());
				break;
			case 2:
				System.out.print("Set number of decks: ");
				setNumberOfDecks(kb.nextInt());
				break;
			case 3:
				System.out.print("Set starting cash: ");
				setStartingCash(kb.nextInt());
				break;
			case 4:
				System.out.print("Set minimum bid ammount: ");
				setMinimumBid(kb.nextInt());
				break;
			case 5:
				System.out.print("Set maximum bid ammount: ");
				setMaximumBid(kb.nextInt());
				break;
			case 6:
				System.out.print("Set winning ammount (enter 0 for unlimited play): ");
				setWinningAmmount(kb.nextInt());
				break;
			case 7:
				break;
			default:
				System.out.println(choice + " is not a valid options. Please select again.");
			}

		} while (choice != 7);
	}

	static int getNumberofPlayers() {
		return NumberofPlayers;
	}

	private static void setNumberofPlayers(int numberofPlayers) {
		NumberofPlayers = numberofPlayers;
	}

	static int getStartingCash() {
		return StartingCash;
	}

	private static void setStartingCash(int startingCash) {
		StartingCash = startingCash;
	}

	static int getMinimumBid() {
		return MinimumBid;
	}

	private static void setMinimumBid(int minimumBid) {
		MinimumBid = minimumBid;
	}

	static int getMaximumBid() {
		return MaximumBid;
	}

	static void setNumberOfDecks(int numberOfDecks) {
		NumberOfDecks = numberOfDecks;
	}

	static int getNumberOfDecks() {
		return NumberOfDecks;
	}

	private static void setMaximumBid(int maximumBid) {
		MaximumBid = maximumBid;
	}

	static int getWinningAmmount() {
		return WinningAmmount;
	}

	private static void setWinningAmmount(int winningAmmount) {
		WinningAmmount = winningAmmount;
	}

}
