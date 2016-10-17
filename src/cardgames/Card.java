package cardgames;
/*Creates and holds values for card*/
public class Card {
	private int value;
	private String nameL;
	private String nameS;
	private SuitWords suitWord;
	private char suitSymbol;
	private char suitSymbols[] = { '\u2665', '\u2660', '\u2666', '\u2663' };
	private String names[][] = { { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" }, { "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" } };

	public Card() {
	}

	public Card(SuitWords suit) {
		setSuitWord(suit);
	}

	public Card(SuitWords suitWord, int nameNum, int value) {
		setSuitWord(suitWord);
		setName(nameNum);
		setValue(value);
	}

	public SuitWords getSuitWord() {
		return suitWord;
	}

	public void setSuitWord(SuitWords suitWord) {
		this.suitWord = suitWord;
		setSuitSymbol(suitWord);
	}

	public char SuitSymbol() {
		return suitSymbol;
	}

	public void setSuitSymbol(SuitWords suitWord) {
		this.suitSymbol = suitSymbols[suitWord.ordinal()];
	}

	public String NameL() {
		return nameL;
	}

	public String NameS() {
		return nameS;
	}

	public void setName(int numWord) {
		this.nameL = names[1][numWord];
		this.nameS = names[0][numWord];
	}
	
	public int Value() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public String DisplayL() {
		if (this.Value() == 11) {
			return "an " + NameL() + " of " + suitWord + "(" + SuitSymbol() + ")";
		} else {
			return "a " + NameL() + " of " + suitWord + "(" + SuitSymbol() + ")";
		}
	}

	public String DisplayS() {
		if (this.Value() == 11) {
			return "an " + String.format("%1$2s", NameS()) + "" + SuitSymbol();
		} else {
			return "a " + String.format("%1$2s", NameS()) + "" + SuitSymbol();
		}
	}

	@Override
	public String toString() {
		return this.DisplayL();
	}

}