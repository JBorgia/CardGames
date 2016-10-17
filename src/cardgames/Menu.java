package cardgames;

import java.util.Scanner;

public class Menu {
	static BlackJackConfig config = new BlackJackConfig();
	static Scanner kb = new Scanner(System.in);
	/*Main for program*/
	public static void main(String[] args) {
		mainNav();
	}
	/*processes selection*/
	public static void mainNav() {
		int choice = 0;
		while (choice != 3) {
			choice = mainMenu();
			switch (choice) {
			case 1:
				BlackJack game = new BlackJack();
				game.play();
				break;
			case 2:
				config.menu();
				break;
			case 3: // quit
				break;
			default:
			}
		}
	}
	/*lists options and collects user selection*/
	private static int mainMenu() {
		int level = 0;
		CardUX.welcome();

		do {
			System.out.println();
			System.out.println("---- Main Menu ----");
			System.out.println(" 1. New Game");
			System.out.println(" 2. Options");
			System.out.println(" 3. Quit");
			System.out.print("\n>>");

			if (kb.hasNextInt() && (level < 1 || level > 3)){
				level = kb.nextInt();
			}else {
				System.out.println("That is not a valid option. Please select a number from the options available.");
			}
			kb.nextLine();
		} while (level < 1 || level > 3);
		return level;
	}
}
