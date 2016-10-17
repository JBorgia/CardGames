package cardgames;
/*holds players at the table*/
import java.util.ArrayList;
import java.util.List;

public class Table {
	List<Seat> table = new ArrayList<>();

	public Table(int numPlayers) {
		for (int i = 0; i < numPlayers; i++) {
			table.add(new Player(i + 1, BlackJackConfig.getStartingCash()));
		}
		table.add(new Dealer());
	}

	public List<Seat> getTable() {
		return table;
	}

	public void setTable(List<Seat> table) {
		this.table = table;
	}
}
