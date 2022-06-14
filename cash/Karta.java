package cash;

public class Karta {
	String Card_ID;
	Virtual_Cash contents;
	String Bank;
	String Account_ID;
	Konto main;
	public Karta(String Card_ID, double worth, String Bank, String Account_ID, Konto main){
		this.main = main;
		main.cards.add(this);
		this.Card_ID = Card_ID;
		this.Account_ID = Account_ID;
		this.Bank = Bank;
		contents = new Virtual_Cash(worth);
	}
	
	public Boolean Withdraw (double _withdraw) {
		return contents.withdraw(_withdraw);
	}
}
