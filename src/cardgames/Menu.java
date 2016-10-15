package cardgames;

import java.util.Scanner;

public class Menu {
	static BlackJackConfig config = new BlackJackConfig();
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		mainNav();
	}

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

	private static int mainMenu() {
		int level = 0;
		CardUX.welcome();
		String menuList[] = { "---- Main Menu ----\n", "New Game", "Options", "Quit" };
		do {
			for (int i = 0; i < menuList.length; i++) {
				if (i > 0) {
					System.out.printf(" %1$2s. ", i);
				}
				System.out.println(menuList[i]);
			}
			System.out.print("\n>>");

			level = kb.nextInt();
			if (level < 1 || level >= menuList.length) {
				System.out.println(level + " is not a valid options. Please select again.");
			}
		} while (level < 1 || level >= menuList.length);
		return level;
	}
}
