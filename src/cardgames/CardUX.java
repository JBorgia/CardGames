package cardgames;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardUX {
	static Map<String, String[]> GFXcards = new HashMap<>();

	/*welcome banner*/
	public static void welcome() {
		final String banner[] = { 	"              __\n", "        _..-''--'----_.\n", "      ,''.-''| .---/ _`-._ \n",
									"    ,' \\ \\  ;| | ,/ / `-._`-.\n", "  ,' ,',\\ \\( | |// /,-._  / /\n",
									"  ;.`. `,\\ \\`| |/ / |   )/ /\n", " / /`_`.\\_\\ \\| /_.-.'-''/ /\n", "/ /_|_:.`. \\ |;'`..')  / /\n",
									"`-._`-._`.`.;`.\\  ,'  / / \t.------..------..------..------.\n",
									"    `-._`.`/    ,'-._/ /   \t|C.--. ||A.--. ||R.--. ||D.--. |\n",
									"      : `-/     \\`-.._/   \t| :/\\: || (\\/) || :(): || :/\\: |\n",
									"      |  :      ;._ (      \t| :\\/: || :\\/: || ()() || (__) |\n",
									"      :  |      \\  ` \\   \t| '--'C|| '--'A|| '--'R|| '--'D|\n",
									"       \\         \\   |   \t`------'`------'`------'`------'\n",
									"        :        :   ;     \t.------..------..------..------..------.\n",
									"        |           /      \t|G.--. ||A.--. ||M.--. ||E.--. ||S.--. |\n",
									"        ;         ,'       \t| :/\\: || (\\/) || (\\/) || (\\/) || :/\\: |\n",
									"       /         /         \t| :\\/: || :\\/: || :\\/: || :\\/: || :\\/: |\n",
									"      /         /          \t| '--'G|| '--'A|| '--'M|| '--'E|| '--'S|\n",
									"               /           \t`------'`------'`------'`------'`------'\n" };
		for (String string : banner) {
			System.out.print(string);
		}
	}
	/*overloaded call to pringHand, setting dealer case to false*/
	public static void printHand(List<Card> hand) {
		printHand(hand, false);
	}
	/*displays ascii representations for cards in hand*/
	public static void printHand(List<Card> hand, boolean dealer) {
		GFXcards.put("back", new String[] { 	".-----------.", 
											"| ♥:♦:♥:♦:♥ |", 
											"| :♠:♣:♠:♣: |", 
											"| ♥:♦:♥:♦:♥ |",
											"| :♠:♣:♠:♣: |", 
											"| ♥:♦:♥:♦:♥ |", 
											"| :♠:♣:♠:♣: |", 
											"| ♥:♦:♥:♦:♥ |", 
											"| :♠:♣:♠:♣: |",
											"| ♥:♦:♥:♦:♥ |", 
											"`-----------'" });
		GFXcards.put("A", new String[] { 	" ----------- ", 
											"| %1$-2s        |", 
											"|           |", 
											"|           |",
											"|           |", 
											"|     %2$1s     |", 
											"|           |", 
											"|           |", 
											"|           |", 
											"|        %1$2s |", 
											"`-----------'" });
		 GFXcards.put( "2", new String[] { 	".-----------.", 
											"| %1$-2s        |", 
											"|        %2$1s  |", 
											"|           |", 
											"|           |", 
											"|           |", 
											"|           |", 
											"|           |", 
											"|  %2$1s        |", 
											"|        %1$2s |", 
											"`-----------'" });
		
		 GFXcards.put( "3", new String[] { 		" ----------- ", 
												"| %1$-2s        |",
												"|        %2$1s  |",  
												"|           |",  
												"|           |", 
												"|     %2$1s     |",
												"|           |",  
												"|           |", 
												"|  %2$1s        |", 
												"|        %1$2s |",  
		 										"`-----------'" });
		
		 GFXcards.put( "4", new String[] { 		".-----------.", 
												"| %1$-2s        |",
				 								"|  %2$1s     %2$1s  |",
												"|           |", 
												"|           |", 
												"|           |", 
												"|           |", 
												"|           |", 
				 								"|  %2$1s     %2$1s  |",
												"|        %1$2s |",  
				 								"`-----------'" });
		
		 GFXcards.put( "5", new String[] { 		".-----------.", 
												"| %1$-2s        |",
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|           |", 
												"|     %2$1s     |",
												"|           |", 
												"|           |", 
				 								"|  %2$1s     %2$1s  |",
												"|        %1$2s |",  
				 								"`-----------'" });
		
		 GFXcards.put( "6", new String[] { 		".-----------.", 
												"| %1$-2s        |",
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|        %1$2s |",  
												"`-----------'" });
		
		 GFXcards.put( "7", new String[] { 		".-----------.", 
				 								"| %1$-2s        |",
				 								"|  %2$1s     %2$1s  |",
				 								"|           |", 
												"|     %2$1s     |",
				 								"|  %2$1s     %2$1s  |",
				 								"|           |", 
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|        %1$2s |",  
												"`-----------'" });
		
		 GFXcards.put( "8", new String[] { 		".-----------.", 
												"| %1$-2s        |",
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|        %1$2s |",  
												"`-----------'" });
		
		 GFXcards.put( "9", new String[] { 		".-----------.", 
												"| %1$-2s        |",
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|     %2$1s     |",
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|        %1$2s |",  
												"`-----------'" });
			
		 GFXcards.put( "10", new String[] { 		".-----------.", 
												"| %1$-2s        |",
												"|  %2$1s     %2$1s  |",
												"|     %2$1s     |",
												"|  %2$1s     %2$1s  |",
												"|           |", 
												"|  %2$1s     %2$1s  |",
												"|     %2$1s     |",
												"|  %2$1s     %2$1s  |",
												"|        %1$2s |",  
												"`-----------'" });

			
		 GFXcards.put( "J", new String[] { 		".-----------.", 
												"| %1$-2s        |",
												"| ===  /    |",
												"| o.< / %2$1s / |",
												"| )-(/   /  |",
												"|   / %2$1s /   |",
												"|  /   /=== |",
												"| / %2$1s / o.o |",
												"|    /  )-( |",
												"|        %1$2s |",  
												"`-----------'" });

			
		 GFXcards.put( "Q", new String[] { 		".-----------.", 
												"| %1$-2s        |",
												"| -^-  /    |",
												"| ^,^ / %2$1s / |",
												"| *=*/   /  |",
												"|   / %2$1s /   |",
												"|  /   /-^- |",
												"| / %2$1s / ^,^ |",
												"|    /  *=* |",
												"|        %1$2s |",  
												"`-----------'" });

			
		 GFXcards.put( "K", new String[] { 		".-----------.", 
												"| %1$-2s        |",
												"| xxx  /    |",
												"| O,O / %2$1s / |",
												"| {-}/   /  |",
												"|   / %2$1s /   |",
												"|  /   /xxx |",
												"| / %2$1s / -.O |",
												"|    /  {-} |",
												"|        %1$2s |",  
												"`-----------'" });

		StringBuilder line = new StringBuilder();
		
		String cards[] = new String[11];
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j<hand.size(); j++) {
				if(dealer && j == 0){
					line.append(GFXcards.get("back")[i]);
				} else {
					line.append(String.format(GFXcards.get(hand.get(j).NameS())[i], hand.get(j).NameS(), hand.get(j).SuitSymbol()));
				}
			}
			cards[i] = line.toString();
			line = new StringBuilder();
		}
		for (String string : cards) {
			System.out.println(string);
		}
	}
}