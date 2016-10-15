package cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {
	List<Card> shoe = new ArrayList<>();

	Shoe(int numDecks) {
		for (int i = 0; i < numDecks; i++) {
			shoe.addAll(new Deck().getDeck());
		}
		Collections.shuffle(shoe);
	}

	public Card getCard(int index) {
		return shoe.get(index);
	}

	public void removeCard(int index) {
		this.shoe.remove(index);
	}
}
