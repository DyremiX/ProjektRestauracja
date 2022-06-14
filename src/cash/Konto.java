package cash;

import java.util.ArrayList;

public class Konto {
	String bank;
	String Account_ID;
	ArrayList<Karta> cards;
	public Konto(String Bank, String Account_ID) {
		this.bank = Bank;
		this.Account_ID = Account_ID;
		cards = new ArrayList<Karta>();
	}
	public double worth() {
		int suma = 0;
		for(Karta i : cards) {
			suma += i.contents.worth;
		}
		return suma;
	}
}
