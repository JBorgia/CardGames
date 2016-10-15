package cardgames;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();

	public Deck() {
		for (SuitWords S : SuitWords.values()) {
			for (int i = 0; i < 13; i++) {
				int value = 0;
				if (i == 12) {
					value = 11; // standard 'Ace'
								// value is 11.
								// altValue is
								// set by game
				} else if (i < 10 - 2) {
					value = i + 2; // 2 through 9 are
									// sent to standard
									// values equivalent
									// to their names
				} else if (i >= 10 - 2 && i < 12) {
					value = 10; // 10 and face
								// cards are set
								// to standard
								// values of 10
				} else {
					System.out.println("Error: too many cards!");
				}
				deck.add(new Card(S, i, value));
			}
		}
	}

	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}

	public void display() {
		for (Card card : deck) {
			System.out.println(card);
		}
	}

	public List<Card> getDeck() {
		return deck;
	}

}
