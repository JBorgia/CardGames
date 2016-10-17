package cardgames;

public class Dealer extends Seat {
	/*displays gameplay version of dealer hand: only shows 2nd cards dealt*/
	public void displayHand() {
		System.out.println("The dealer is showing " + this.getHand().get(1).DisplayL());
		CardUX.printHand(this.getHand(), true);
	}
	/*Displays final reveal for dealer hand*/
	public void displayFullHand() {
		System.out.println("The dealer had...");
		for (Card card : this.getHand()) {
			System.out.println(card);
		}

		CardUX.printHand(this.getHand());
		System.out.println("For a total count of " + this.getTotal() + ".");
	}
}
