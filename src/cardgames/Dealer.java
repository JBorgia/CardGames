package cardgames;

public class Dealer extends Seat {
	public void displayHand() {
		System.out.println("The dealer has...");
		for (Card card : this.getHand()) {
			System.out.println(card);
		}
//		System.out.println("The dealer is showing " + this.getHand().get(1).DisplayL());
		System.out.println("For a total count of " + this.getTotal() + ".");
	}

	public void displayFullHand() {
		System.out.println("The dealer had...");
		for (Card card : this.getHand()) {
			System.out.println(card);
		}
		System.out.println("For a total count of " + this.getTotal() + ".");
	}
}
