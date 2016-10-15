package cardgames;

import java.util.ArrayList;
import java.util.List;

public abstract class Seat {
	List<Card> hand = new ArrayList<>();

	public Seat() {
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(Card card) {
		this.hand.add(card);
	}

	public void resetHand() {
		this.hand.clear();
	}

	public int getTotal() {
		int sum = 0;
		for (Card card : hand) {
			sum += card.Value();
		}
		return sum;
	}

	public void displayHand() {
		for (Card card : hand) {
				System.out.println(card);
		}
		System.out.println("For a total count of " + this.getTotal() + ".");
	}

	public void setAce() {
		if (this.getTotal() > 21 && this.getHand().get(0).Value() == 11) {
			this.getHand().get(0).setValue(1);
		} else if (this.getTotal() > 21 && this.getHand().get(1).Value() == 11) {
			this.getHand().get(1).setValue(1);
		}
	}
}