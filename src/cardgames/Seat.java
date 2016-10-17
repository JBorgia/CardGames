package cardgames;

import java.util.ArrayList;
import java.util.List;

/*abstract seat: subclasses include Player and Dealer*/
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

	/* gets total value of hand */
	public int getTotal() {
		int sum = 0;
		for (Card card : hand) {
			sum += card.Value();
		}
		return sum;
	}

	/* displays hand */
	public void displayHand() {
		for (Card card : hand) {
			System.out.println(card);
		}
		CardUX.printHand(this.getHand());
		System.out.println("For a total count of " + this.getTotal() + ".");
	}

	/* checks for 'Ace' case and reduces value to 1 if total is over 21 */
	public void setAce() {
		for (Card card : hand) {
			if (this.getTotal() > 21 && card.Value() == 11) {
				card.setValue(1);
			}
		}
	}
}