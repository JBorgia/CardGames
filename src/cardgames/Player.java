package cardgames;
/*creates players and stores player data*/
public class Player extends Seat {
	private int number;
	private int balance;
	private int bet;

	public Player(int number, int balance) {
		this.number = number;
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
}
